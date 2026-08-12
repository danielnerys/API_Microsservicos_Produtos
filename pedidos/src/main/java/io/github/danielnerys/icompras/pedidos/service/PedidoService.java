package io.github.danielnerys.icompras.pedidos.service;

import io.github.danielnerys.icompras.pedidos.client.ServicoBancarioClient;
import io.github.danielnerys.icompras.pedidos.model.Pedido;
import io.github.danielnerys.icompras.pedidos.model.repository.ItemPedidoRepository;
import io.github.danielnerys.icompras.pedidos.model.repository.PedidoRepository;
import io.github.danielnerys.icompras.pedidos.validador.PedidoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;


    private final PedidoValidator validator;

    private final ServicoBancarioClient servicoBancarioClient;

    @Transactional
    public Pedido criarPedido(Pedido pedido) {
        validator.validar(pedido);
        realizarPersistencia(pedido);
        enviarSolicitacaoPagamento(pedido);
        return pedido;
    }

    private void enviarSolicitacaoPagamento(Pedido pedido) {
        var chavePagamento = servicoBancarioClient.solicitarPagamento(pedido);
        pedido.setChavePagamento(chavePagamento);
    }

    private void realizarPersistencia(Pedido pedido) {
        pedidoRepository.save(pedido);
        itemPedidoRepository.saveAll(pedido.getItens());
    }
}
