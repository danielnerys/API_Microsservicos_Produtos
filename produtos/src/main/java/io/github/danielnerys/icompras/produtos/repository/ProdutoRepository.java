package io.github.danielnerys.icompras.produtos.repository;

import io.github.danielnerys.icompras.produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
