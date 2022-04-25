package ru.learnUp.springboottest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/registration").not().fullyAuthenticated()
                .antMatchers("/api/v1/post").hasAnyRole("ADMIN")
                //.antMatchers("/", "/resources/**").permitAll()
                //.anyRequest().authenticated()
                .anyRequest().denyAll()
                .and()
                .formLogin();
    }

}
