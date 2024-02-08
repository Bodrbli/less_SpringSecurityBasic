package org.mihailovo.less_springsecuritybasic.config;

import org.mihailovo.less_springsecuritybasic.model.Role;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

                                         //АВТОРИЗАЦИЯ и АУТЕНТИФИКАЦИЯ НА ОСНОВЕ РОЛЕЙ
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                //объявляем запросы нуждающиеся в авторизации
                .authorizeRequests()
                //постепенно добавляем запросы с все более широкими полномочиями
                .antMatchers(HttpMethod.GET, "/api/customers/all").hasAnyRole(Role.USER.name(), Role.ADMIN.name(), Role.LOSER.name())
                .antMatchers(HttpMethod.POST, "/api/customers/**").hasAnyRole(Role.ADMIN.name(), Role.USER.name())
                .antMatchers( "/api/customers/**").hasRole(Role.ADMIN.name())
                //рзарешаем всем доступ к домашней странице
                .antMatchers("/").permitAll()
                .and()
                //объявляем аутентификацию в заголовках запроса
                .httpBasic();
    }


    //добавляет кодирование пороля роли .password(encoder().encode("admin"))
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("admin")
                        .password(encoder().encode("admin"))
                        .roles(Role.ADMIN.name())
                        .build(),
                User.builder()
                        .username("user")
                        .password(encoder().encode("user"))
                        .roles(Role.USER.name())
                        .build(),
                User.builder()
                        .username("loser")
                        .password(encoder().encode("loser"))
                        .roles(Role.LOSER.name())
                        .build());
    }
}
