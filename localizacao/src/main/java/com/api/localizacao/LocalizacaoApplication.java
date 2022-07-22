package com.api.localizacao;

import com.api.localizacao.domain.entity.Cidade;
import com.api.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public void run(String... args) throws Exception {
		listCidadesPorNome();
	}

	@Transactional
	void listCidadesPorNome(){
		cidadeRepository.findByNomeLike("%a%").forEach(System.out::println);
	}

	@Transactional
	void listCidadesPorHabitantes(){
		cidadeRepository.findByHabitantes(78978979L).forEach(System.out::println);
	}

	@Transactional
	void listCidades(){
		cidadeRepository.findAll().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}
}
