package com.api.localizacao.domain.repository;

import com.api.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    // lista cidades por nome
    List<Cidade> findByNome(String nome);

    @Query(" select c from Cidade c where lower(c.nome) like upper(?1) ")
    List<Cidade> findByNomeLike(String nome);

    // busca pelo nome comecando por aquele pedaço
    List<Cidade> findByNomeStartingWith(String nome);

    // busca pelo nome terminando por aquele pedaço
    List<Cidade> findByNomeEndingWith(String nome);

    // busca pelo nome contendo aquele pedaço
    List<Cidade> findByNomeContaining(String nome);
    List<Cidade> findByHabitantes(Long habitantes);
}
