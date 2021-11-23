package br.com.fivestarsbank.BlueBank.services;

import java.util.List;


import br.com.fivestarsbank.BlueBank.models.Movimentacao;

public interface MovimentacaoService {
	
	public Movimentacao BuscarById(Integer id);
	public List<Movimentacao> Listar();
	public Movimentacao Cadastrar(Movimentacao id);

}
