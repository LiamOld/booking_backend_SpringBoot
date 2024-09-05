package com.example.demo.handlers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class SuccessHandler implements AuthenticationSuccessHandler {

    // rewrite the onAuthenticationSuccess() method, which will make user jump to two different page depended by their role
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        // get the User information from the successful login user.
        User user = (User) authentication.getPrincipal();

        // find the role in the user's getAuthorities
        for (GrantedAuthority authority : user.getAuthorities()) {

            // if the role is admin, jump to the index page design for the admin
            if (authority.getAuthority().equals("ROLE_admin")) {
                // Redirect to indexAdmin.html for users with "admin" role
                response.sendRedirect("/indexAdmin.html");
                return;
            }
        }

        // Redirect to index.html for users without "admin" role
        // there only two roles in my project, so the other role would be "user"
        response.sendRedirect("/index.html");

    }
}
