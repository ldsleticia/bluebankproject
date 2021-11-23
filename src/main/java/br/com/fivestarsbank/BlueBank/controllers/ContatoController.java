package br.com.fivestarsbank.BlueBank.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fivestarsbank.BlueBank.models.Contato;
import br.com.fivestarsbank.BlueBank.services.ContatoServiceImpl;

@RestController
@RequestMapping(path="/contatos")
public class ContatoController {

	@Autowired
	private ContatoServiceImpl contato_service;

	@PostMapping(path="/cadastro")
	public Contato Cadastrar(@RequestBody Contato contato) {
		return this.contato_service.Cadastrar(contato);
	}


	@GetMapping(path="/{id}")
	public ResponseEntity<Contato> BuscarById(@PathVariable Integer id) {
		Contato contato = this.contato_service.BuscarById(id);
		return ResponseEntity.ok().body(contato);
	}
	@GetMapping
	public List<Contato> Listar() {
		return this.contato_service.Listar();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> Excluir(@PathVariable Integer id) {
		contato_service.Excluir(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(path="/cliente/{id}")
	public List<Contato> BuscarByIdCliente(@PathVariable Integer id) {
		return this.contato_service.BuscarByIdCliente(id);
	}
}
