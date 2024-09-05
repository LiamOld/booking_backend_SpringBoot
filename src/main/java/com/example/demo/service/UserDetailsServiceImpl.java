package com.example.demo.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.DAO.DaoMySQL;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder pw;
    @Autowired
    private DaoMySQL doaMysql;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<com.example.demo.model.User> userOptional = doaMysql.getUser(username);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        com.example.demo.model.User user = userOptional.get();
        String passwordFromDatabase = pw.encode(user.getPassword());
        String role = user.getRole();

        // org.springframework.security.core.userdetails.User;
        return User.withUsername(username)
                .password(passwordFromDatabase) // Use the stored encoded password
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList(role))
                .build();
    }

}
