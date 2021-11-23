package br.com.fivestarsbank.BlueBank.services;
import java.util.List;
import br.com.fivestarsbank.BlueBank.models.Contato;
public interface ContatoService {

	public Contato BuscarById(Integer id);
	public List<Contato> Listar();
	public Contato Cadastrar(Contato contato);
	public void Excluir(Integer id);
	public List<Contato> BuscarByIdCliente(Integer id);
}