package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.modules.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Aqui podemos adicionar métodos de consulta personalizados se necessário
}