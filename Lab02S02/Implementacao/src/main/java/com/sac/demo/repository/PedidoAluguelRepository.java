package com.sac.demo.repository;

import com.sac.demo.model.Automovel;
import com.sac.demo.model.PedidoAluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoAluguelRepository extends JpaRepository<PedidoAluguel, Integer> {
}
