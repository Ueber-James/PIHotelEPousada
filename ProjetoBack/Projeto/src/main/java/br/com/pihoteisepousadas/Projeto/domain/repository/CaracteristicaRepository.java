package br.com.pihoteisepousadas.Projeto.domain.repository;

import br.com.pihoteisepousadas.Projeto.domain.entity.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CaracteristicaRepository extends JpaRepository<Caracteristica, UUID> {
}
