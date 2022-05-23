package com.students.CRUD;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	// cái ModelMapper này có tác dụng map tất cả dữ liệu từ database qua DTO
	// nếu muốn DTO hiển thị gì thì các properties ở DTO phải giống với bên entity
}
