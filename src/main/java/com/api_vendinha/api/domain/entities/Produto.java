package com.api_vendinha.api.domain.entities;

import com.api_vendinha.api.domain.dtos.request.ProdutoRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produtos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private Double preco;

    public Produto(ProdutoRequestDto produtoRequestDto) {
        this.nome = produtoRequestDto.getNome();
        this.quantidade = produtoRequestDto.getQuantidade();
        this.preco = produtoRequestDto.getPreco();

    }
}
