package br.com.fivestarsbank.BlueBank.services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.fivestarsbank.BlueBank.models.Cliente;
import br.com.fivestarsbank.BlueBank.models.Endereco;
import br.com.fivestarsbank.BlueBank.repositories.EnderecoRepository;
@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository endereco_repository;
	@Autowired
	private ClienteServiceImpl cliente_service;

	@Override
	public Endereco BuscarById(Integer id) {
		return this.endereco_repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Endereco inexistente!"));
	}
	@Override
	public List<Endereco> Listar() {
		return this.endereco_repository.findAll();
	}
	@Override
	public Endereco Cadastrar(Endereco endereco) {
		Integer idCliente = endereco.getcliente().getId();
		Cliente cliente = cliente_service.BuscarById(idCliente);
		endereco.setcliente(cliente);

		return this.endereco_repository.save(endereco);
	}

	public List<Endereco> BuscarByIdCliente(Integer id) {
		List<Endereco> lista = new ArrayList<>();

		for(Endereco i : Listar()) {
			if(id == i.getcliente().getId()) lista.add(i);
		}

		return lista;
	}

}