package io.github.danielnerys.icompras.pedidos.controller;

import io.github.danielnerys.icompras.pedidos.controller.dto.NovoPedidoDTO;
import io.github.danielnerys.icompras.pedidos.controller.mappers.PedidoMapper;
import io.github.danielnerys.icompras.pedidos.service.PedidoService;
import io.github.danielnerys.icompras.pedidos.validador.PedidoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    private final PedidoMapper pedidoMapper;


    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody NovoPedidoDTO dto) {

        var pedido = pedidoMapper.map(dto);
        var novoPedido = pedidoService.criarPedido(pedido);
        return ResponseEntity.ok(novoPedido.getCodigo());
    }
}
