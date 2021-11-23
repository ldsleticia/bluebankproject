package br.com.fivestarsbank.BlueBank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fivestarsbank.BlueBank.models.Movimentacao;
import br.com.fivestarsbank.BlueBank.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository movimentacao_repo;
	
	@Override
	public Movimentacao BuscarById(Integer id) {
		return this.movimentacao_repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Movimentacao inexistente!"));
	}

	@Override
	public List<Movimentacao> Listar() {
		return this.movimentacao_repo.findAll();
	}
	
	@Override
	public Movimentacao Cadastrar(Movimentacao id) {
		return this.movimentacao_repo.save(id);
	}


}