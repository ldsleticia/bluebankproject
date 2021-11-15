package br.com.fivestarsbank.BlueBank.repositories;

import br.com.fivestarsbank.BlueBank.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
