package com.ecommerce.ecommerce.controllers;

import com.ecommerce.ecommerce.models.Produto;
import com.ecommerce.ecommerce.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> create(@Valid @RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.saveProduto(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> list() {
        return ResponseEntity.ok(produtoService.listAllProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> searchForIdProduto(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.searchForIdProduto(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @Valid @RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.updateProduto(id, produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }
}