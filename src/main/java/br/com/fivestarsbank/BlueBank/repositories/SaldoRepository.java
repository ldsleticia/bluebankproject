package br.com.fivestarsbank.BlueBank.repositories;

import br.com.fivestarsbank.BlueBank.models.Saldo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaldoRepository extends JpaRepository <Saldo, Double> {
}
