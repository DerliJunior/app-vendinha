package com.api_vendinha.api.controller;

import com.api_vendinha.api.domain.dtos.request.UserInactiveDto;
import com.api_vendinha.api.domain.dtos.request.UserRequestDto;
import com.api_vendinha.api.domain.dtos.response.UserResponseDto;
import com.api_vendinha.api.domain.entities.User;
import com.api_vendinha.api.domain.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gerenciar operações relacionadas aos usuários.
 */
@RestController
@RequestMapping("/api/users") // Define o caminho base para as requisições deste controlador.
public class UserController {

    // Injeção de dependência do serviço de usuários.
    private final UserServiceInterface userService;

    /**
     * Construtor para injeção de dependência do serviço de usuários.
     *
     * @param userService O serviço de usuários a ser injetado.
     */
    @Autowired
    public UserController(UserServiceInterface userService) {
        this.userService = userService;
    }

    /**
     * Método para salvar um novo usuário.
     *
     * @param userRequestDto DTO que contém os dados do usuário a ser salvo.
     * @return DTO com as informações do usuário salvo, incluindo o ID gerado.
     */
    @PostMapping // Define que este método lida com requisições HTTP POST.
    public UserResponseDto salvar(@RequestBody UserRequestDto userRequestDto) {
        // Chama o serviço para salvar o usuário e retorna a resposta.
        return userService.save(userRequestDto);
    }

    @PutMapping("/{id}")
    public User atualizar(@PathVariable("id") Long id, @RequestBody UserRequestDto user){
        return this.userService.update(id, user);
    }

    @GetMapping("/{id}")
    public UserResponseDto buscarUsuarioPeloId(@PathVariable Long id){
        return this.userService.findById(id);
    }

    @PutMapping("/{id}/status")
    public UserResponseDto alterarStatusUsuario(@RequestBody UserInactiveDto userInactiveDto,
                                                @PathVariable Long id){
        return this.userService.atualizarStatus(id, userInactiveDto);
    }
}
