package io.github.danielnerys.icompras.pedidos.service;

import io.github.danielnerys.icompras.pedidos.controller.dto.NovoPedidoDTO;
import io.github.danielnerys.icompras.pedidos.model.Pedido;
import io.github.danielnerys.icompras.pedidos.repository.ItemPedidoRepository;
import io.github.danielnerys.icompras.pedidos.repository.PedidoRepository;
import io.github.danielnerys.icompras.pedidos.validador.PedidoValidator;
import lombok.RequiredArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;

    private final PedidoValidator validator;

    public Pedido criarPedido(Pedido pedido){
        return null;
    }
}
