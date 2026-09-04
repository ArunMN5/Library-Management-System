package Library_Management_System.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth

                        // Public APIs
                        .requestMatchers(
                                "/user/register",
                                "/user/login",
                                "/swagger-ui/**",
                                "/v3/api-docs/**")
                        .permitAll()

                        // ADMIN only
                        .requestMatchers(
                                "/book/add",
                                "/book/update/**",
                                "/book/delete/**",
                                "/member/add",
                                "/member/update/**",
                                "/member/delete/**")
                        .hasRole("ADMIN")

                        // USER + ADMIN
                        .requestMatchers(
                                "/book/all",
                                "/book/**",
                                "/member/all",
                                "/member/**",
                                "/issue/**",
                                "/return/**")
                        .hasAnyRole("USER", "ADMIN")

                        // Everything else requires login
                        .anyRequest()
                        .authenticated())

                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}