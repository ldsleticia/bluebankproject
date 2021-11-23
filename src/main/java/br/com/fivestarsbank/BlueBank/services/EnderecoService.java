package br.com.fivestarsbank.BlueBank.services;
import java.util.List;
import br.com.fivestarsbank.BlueBank.models.Endereco;
public interface EnderecoService {
	public Endereco BuscarById(Integer id);
	public List<Endereco> Listar();
	public Endereco Cadastrar(Endereco endereco);
	public List<Endereco> BuscarByIdCliente(Integer id);
}