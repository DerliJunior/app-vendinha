package com.api_vendinha.api.domain.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDto {
    private String nome;

    private Integer quantidade;

    private Double preco;
}
