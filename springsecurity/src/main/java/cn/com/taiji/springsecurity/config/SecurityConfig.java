package cn.com.taiji.springsecurity.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger logger= LoggerFactory.getLogger(SecurityConfig.class);
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");
        /*((HttpSecurity)
                ((HttpSecurity)
                        ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)*/
                                http.authorizeRequests()
                                        .antMatchers("/error").permitAll()
                                        .antMatchers("/user").hasRole("USER")
                                        .antMatchers("/admin").hasRole("ADMIN")
                                        .anyRequest()
//                        )
                                .authenticated()
                                .and()
//                )
                        .formLogin()
                                        .loginPage("/myLogin").permitAll()
                                        .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                                            httpServletResponse.setContentType("application/json;charset=UTF-8");
                                            httpServletResponse.getWriter().write("{'error_code':'0','massage':'欢迎登陆系统'}");
                                        })
                                        .failureHandler((httpServletRequest, httpServletResponse, e) -> {
                                            httpServletResponse.setContentType("application/json;charset=UTF-8");
                                            httpServletResponse.setStatus(401);
                                            httpServletResponse.getWriter().write("{'error_code':'401','massage':'"+e.getMessage()+"'}");
                                        })
//                                        .passwordParameter("pass")
//                                        .and()
//        )
//                .httpBasic()
        ;
                            http.csrf().disable();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        String password=passwordEncoder().encode("1");
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
        //InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user").password(password).roles("USER").build());
        manager.createUser(User.withUsername("admin").password(password).roles("ADMIN").build());
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
