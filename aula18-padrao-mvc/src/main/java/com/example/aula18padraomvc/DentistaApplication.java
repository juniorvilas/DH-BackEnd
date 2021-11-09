package com.example.aula18padraomvc;

import com.example.aula18padraomvc.controller.DentistaController;
import com.example.aula18padraomvc.model.Dentista;
import com.example.aula18padraomvc.service.DentistaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class DentistaApplication {

	@RequestMapping("/dentistas")

	public static void main(String[] args) {
		SpringApplication.run(DentistaApplication.class, args);
	}



}
