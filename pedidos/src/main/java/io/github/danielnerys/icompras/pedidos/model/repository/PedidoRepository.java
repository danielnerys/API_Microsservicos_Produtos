package io.github.danielnerys.icompras.pedidos.model.repository;

import io.github.danielnerys.icompras.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
