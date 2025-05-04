package com.concessionaria.sistemaautomotivo.service;

import com.concessionaria.sistemaautomotivo.model.Veiculo;
import com.concessionaria.sistemaautomotivo.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Veiculo salvar(Veiculo veiculo) {
        return repository.save(veiculo);
    }

    public List<Veiculo> listar() {
        return repository.findAll();
    }

    public Optional<Veiculo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}