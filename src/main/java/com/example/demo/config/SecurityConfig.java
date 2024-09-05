package com.example.demo.config;

import com.example.demo.handlers.FailureHandler;
import com.example.demo.handlers.SuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{

    //    build the securityFilterChain
//    this will define the authority of all user
//    useing the @bean to make sure it will generate in the bean factory and could be used in other class
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        // finstly, define the login html page, and the error page.
        http.formLogin((form) -> form
                //login url, must equal to the "action" in login.html
                .loginProcessingUrl("/login")
                // my login page
                .loginPage("/login.html")
                // when login successed, the page would jump to a page which is defined by SuccessHandler()
                .successHandler(new SuccessHandler())
                // when failed, it will jump to the error.html, which is by the FailureHandler()
                .failureHandler(new FailureHandler("error.html"))
        );

        //define the authority of all pages by the user's role
        http.authorizeHttpRequests((requests) -> requests
                // define the login and error page could be accessed by all people, not need login.
                .requestMatchers("/login.html", "/error.html").permitAll()
                // the follow pages are only be accessed by the normal user, with role of "user"
                .requestMatchers("/aboutUs.html", "booking.html", "cancel.html", "canceled.html",
                        "index.html", "your Booking.html").hasRole("user")
                // the following pages are only be accessed by the admin, with the role of "admin"
                .requestMatchers("indexAdmin.html", "addHotelAdmin.html",
                        "addRoomAdmin.html", "roomInformationInquiryAdmin.html").hasRole("admin")
                // others all require be login, no matter what role they have
                .anyRequest().authenticated()
        );

        // disable the wall fire, or any page can't be access
        http.csrf(AbstractHttpConfigurer::disable);

        // build the http and return it
        return http.build();
    }

    // make a bean of a passwordEncoder, which can code and encode the password.
    @Bean
    public PasswordEncoder getPw(){
        return new BCryptPasswordEncoder();
    }

}
