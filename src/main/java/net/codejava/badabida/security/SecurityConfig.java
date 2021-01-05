package net.codejava.badabida.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
            //@formatter:off
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
                    .permitAll();
            //@formatter:on
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
            //@formatter:off
            http
                    .antMatcher("/employee/**")
                    .authorizeRequests()
                    .anyRequest().hasRole("EMP")//.authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/employee/login")
                    .defaultSuccessUrl("/employee/home")
                    .permitAll()
                    .and()
                    .logout()
                    .logoutUrl("/employee/logout")
                    .permitAll();
            //@formatter:on
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
            //@formatter:off
            http
                    .authorizeRequests()
                    .antMatchers("/css/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/client/login")
                    .defaultSuccessUrl("/client/home")
                    .permitAll()
                    .and()
                    .logout()
                    .logoutUrl("/client/logout")
                    .permitAll();
            //@formatter:on
        }
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
