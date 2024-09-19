package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.domain.dtos.request.ProdutoRequestDto;
import com.api_vendinha.api.domain.entities.Produto;

import java.util.List;

public interface ProdutoServiceInterface {
    Produto atualizar(ProdutoRequestDto produtoRequestDto, Long id);
    Produto salvar(ProdutoRequestDto produtoRequestDto);

    List<Produto> listarProdutos();

    Produto listarPorId(Long id);
}
