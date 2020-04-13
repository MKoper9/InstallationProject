package com.example.application_service.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/addRadiator").hasAnyAuthority("ROLE_ADMIN", "ROLE_COMPANY")
                .anyRequest()
                .permitAll()
                    .and()
                .csrf().disable()
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .loginProcessingUrl("/login-process")
                    .defaultSuccessUrl("/")
                    .failureUrl("/login_error")
                .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/");
    }

    @Autowired
    DataSource dataSource;
    @Autowired
    PasswdEncoder passwdEncoder;
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .usersByUsernameQuery("SELECT u.email, u.password, status FROM user u WHERE u.email = ?") // wyszukanie użytkownika po adresie email
                .authoritiesByUsernameQuery(
                        "SELECT u.email, r.role_name FROM user u JOIN user_role ur ON (u.user_id = ur.user_id) " +
                                "JOIN role r ON (r.role_id = ur.role_id) WHERE u.email = ?")
                .dataSource(dataSource)
                .passwordEncoder(passwdEncoder.getPasswordEncoder());       // matoda zwracająca algorytm BCryptPasswordEncoder
    }

}
