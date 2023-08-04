package org.demoAuthJWT.AuthJWT.service;

import lombok.AllArgsConstructor;
import org.demoAuthJWT.AuthJWT.Repo.UserRepo;
import org.demoAuthJWT.AuthJWT.mapper.UserLoginUserDetails;
import org.demoAuthJWT.AuthJWT.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@AllArgsConstructor
public class UserLoginDetailsService implements UserDetailsService {

    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepo.findByUsername(username);

        return user.map(UserLoginUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username Not Found"));

    }
}
