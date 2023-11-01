package br.com.pihoteisepousadas.Projeto.domain.repository;

import br.com.pihoteisepousadas.Projeto.domain.entity.Acomodacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AcomodacaoRepository extends JpaRepository<Acomodacao, UUID> {
}
