package pe.edu.vallegrande.proyecto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer (){
        return new WebMvcConfigurer() {
         @Override
         public void addCorsMappings(@SuppressWarnings("null")  CorsRegistry registry){
             registry.addMapping("/**")
             .allowedOrigins("https://supreme-eureka-67j59vj949jh7g7-8086.app.github.dev")
             .allowedMethods("GET", "POST", "PUT", "DELETE")
             .allowedHeaders("*")
             .allowCredentials(true) ;
         }
            
        };
    }
}
