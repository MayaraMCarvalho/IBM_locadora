package br.com.locadora.services;

import br.com.locadora.dtos.ReservaDto;
import br.com.locadora.entities.ReservaEntity;
import br.com.locadora.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public List<ReservaEntity> listar() {
        System.out.println(reservaRepository.findAll());
        return (List<ReservaEntity>) reservaRepository.findAll();
    }

    public List<ReservaDto> buscarTodasAsReservas(Long id){
        List<ReservaEntity> reservaEntityList = new ArrayList<>();

        if(id == 0) {
            reservaEntityList = reservaRepository.findAll();
        } else {
            reservaEntityList = reservaRepository.findAllByReserva(id);
        }

        List<ReservaDto> reservaDtoList = new ArrayList<>();
        for (ReservaEntity reservaEntity:reservaEntityList) {
            ReservaDto reservaDto = new ReservaDto();
            reservaDto.setId(reservaEntity.getId());
            reservaDto.setNome(reservaEntity.getNome());
            reservaDto.setVeiculo(reservaEntity.getVeiculo());
            reservaDtoList.add(reservaDto);
        }
        return reservaDtoList;
    }

    public void inserirAlterarReserva(ReservaEntity reserva){
        reservaRepository.save(reserva);
    }

    public void apagarReserva(Long id){
        List<ReservaEntity> reservaEntity = reservaRepository.findAllByReserva(id);
        reservaRepository.deleteAll(reservaEntity);
    }
}
