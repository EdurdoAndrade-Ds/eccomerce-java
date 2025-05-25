package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.modules.Pedido;
import com.ecommerce.ecommerce.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> create(@Valid @RequestBody Pedido pedido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.savePedido(pedido));
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> list() {
        return ResponseEntity.ok(pedidoService.listAllPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> searchForIdPedido(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.searchForIdPedido(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @Valid @RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.updatePedido(id, pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        pedidoService.deletePedido(id);
        return ResponseEntity.noContent().build();
    }
}