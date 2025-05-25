package com.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.modules.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Aqui podemos adicionar métodos de consulta personalizados se necessário
}