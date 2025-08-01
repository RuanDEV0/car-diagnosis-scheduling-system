package ruandev.com.systemspringboot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    public static final String [] ENPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED = {
        "/auth/login",
        "/auth/register",
    };
}
