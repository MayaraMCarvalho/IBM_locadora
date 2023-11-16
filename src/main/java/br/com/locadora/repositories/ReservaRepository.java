package br.com.locadora.repositories;

import br.com.locadora.entities.ReservaEntity;
import br.com.locadora.entities.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, String> {
    List<ReservaEntity> findAllByCliente(String nome);
    List<ReservaEntity> findAllByReserva(Long Id);
    List<ReservaEntity> findAllByVeiculo(VeiculoEntity veiculo);

}
