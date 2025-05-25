package com.ecommerce.ecommerce.controller;

import java.util.List;
import com.ecommerce.ecommerce.modules.Cliente;
import com.ecommerce.ecommerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.saveClient(cliente));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> list() {
        return ResponseEntity.ok(clienteService.listAllClient());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> searchForIdClient(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.searchForIdClient(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateClient(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.updateClient(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clienteService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<Cliente>> searchForEmail(@RequestParam String email) {
        return ResponseEntity.ok(clienteService.searchForEmail(email));
    }

    public void teste() {

    }
}