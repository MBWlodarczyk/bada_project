package net.codejava.badabida.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
public class SecurityConfig {

    @Configuration
    @Order(2)
    public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

        private final PracownikDetailServiceImp adminDetailsService;

        public AdminSecurityConfig(PracownikDetailServiceImp adminDetailsService) {
            this.adminDetailsService = adminDetailsService;
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(adminDetailsService);
        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/admin/**")
                    .authorizeRequests()
                    .anyRequest().hasRole("ADMIN") // .authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/admin/login")
                    .defaultSuccessUrl("/admin/home")
                    .permitAll()
                    .and()
                    .logout()
                    .logoutUrl("/admin/logout")
                    .permitAll()
                    .and()
                    .csrf().disable();
        }
    }

    @Configuration
    @Order(1)
    public static class EmployeeSecurityConfig extends WebSecurityConfigurerAdapter {

        private final PracownikDetailServiceImp adminDetailsService;

        public EmployeeSecurityConfig(PracownikDetailServiceImp adminDetailsService) {
            this.adminDetailsService = adminDetailsService;
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(adminDetailsService);
        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/employee/**")
                    .authorizeRequests()
                    .anyRequest().hasRole("EMP")//.authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/employee/login")
                    .defaultSuccessUrl("/employee/home")
                    .and()
                    .logout()
                    .logoutUrl("/employee/logout")
                    .permitAll()
                    .and()
                    .csrf().disable();
        }
    }

    @Configuration
    public static class ClientSecurityConfig extends WebSecurityConfigurerAdapter {

        private final KlientDetailsServiceImp userDetailsService;

        public ClientSecurityConfig(KlientDetailsServiceImp userDetailsService) {
            this.userDetailsService = userDetailsService;
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService);
        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/","/store","/newClient").permitAll()
                    .antMatchers("/client/**", "/js/**", "/static/css/**").hasRole("USER")
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/client/login")
                    //.loginProcessingUrl("/login")
                    .defaultSuccessUrl("/client/home", true)
                    .permitAll()
                    .and()
                    .logout()
                    .logoutUrl("/client/logout")
                    .permitAll()
                    .and()
                    .csrf().disable();
        }

        @GetMapping("/username")
        public String currentUserName(Authentication authentication) {
            return authentication.getName();
        }
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}