package com.ecommerce.ecommerce.repositories;

import com.ecommerce.ecommerce.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Aqui podemos adicionar métodos de consulta personalizados se necessário
}