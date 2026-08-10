package io.github.danielnerys.icompras.produtos.dto.request;

import java.math.BigDecimal;

public record ProdutoRequestDTO (Long codigo, String nome, BigDecimal valorUnitario){
}
