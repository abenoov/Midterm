package kz.iitu.mukhtar.electricity.config;

import kz.iitu.mukhtar.electricity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()

                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()

                .antMatchers(HttpMethod.POST, "/bills/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/bills/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/bills/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/bills/**").hasAnyAuthority("ADMIN", "USER")

                .antMatchers(HttpMethod.POST, "/checkout/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/checkout/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/checkout/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/checkout/**").hasAnyAuthority("ADMIN", "USER")

                .antMatchers("/auth/**", "/users/register", "/swagger-ui.html", "/webjars/**", "/swagger-resources/**", "/v2/**").permitAll()

                .anyRequest().authenticated()
                .and()
                .addFilter(new kz.iitu.mukhtar.electricity.config.JwtTokenGeneratorFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }


    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        return source;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("*");
            }
        };
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }
}
