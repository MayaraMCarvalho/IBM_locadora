package br.com.locadora.controllers;

import br.com.locadora.dtos.ReservaDto;
import br.com.locadora.entities.ReservaEntity;
import br.com.locadora.services.ReservaService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservas")
public class ReservaController {
    @Autowired
    ReservaService reservaService;

    @PostMapping("/inserir")
    public String inserirReserva(@RequestBody ReservaEntity reserva){
        if(reserva.getId() == 0) {
            reservaService.inserirAlterarReserva(reserva);
            return "Reserva inserida com sucesso!";
        } else {
            return "Reserva não inserida!";
        }
    }

    @GetMapping
    public List<ReservaDto> consultarReservas(@PathParam("id") Long id){
        List<ReservaDto> reservas = reservaService.buscarTodasAsReservas(id);
        return reservas;
    }

    @PutMapping
    public ResponseEntity alterarReserva(@RequestBody ReservaEntity reserva){
        if(reserva.getId() != 0) {
            reservaService.inserirAlterarReserva(reserva);
            return ResponseEntity.status(200).body(reserva);
        } else {
            return ResponseEntity.status(500).body("Erro ao alterar Reserva");
        }
    }

    @DeleteMapping
    public void apagaReserva(@PathParam("id") Long id){
        reservaService.apagarReserva(id);
    }

}
