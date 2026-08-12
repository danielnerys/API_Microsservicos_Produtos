package io.github.danielnerys.icompras.pedidos.model.repository;

import io.github.danielnerys.icompras.pedidos.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
