package io.github.danielnerys.icompras.produtos.dto.response;

import java.math.BigDecimal;

public record
ProdutoResponseDTO(
        Long codigo,
        String nome,
        BigDecimal valorUnitario
) {
}
