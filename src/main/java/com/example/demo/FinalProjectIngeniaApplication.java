package com.example.demo;

import com.example.demo.model.Expert;
import com.example.demo.model.Tag;
import com.example.demo.repository.ExpertRepository;
import com.example.demo.service.ExpertService;
import com.example.demo.service.TagService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FinalProjectIngeniaApplication implements CommandLineRunner {

	final TagService tagService;
	final ExpertService expertService;
	final ExpertRepository expertRepository;

	public FinalProjectIngeniaApplication(TagService tagService, ExpertService expertService, ExpertRepository expertRepository) {
		this.tagService = tagService;
		this.expertService = expertService;
		this.expertRepository = expertRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectIngeniaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Expert expert1 = new Expert("Ivan Giménez",LocalDate.now(), LocalDate.now(),
				"null" , "mañanas", "parcial", true,
				"12313423", "email@email.com", "valencia",
				"e", "10.00", "15.00", 70,
				"12345678A", "Hola", "", "e",
				"", "null", "null", "null","null",
				"Validado");

		Expert expert2 = new Expert("Miguel Perdiguero",LocalDate.now(), LocalDate.now(),
				"null" , "noches", "total", false,
				"12313423", "email@email.com", "valencia",
				"e", "10.00", "15.00", 90,
				"12345678A", "Hola", "", "e",
				"", "null", "null", "null","null",
				"Validado");

		Expert expert3 = new Expert("Cristina Garcia",LocalDate.now(), LocalDate.now(),
				"null" , "tardes", "parcial", true,
				"12313423", "email@email.com", "valencia",
				"e", "10.00", "15.00", 70,
				"12345678A", "Hola", "", "e",
				"", "null", "null", "null","null",
				"Pdt.Validar");

		Expert expert4 = new Expert("Manuela Gutierrez",LocalDate.now(), LocalDate.now(),
				"null" , "tardes", "total", false,
				"12313423", "email@email.com", "valencia",
				"e", "10.00", "15.00", 70,
				"12345678A", "Hola", "", "e",
				"", "null", "null", "null","null",
				"Pdt.Validar");


		Tag tag1 = new Tag("Etiqueta 1",LocalDate.now() , LocalDate.now());
		Tag tag2 = new Tag("Etiqueta 1",LocalDate.now() , LocalDate.now());
		Tag tag3 = new Tag("Etiqueta 3",LocalDate.now() , LocalDate.now());
		Tag tag4 = new Tag("Etiqueta 4",LocalDate.now() , LocalDate.now());
		Tag tag5 = new Tag("Etiqueta 5",LocalDate.now() , LocalDate.now());

		List tagList = new ArrayList();
		List expertList = new ArrayList();

		tagList.add(tag1);
		tagList.add(tag2);
		tagList.add(tag3);
		tagList.add(tag4);

		expertList.add(expert1);
		expertList.add(expert2);

		expert1.setTags(tagList);
		expert2.setTags(tagList);

		tag1.setExperts(expertList);
		tag2.setExperts(expertList);
		tag3.setExperts(expertList);
		tag4.setExperts(expertList);

		expertRepository.save(expert1);
		expertRepository.save(expert2);
		expertRepository.save(expert3);
		expertRepository.save(expert4);

	}
}
