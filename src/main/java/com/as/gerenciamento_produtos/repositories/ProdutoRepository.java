package com.as.gerenciamento_produtos.repositories;

import com.as.gerenciamento_produtos.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
