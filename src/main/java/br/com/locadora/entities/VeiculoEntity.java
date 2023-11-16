package br.com.locadora.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "veiculo")
public class VeiculoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idveiculo")
    private Long id;

    @Column(name = "modeloveiculo")
    private String modelo;

    @Column(name = "marcaveiculo")
    private String marca;

    @Column(name = "corveiculo")
    private String cor;

    @Column(name = "anoveiculo")
    private int ano;

    @Column(name = "placaveiculo")
    private String placa;

    @Column(name = "locadoveiculo")
    private boolean locado;

    public VeiculoEntity(String modelo, String marca, String cor, int ano, String placa, boolean locado) {
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.ano = ano;
        this.placa = placa;
        this.locado = locado;
    }

    @Override
    public String toString() {
        return "Veiculo {" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", cor='" + cor + '\'' +
                ", ano=" + ano +
                ", placa='" + placa + '\'' +
                ", locado=" + locado +
                '}';
    }

    public boolean getLocado() {
        return locado;
    }
}
