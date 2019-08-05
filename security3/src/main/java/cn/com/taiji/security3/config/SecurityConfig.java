package cn.com.taiji.security3.config;

import cn.com.taiji.security3.service.CustomUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger logger= LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    DataSource dataSource;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");
        /*((HttpSecurity)
                ((HttpSecurity)
                        ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)*/
                                http.authorizeRequests()
                                        .antMatchers("/error").permitAll()
//                                        .antMatchers("/user").hasAnyRole("ADMIN","USER")
//                                        .antMatchers("/admin").hasRole("ADMIN")
                                        .anyRequest().access("@customAuthService.canAccess(request,authentication)")
//                                        .anyRequest()
////                        )
//                                .authenticated()
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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //String password=passwordEncoder().encode("1");

//        auth.inMemoryAuthentication()
//                .withUser("user").password("1").roles("USER")
//                .and()
//                .withUser("admin").password("1").roles("ADMIN");

//        auth.jdbcAuthentication()
//                .dataSource(dataSource);

//                .withUser("user").password(password).roles("USER")
//                .and()
//                .withUser("admin").password(password).roles("ADMIN");
        auth.userDetailsService(customUserDetailService)
                .passwordEncoder(passwordEncoder());

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/css/**","/js/**","/images/**");
    }

    /*@Bean
    public UserDetailsService userDetailsService() {
        String password=passwordEncoder().encode("1");
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
        manager.setDataSource(dataSource);
        //InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user").password(password).roles("USER").build());
        manager.createUser(User.withUsername("admin").password(password).roles("ADMIN").build());
        return manager;
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }





}
