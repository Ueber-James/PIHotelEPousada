package br.com.pihoteisepousadas.Projeto.domain.repository;

import br.com.pihoteisepousadas.Projeto.domain.entity.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImagemRepository extends JpaRepository<Imagem, UUID> {
}
