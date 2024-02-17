package org.mihailovo.less_springsecuritybasic.security;

import lombok.RequiredArgsConstructor;
import org.mihailovo.less_springsecuritybasic.model.DAO.IRepoUser;
import org.mihailovo.less_springsecuritybasic.model.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final IRepoUser repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("Пользователя с таким именем не существует"));
        return SecurityUser.fromUserEntity(user);
    }
}
