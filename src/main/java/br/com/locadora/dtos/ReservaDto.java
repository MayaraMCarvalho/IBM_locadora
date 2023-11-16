package br.com.locadora.dtos;

import br.com.locadora.entities.VeiculoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservaDto {
    private Long id;
    private VeiculoEntity veiculo;
    private String nome;
}
