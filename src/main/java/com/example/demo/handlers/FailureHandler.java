package com.example.demo.handlers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

public class FailureHandler implements AuthenticationFailureHandler {

    // define a page url, which would be assigment when is initialized.
    private String url;

    // constructor
    public FailureHandler(String url) {
        this.url = url;
    }

    // rewrite the onAuthenticationFailure() method, which will make user jump to other page.
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.sendRedirect(url);
    }
}