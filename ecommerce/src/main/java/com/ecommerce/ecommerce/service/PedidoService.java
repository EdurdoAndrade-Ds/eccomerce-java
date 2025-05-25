package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.modules.Pedido;
import com.ecommerce.ecommerce.modules.Cliente;
import com.ecommerce.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private ProdutoService produtoService;
    
    @Autowired
    private ClienteService clienteService;

    // Criar novo pedido
    @Transactional
    public Pedido criar(Pedido pedido) {
        // Verifica se o cliente existe
        Cliente cliente = clienteService.buscarPorId(pedido.getCliente().getId())
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        
        // Verifica e atualiza o estoque de cada item do pedido
        pedido.getItens().forEach(item -> {
            if (!produtoService.verificarEstoque(item.getProduto().getId(), item.getQuantidade())) {
                throw new RuntimeException("Estoque insuficiente para o produto: " + item.getProduto().getId());
            }
            produtoService.atualizarEstoque(item.getProduto().getId(), item.getQuantidade());
        });

        pedido.setDataPedido(LocalDateTime.now());
        return pedidoRepository.save(pedido);
    }

    // Buscar todos os pedidos
    public List<Pedido> buscarTodos() {
        return pedidoRepository.findAll();
    }

    // Buscar pedido por ID
    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    // Buscar pedidos por cliente
    public List<Pedido> buscarPorCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    // Atualizar status do pedido
    @Transactional
    public Pedido atualizarStatus(Long id, String novoStatus) {
        Pedido pedido = buscarPorId(id)
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        
        pedido.setStatus(novoStatus);
        return pedidoRepository.save(pedido);
    }

    // Cancelar pedido
    @Transactional
    public void cancelarPedido(Long id) {
        Pedido pedido = buscarPorId(id)
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
            
        if ("CANCELADO".equals(pedido.getStatus())) {
            throw new RuntimeException("Pedido já está cancelado");
        }
        
        // Devolve os itens ao estoque
        pedido.getItens().forEach(item -> {
            produtoService.atualizarEstoque(
                item.getProduto().getId(), 
                -item.getQuantidade() // Número negativo para aumentar o estoque
            );
        });
        
        pedido.setStatus("CANCELADO");
        pedidoRepository.save(pedido);
    }
}