package br.com.pihoteisepousadas.Projeto.domain.repository;

import br.com.pihoteisepousadas.Projeto.domain.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
}
