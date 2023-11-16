package br.com.locadora.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "reserva")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreserva")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "veiculoreserva_id")
    private VeiculoEntity veiculo;

    @Column(name = "nomereserva")
    private String nome;
}
