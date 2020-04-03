package com.omni.ecom.other;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper mm() {
		ModelMapper mm1=new ModelMapper();
		return mm1;
	}
}
