package br.com.fivestarsbank.BlueBank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fivestarsbank.BlueBank.models.Cliente;
import br.com.fivestarsbank.BlueBank.services.ClienteServiceImpl;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl cliente_service;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> BuscarById(@PathVariable Integer id) {
        Cliente cliente = this.cliente_service.BuscarById(id);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping
    public List<Cliente> Listar() {
        return this.cliente_service.Listar();
    }

    @PostMapping(path = "/cadastro")
    public Cliente Cadastrar(@RequestBody Cliente cliente) {
        return this.cliente_service.Cadastrar(cliente);
    }

}