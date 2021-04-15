package com.example.demo;

import com.example.demo.model.Expert;
import com.example.demo.model.Tag;
import com.example.demo.service.ExpertService;
import com.example.demo.service.TagService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class FinalProjectIngeniaApplication implements CommandLineRunner {

	final TagService tagService;
	final ExpertService expertService;

	public FinalProjectIngeniaApplication(TagService tagService, ExpertService expertService) {
		this.tagService = tagService;
		this.expertService = expertService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectIngeniaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Expert expert1 = new Expert("Ivan Giménez",LocalDate.now(), LocalDate.now(),
				"null" , "mañanas", "null", false,
				"12313423", "email@email.com", "valencia",
				"e", "10.00", "15.00", 70,
				"12345678A", "Hola", "", "e",
				"", "null", "null", "null","null",
				false);

		Expert expert2 = new Expert("Miguel Perdiguero",LocalDate.now(), LocalDate.now(),
				"null" , "noches", "null", false,
				"12313423", "email@email.com", "valencia",
				"e", "10.00", "15.00", 70,
				"12345678A", "Hola", "", "e",
				"", "null", "null", "null","null",
				false);

		Expert expert3 = new Expert("Cristina Garcia",LocalDate.now(), LocalDate.now(),
				"null" , "tardes", "null", false,
				"12313423", "email@email.com", "valencia",
				"e", "10.00", "15.00", 70,
				"12345678A", "Hola", "", "e",
				"", "null", "null", "null","null",
				false);

		Expert expert4 = new Expert("Manuela Gutierrez",LocalDate.now(), LocalDate.now(),
				"null" , "tardes", "null", false,
				"12313423", "email@email.com", "valencia",
				"e", "10.00", "15.00", 70,
				"12345678A", "Hola", "", "e",
				"", "null", "null", "null","null",
				false);


		Tag tag1 = new Tag("Etiqueta numero 1");

		List<Tag> tags= new ArrayList<>();
		List<Expert> experts = new ArrayList<>();

		tags.add(tag1);

		expert1.setTags(tags);

		expertService.createExpert(expert1);
		expertService.createExpert(expert2);
		expertService.createExpert(expert3);
		expertService.createExpert(expert4);


//		System.out.println(expert1);

	}
}
