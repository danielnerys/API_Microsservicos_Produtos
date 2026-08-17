package io.github.danielnerys.icompras.pedidos.validador;

import feign.FeignException;
import io.github.danielnerys.icompras.pedidos.client.ClientesClient;
import io.github.danielnerys.icompras.pedidos.client.ProdutosClient;
import io.github.danielnerys.icompras.pedidos.client.representation.ClienteRepresentation;
import io.github.danielnerys.icompras.pedidos.client.representation.ProdutoRepresentation;
import io.github.danielnerys.icompras.pedidos.model.ItemPedido;
import io.github.danielnerys.icompras.pedidos.model.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PedidoValidator {

    private final ProdutosClient produtosClient;
    private final ClientesClient clientesClient;

    public void validar(Pedido pedido) {
        Long codigoCliente = pedido.getCodigoCliente();
        validarCliente(codigoCliente);
        pedido.getItens().forEach(this::validarItem);

    }

    private void validarCliente(Long codigoCliente) {
        try {
            var response = clientesClient.obterDados(codigoCliente);
            ClienteRepresentation cliente = response.getBody();
            log.info("Cliente de código {} encontarado {}", codigoCliente, cliente.nome());
        } catch (FeignException.NotFound e) {
            log.info("Cliente Não Encontrado");
        }

    }

    private void validarItem(ItemPedido itemPedido) {
        try{
            var response = produtosClient.obterDados(itemPedido.getCodigoProduto());
            ProdutoRepresentation produto = response.getBody();
            log.info("Produto de codigo {} encontarado {}", itemPedido.getCodigoProduto(), produto.nome());
        }catch (FeignException.NotFound e) {
            log.info("Produto não encontrado");
        }
    }
}
