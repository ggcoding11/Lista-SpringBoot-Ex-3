package com.example.ex_3.controller;

import com.example.ex_3.model.Pedido;
import com.example.ex_3.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService service;

    @GetMapping
    public ResponseEntity<List<Pedido>> listarTodos() {
        List<Pedido> request = service.listarTodos();

        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> listarPorId(@PathVariable Long id) {
        Pedido request = service.listarPorId(id).get();

        return ResponseEntity.ok().body(request);
    }

    @PostMapping
    public ResponseEntity<Pedido> criar(@RequestBody Pedido p) {
        Pedido request = service.criar(p);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}