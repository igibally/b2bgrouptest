package com.b2bgroup.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    private static String REALM = "MY_TAXI_REALM";


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {

        UserBuilder users = User.builder();
        String adminPassword = passwordEncoder().encode("admin123");
        auth.inMemoryAuthentication()
            .withUser(users.username("admin").password(adminPassword).roles("ADMIN"));

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.headers().frameOptions().disable();
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/v1/products/*").hasRole("ADMIN")
            .and().httpBasic().realmName(REALM).and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
