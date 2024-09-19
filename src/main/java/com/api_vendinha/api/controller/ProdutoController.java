package com.api_vendinha.api.controller;

import com.api_vendinha.api.domain.dtos.request.ProdutoRequestDto;
import com.api_vendinha.api.domain.entities.Produto;
import com.api_vendinha.api.domain.service.ProdutoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private ProdutoServiceInterface produtoService;

    @Autowired
    public ProdutoController(ProdutoServiceInterface produtoService) {
        this.produtoService = produtoService;
    }


    @PostMapping
    public Produto salvar(@RequestBody ProdutoRequestDto produtoRequestDto){

        return this.produtoService.salvar(produtoRequestDto);
    }

    @PutMapping("/atualizar/{id}")
    public Produto atualizar(@RequestBody ProdutoRequestDto produtoRequestDto,
                             @PathVariable Long id){
        return this.produtoService.atualizar(produtoRequestDto, id);

    }

    @GetMapping("/listar")
    public List<?> listarTodosProdutos(){
        return this.produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public Produto listarPorId(@PathVariable Long id){
        return this.produtoService.listarPorId(id);
    }
}
