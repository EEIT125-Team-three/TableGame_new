package config;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan({"config", "controller", "dao", "model", "service"})
public class WebAppConfig implements WebMvcConfigurer {
	@Bean
	public ViewResolver internalResolverViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		System.out.println("AAAAAAAAAAAAAAAAAAAAAA");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("resources/css/");
		registry.addResourceHandler("/images/**").addResourceLocations("resources/images/");
		registry.addResourceHandler("/js/**").addResourceLocations("resources/js/");
	}

}
