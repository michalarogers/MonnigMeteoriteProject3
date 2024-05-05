package edu.tcu.cs.monnigmeteorite.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class to define global CORS settings that apply to all controllers.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configures CORS mapping for the application.
     * Allows unrestricted cross-origin access to your backend from the specified origin.
     * @param registry the CORS registry to configure
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8000/src/main/resources/static/") // Replace this with the URL of your frontend application
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Specify allowed methods as per your requirements
                .allowedHeaders("*") // Allows all headers
                .allowCredentials(true); // If necessary, to include cookies/session ID
    }
}
