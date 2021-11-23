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

import br.com.fivestarsbank.BlueBank.models.Movimentacao;
import br.com.fivestarsbank.BlueBank.services.MovimentacaoServiceImpl;

@RestController
@RequestMapping(path="/Movimentacao")
public class MovimentacaoController {
	
	@Autowired
	private MovimentacaoServiceImpl movimentacao_service; 
	
	@PostMapping(path="/cadastro")
	public Movimentacao Cadastrar(@RequestBody Movimentacao id) {
		return this.movimentacao_service.Cadastrar(id);
	}
	
	
	@GetMapping(path="/id")
	public ResponseEntity<Movimentacao> BuscarById(@PathVariable Integer id) {
		Movimentacao movimentacao = this.movimentacao_service.BuscarById(id);
		return ResponseEntity.ok().body(movimentacao);
	}

	@GetMapping
	public List<Movimentacao> Listar() {
		return this.movimentacao_service.Listar();	
	}
	
}
