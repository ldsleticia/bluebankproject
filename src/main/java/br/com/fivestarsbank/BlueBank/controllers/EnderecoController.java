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
import br.com.fivestarsbank.BlueBank.models.Endereco;
import br.com.fivestarsbank.BlueBank.services.EnderecoServiceImpl;
@RestController
@RequestMapping(path="/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoServiceImpl endereco_service;

	@GetMapping(path="/{id}")
	public ResponseEntity<Endereco> BuscarById(@PathVariable Integer id) {
		Endereco endereco = this.endereco_service.BuscarById(id);
		return ResponseEntity.ok().body(endereco);
	}

	@GetMapping
	public List<Endereco> Listar() {
		return this.endereco_service.Listar();
	}

	@PostMapping(path="/cadastro")
	public Endereco Cadastrar(@RequestBody Endereco endereco) {
		return this.endereco_service.Cadastrar(endereco);
	}

	@GetMapping(path="/cliente/{id}")
	public List<Endereco> BuscarByIdCliente(@PathVariable Integer id) {
		return this.endereco_service.BuscarByIdCliente(id);
	}

}