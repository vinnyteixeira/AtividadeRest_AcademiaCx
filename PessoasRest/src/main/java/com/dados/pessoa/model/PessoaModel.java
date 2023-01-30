package com.dados.pessoa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaModel {

    private UUID id;
    private String nome;
    private Long cpf;
    private String rg;
    private LocalDateTime dataNasc;
    private String estadoCiv;
    private int tel;
    private String email;




}
