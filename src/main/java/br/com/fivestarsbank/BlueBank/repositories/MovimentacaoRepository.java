package br.com.fivestarsbank.BlueBank.repositories;

import br.com.fivestarsbank.BlueBank.models.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
}
