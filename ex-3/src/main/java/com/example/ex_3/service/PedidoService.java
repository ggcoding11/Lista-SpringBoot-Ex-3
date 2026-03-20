package com.example.ex_3.service;
import com.example.ex_3.model.Pedido;
import com.example.ex_3.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    public List<Pedido> listarTodos() {
        return repository.findAll();
    }

    public Optional<Pedido> listarPorId(Long id) {
        return repository.findById(id);
    }

    public Pedido criar(Pedido p) {
        return repository.save(p);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
