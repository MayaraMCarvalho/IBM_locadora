package br.com.locadora.services;

import br.com.locadora.dtos.VeiculoDto;
import br.com.locadora.entities.VeiculoEntity;
import br.com.locadora.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<VeiculoEntity> listar() {
        System.out.println(veiculoRepository.findAll());
        return (List<VeiculoEntity>) veiculoRepository.findAll();
    }

    public VeiculoEntity buscarPorId(Long id) {
        System.out.println(veiculoRepository.findById(id).orElse(null));
        return veiculoRepository.findById(id).orElse(null);
    }

    public List<VeiculoDto> buscarTodosOsVeiculos(Boolean locado){
        List<VeiculoEntity> veiculoEntityList = new ArrayList<>();

        if(locado == null) {
            veiculoEntityList = veiculoRepository.findAll();
        } else {
            veiculoEntityList = veiculoRepository.findAllByLocado(locado);
        }

        List<VeiculoDto> veiculoDtoList = new ArrayList<>();
        for (VeiculoEntity veiculoEntity:veiculoEntityList) {
            VeiculoDto veiculoDto = new VeiculoDto();
            veiculoDto.setModelo(veiculoEntity.getModelo());
            veiculoDto.setMarca(veiculoEntity.getMarca());
            veiculoDto.setCor(veiculoEntity.getCor());
            veiculoDto.setAno(veiculoEntity.getAno());
            veiculoDto.setPlaca(veiculoEntity.getPlaca());
            veiculoDto.setLocado(veiculoEntity.getLocado());

            veiculoDtoList.add(veiculoDto);
        }

        return veiculoDtoList;
    }

    public void inserirAlterarVeiculo(VeiculoEntity veiculo){
        veiculoRepository.save(veiculo);
    }

    public void apagarVeiculo(Long id){
        List<VeiculoEntity> veiculoEntity = veiculoRepository.findAllByVeiculo(id);
        veiculoRepository.deleteAll(veiculoEntity);
    }
}
