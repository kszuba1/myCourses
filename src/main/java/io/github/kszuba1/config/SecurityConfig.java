package io.github.kszuba1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public PasswordEncoder getPasswordEncoderStudent(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Configuration
    @Order(1)
    public static class StudentConfigurationAdapter extends WebSecurityConfigurerAdapter {

        public StudentConfigurationAdapter() {
            super();
        }

        @Autowired
        private UserDetailsService userDetailsService;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/student/**").authorizeRequests().anyRequest().hasRole("STUDENT")
                    // log in
                    .and().formLogin().loginPage("/loginStudent").loginProcessingUrl("/student/student_login")
                    // logout
                    .and()
                    .logout()
                    .logoutUrl("/student/student_logout")
                    .logoutSuccessUrl("/?logout")
                    .deleteCookies("JSESSIONID")
                    .and().csrf().disable();
        }
    }

    @Configuration
    @Order(2)
    public static class InstructorConfigurationAdapter extends WebSecurityConfigurerAdapter {

        public InstructorConfigurationAdapter() {
            super();
        }

        @Autowired
        private UserDetailsService userDetailsService;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/instructor/**").authorizeRequests().anyRequest().hasRole("INSTRUCTOR")
                    // log in
                    .and().formLogin().loginPage("/loginInstructor").loginProcessingUrl("/instructor/instructor_login")
                    // logout
                    .and()
                    .logout()
                    .logoutUrl("/instructor/instructor_logout")
                    .logoutSuccessUrl("/")
                    .deleteCookies("JSESSIONID")
                    .and().csrf().disable();
        }
    }

}
