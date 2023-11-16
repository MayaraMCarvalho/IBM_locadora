package br.com.locadora.controllers;

import br.com.locadora.dtos.VeiculoDto;
import br.com.locadora.entities.VeiculoEntity;
import br.com.locadora.services.VeiculoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("veiculos")
public class VeiculosController {

    @Autowired
    VeiculoService veiculoService;

    @PostMapping("/inserir")
    public String inserirVeiculo(@RequestBody VeiculoEntity veiculo){
        if(veiculo.getId() == 0) {
            veiculoService.inserirAlterarVeiculo(veiculo);
            return "Veiculo inserido com sucesso!";
        } else {
            return "Veiculo não inserido!";
        }
    }

    @GetMapping
    public List<VeiculoDto> consultarVeiculos(@PathParam("locado") Boolean locado){
        List<VeiculoDto> veiculos = veiculoService.buscarTodosOsVeiculos(locado);
        return veiculos;
    }

    @PutMapping
    public ResponseEntity alterarVeiculo(@RequestBody VeiculoEntity veiculo){
        if(veiculo.getId() != 0) {
            veiculoService.inserirAlterarVeiculo(veiculo);
            return ResponseEntity.status(200).body(veiculo);
        } else {
            return ResponseEntity.status(500).body("Erro ao alterar Veiculo");
        }
    }

    @DeleteMapping
    public void apagaVeiculo(@PathParam("id") Long id){
        veiculoService.apagarVeiculo(id);
    }

}
