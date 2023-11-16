package br.com.pihoteisepousadas.Projeto.domain.repository;

import br.com.pihoteisepousadas.Projeto.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CidadeRepository extends JpaRepository<Cidade, UUID> {
}
