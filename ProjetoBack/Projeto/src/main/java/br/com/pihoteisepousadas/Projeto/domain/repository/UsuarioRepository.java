package br.com.pihoteisepousadas.Projeto.domain.repository;

import br.com.pihoteisepousadas.Projeto.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}
