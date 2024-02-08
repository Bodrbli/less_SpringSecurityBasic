package org.mihailovo.less_springsecuritybasic.config;

import org.mihailovo.less_springsecuritybasic.model.user.Role;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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
@EnableGlobalMethodSecurity(prePostEnabled = true) //включает возможность в самом контроллере выбирать разрешение для конкретного метода
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

                                 //Базовая АВТОРИЗАЦИЯ и АУТЕНТИФИКАЦИЯ НА ОСНОВЕ РОЛЕЙ
    /*@Override
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
                        .roles(Role.ADMIN.name())   // для авторизации на основе ролей
                        .build(),
                User.builder()
                        .username("user")
                        .password(encoder().encode("user"))
                        .roles(Role.USER.name())    // для авторизации на основе ролей
                        .build(),
                User.builder()
                        .username("loser")
                        .password(encoder().encode("loser"))
                        .roles(Role.LOSER.name())    // для авторизации на основе ролей
                        .build());
    }*/

                                 // АВТОРИЗАЦИЯ И АУТЕНТИФИКАЦИЯ НА ОСНОВЕ РАЗРЕШЕНИЙ

   /* // до добавления аннотации EnabledGlobalMethodSecurity пишем все, что закомментировано
    // после- добавляем в контроллер аннотацию PreAuthorize
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                //объявляем запросы нуждающиеся в авторизации
                .authorizeRequests()
                //рзарешаем всем доступ к домашней странице
                //.antMatchers( "/").permitAll()
                .anyRequest().authenticated()
                //.antMatchers(HttpMethod.GET, "/api/customers/all").hasAuthority(Authority.CUSTOMER_READ.name())
                //.antMatchers(HttpMethod.POST, "/api/customers/**").hasAuthority(Authority.CUSTOMER_READ.name())
                //.antMatchers(HttpMethod.POST, "/api/customers/").hasAuthority(Authority.CUSTOMER_WRITE.name())
                //.antMatchers(HttpMethod.DELETE, "/api/customers/**").hasAuthority(Authority.CUSTOMER_WRITE.name())
                .and()
                //объявляем аутентификацию в заголовках запроса
                .httpBasic();
    }

    //добавляет кодирование пороля .password(encoder().encode("admin"))
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
                        .authorities(Role.ADMIN.getAuthorities())
                        .build(),
                User.builder()
                        .username("user")
                        .password(encoder().encode("user"))
                        .authorities(Role.USER.getAuthorities())
                        .build(),
                User.builder()
                        .username("loser")
                        .password(encoder().encode("loser"))
                        .authorities(Role.LOSER.getAuthorities())
                        .build());
    }*/
}
