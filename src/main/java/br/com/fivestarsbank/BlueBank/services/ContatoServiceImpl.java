package br.com.fivestarsbank.BlueBank.services;

import br.com.fivestarsbank.BlueBank.models.Contato;
import br.com.fivestarsbank.BlueBank.repositories.ContatoRepository;
import br.com.fivestarsbank.BlueBank.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContatoServiceImpl implements ContatoService {

	@Autowired
	private ContatoRepository contato_repo;

	@Override
	public Contato BuscarById(Integer id) {
		return this.contato_repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Contato inexistente!"));
	}
	@Override
	public List<Contato> Listar() {
		return this.contato_repo.findAll();
	}

	@Override
	public Contato Cadastrar(Contato contato) {
		return this.contato_repo.save(contato);
	}

	@Override
	public void Excluir(Integer id) {
		BuscarById(id);
		contato_repo.deleteById(id);
	}
	@Override
	public List<Contato> BuscarByIdCliente(Integer id) {
		List<Contato> lista = new ArrayList<>();
		for(Contato i : Listar()) {
			if (id == i.getCliente().getId())lista.add(i);
		}
		return lista;
	}
}