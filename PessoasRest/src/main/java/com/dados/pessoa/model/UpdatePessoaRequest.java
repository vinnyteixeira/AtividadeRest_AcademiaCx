package com.dados.pessoa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePessoaRequest {

    private String nome;
    private Long cpf;
    private String rg;
    private LocalDateTime dataNasc;
    private String estadoCiv;
    private int tel;
    private String email;
}
