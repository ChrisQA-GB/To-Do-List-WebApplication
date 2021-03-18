package com.example.demo.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// A @Configuration class is used to supply beans to the application context
// and configure the application
@Configuration
public class ApplicationConfiguration {

	
	@Bean
	@Scope("protype") // I have set the Scope to a prototype due to the nature of the project.
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}
}
