package com.example.demo;

import com.example.demo.model.Expert;
import com.example.demo.model.Tag;
import com.example.demo.service.ExpertService;
import com.example.demo.service.TagService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
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


		Expert expert1 = new Expert("Cristina");
		Tag tag1 = new Tag("Etiqueta numero 1");

		List<Tag> tags= new ArrayList<>();
		List<Expert> experts = new ArrayList<>();

		tags.add(tag1);

		expert1.setTags(tags);

		expertService.createExpert(expert1);

//		System.out.println(expert1);

	}
}
