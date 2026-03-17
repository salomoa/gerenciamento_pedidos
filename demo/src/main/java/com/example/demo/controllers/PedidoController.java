package com.example.demo.controllers;

import com.example.demo.models.PedidoModel;
import com.example.demo.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = {"/pedido", "/pedidos"})
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoModel>> findAll(){
        List<PedidoModel> requisicao = pedidoService.findAll();
        return ResponseEntity.ok().body(requisicao);
    }

    @PostMapping
    public ResponseEntity<PedidoModel> criarPedido(@RequestBody PedidoModel pedidoModel){

        PedidoModel requisicao =  pedidoService.criarPedido(pedidoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(pedidoModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requisicao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        pedidoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<PedidoModel> findById(@PathVariable Long id){ return pedidoService.buscarId(id); }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoModel> atualizar(@PathVariable Long id, @RequestBody PedidoModel pedidoModel){

        PedidoModel requisicao = pedidoService.atualizarPedido(id,pedidoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(pedidoModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requisicao);
    }

}
