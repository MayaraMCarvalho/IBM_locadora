package br.com.locadora.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoDto {
    private Long id;
    private String modelo;
    private String marca;
    private String cor;
    private int ano;
    private String placa;
    private boolean locado;
}
