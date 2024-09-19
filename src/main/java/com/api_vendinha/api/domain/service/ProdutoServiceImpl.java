package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.Infrastructure.repository.ProdutoRepository;
import com.api_vendinha.api.domain.dtos.request.ProdutoRequestDto;
import com.api_vendinha.api.domain.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoServiceInterface{

    private ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto salvar(ProdutoRequestDto produtoRequestDto) {
        return this.produtoRepository.save(new Produto(produtoRequestDto));
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }
    @Override
    public Produto listarPorId(Long id){
        Optional<Produto> produtoExistente = this.produtoRepository.findById(id);

        if(produtoExistente.isEmpty()){
            throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Produto não encontrado");
        }
        return produtoExistente.get();
    }

    @Override
    public Produto atualizar(ProdutoRequestDto produtoRequestDto, Long id) {

        Optional<Produto> produtoExistente = this.produtoRepository.findById(id);

        if(produtoExistente.isEmpty()){
            throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Produto não encontrado");
        }

        produtoExistente.get().setNome(produtoRequestDto.getNome());
        produtoExistente.get().setQuantidade(produtoRequestDto.getQuantidade());
        produtoExistente.get().setPreco(produtoRequestDto.getPreco());

        Produto produtoAtualizado = this.produtoRepository.save(produtoExistente.get());

        return produtoAtualizado;
    }



}
