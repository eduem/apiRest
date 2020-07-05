package br.com.apiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apiRest.entity.PedidoItens;

@Repository
public interface PedidoItensRepository extends JpaRepository<PedidoItens, Long>{

}
