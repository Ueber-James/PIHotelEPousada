package br.com.pihoteisepousadas.Projeto.domain.repository;

import br.com.pihoteisepousadas.Projeto.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
