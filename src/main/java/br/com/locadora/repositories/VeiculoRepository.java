package br.com.locadora.repositories;

import br.com.locadora.entities.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoEntity, Long> {
    List<VeiculoEntity> findAllByLocado(Boolean locado);
    List<VeiculoEntity> findAllByVeiculo(Long id);
}
