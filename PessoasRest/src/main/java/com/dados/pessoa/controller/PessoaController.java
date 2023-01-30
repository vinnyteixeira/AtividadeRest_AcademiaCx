package com.dados.pessoa.controller;

import com.dados.pessoa.model.CreatePessoaRequest;
import com.dados.pessoa.model.PessoaModel;
import com.dados.pessoa.model.UpdatePessoaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private List<PessoaModel> Pessoas = new ArrayList<>();

    @GetMapping
    public List<PessoaModel> getPessoasList () {
        return Pessoas;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPessoasById(@PathVariable UUID id) {
        Optional<PessoaModel> exist = Pessoas.stream().filter(pessoa -> pessoa.getId().equals(id)).findFirst();

        if (exist.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(exist.get());
    }

    @PostMapping
    public PessoaModel createPessoa (@RequestBody CreatePessoaRequest request) {
        PessoaModel pessoa = new PessoaModel(UUID.randomUUID(),
                request.getNome(),
                request.getCpf(),
                request.getRg(),
                request.getDataNasc(),
                request.getEstadoCiv(),
                request.getTel(),
                request.getEmail());


        Pessoas.add(pessoa);
        return pessoa;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePessoa (@PathVariable UUID id, @RequestBody UpdatePessoaRequest request) {
        Optional<PessoaModel> existe = Pessoas.stream().filter(car -> car.getId().equals(id)).findFirst();

        if(existe.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        PessoaModel updated = existe.get();
        updated.setNome(request.getNome());
        updated.setCpf(request.getCpf());
        updated.setRg(request.getRg());
        updated.setDataNasc(request.getDataNasc());
        updated.setEstadoCiv(request.getEstadoCiv());
        updated.setTel(request.getTel());
        updated.setEmail(request.getEmail());

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePessoa (@PathVariable UUID id) {
        boolean deleted = Pessoas.removeIf(pessoa -> pessoa.getId().equals(id));

        if(deleted){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
