package com.concessionaria.sistemaautomotivo.controller;

import com.concessionaria.sistemaautomotivo.model.Veiculo;
import com.concessionaria.sistemaautomotivo.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    // CRIAR - Cadastrar veículo
    @PostMapping
    public ResponseEntity<Veiculo> criarVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo novoVeiculo = veiculoRepository.save(veiculo);
        return ResponseEntity.ok(novoVeiculo);
    }

    // LISTAR - Listar todos os veículos
    @GetMapping
    public ResponseEntity<List<Veiculo>> listarVeiculos() {
        List<Veiculo> veiculos = veiculoRepository.findAll();
        return ResponseEntity.ok(veiculos);
    }

    // BUSCAR - Buscar veículo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarVeiculoPorId(@PathVariable Long id) {
        return veiculoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ATUALIZAR - Atualizar informações do veículo
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(
            @PathVariable Long id,
            @RequestBody Veiculo veiculoAtualizado) {

        return veiculoRepository.findById(id)
                .map(veiculo -> {
                    veiculo.setMarca(veiculoAtualizado.getMarca());
                    veiculo.setModelo(veiculoAtualizado.getModelo());
                    veiculo.setAno(veiculoAtualizado.getAno());
                    veiculo.setCor(veiculoAtualizado.getCor());
                    veiculo.setPreco(veiculoAtualizado.getPreco());
                    veiculo.setQuilometragem(veiculoAtualizado.getQuilometragem());
                    veiculo.setStatus(veiculoAtualizado.getStatus());
                    Veiculo atualizado = veiculoRepository.save(veiculo);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETAR - Excluir veículo
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarVeiculo(@PathVariable Long id) {
        return veiculoRepository.findById(id)
                .map(veiculo -> {
                    veiculoRepository.delete(veiculo);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build()); // Importante: orElse em vez de orElseGet
    }
}