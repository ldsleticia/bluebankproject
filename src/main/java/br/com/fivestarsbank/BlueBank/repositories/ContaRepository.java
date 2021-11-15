package br.com.fivestarsbank.BlueBank.repositories;

import br.com.fivestarsbank.BlueBank.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository <Conta, Integer> {
}
