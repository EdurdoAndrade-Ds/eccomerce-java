package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.modules.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByEmailContaining(String email);
}

