package io.github.danielnerys.icompras.pedidos.controller.dto;

import io.github.danielnerys.icompras.pedidos.model.enums.TipoPagamento;

public record DadosPagamentoDTO(String dados, TipoPagamento tipoPagamento) {
}
