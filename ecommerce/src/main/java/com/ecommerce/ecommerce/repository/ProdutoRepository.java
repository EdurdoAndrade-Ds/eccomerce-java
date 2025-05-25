package com.ecommerce.ecommerce.repositories;

import com.ecommerce.ecommerce.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Aqui podemos adicionar métodos de consulta personalizados se necessário
}