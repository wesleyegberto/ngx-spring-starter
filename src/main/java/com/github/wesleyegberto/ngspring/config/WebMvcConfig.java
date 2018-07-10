package com.github.wesleyegberto.ngspring.config;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	private static final String STATIC_PATH = "classpath:/static/";
	private static final String API_PATH = "/api";
    
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**/*")
			.addResourceLocations(STATIC_PATH).resourceChain(true)
			.addResolver(new PathResourceResolver() {
				@Override
				protected Resource getResource(String resourcePath, Resource location) throws IOException {
					if (("/" + resourcePath).startsWith(API_PATH)) {
						return null;
					}
					// here we should also test resources like CSS, JS and IMG
					Resource requestedResource = location.createRelative(resourcePath);
					if (requestedResource.exists() && requestedResource.isReadable()) {
						return requestedResource;
					}
					return new ClassPathResource("/static/index.html");
				}
			});
	}
}