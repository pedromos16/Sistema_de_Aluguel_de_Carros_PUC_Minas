package com.sac.demo.repository;

import com.sac.demo.model.Agente;
import com.sac.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenteRepository extends JpaRepository<Agente, Integer> {
}
