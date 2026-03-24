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
@RequestMapping(path = {"/pedidos/", "/pedidos"})
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoModel>> buscarTodosOsPedidos(){
        List<PedidoModel> requisicao = pedidoService.buscarTodosPedidos();
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
    public Optional<PedidoModel> buscarPedidoPorId(@PathVariable Long id){ return pedidoService.buscarPedidoId(id); }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoModel> atualizar(@PathVariable Long id, @RequestBody PedidoModel pedidoModel){
        PedidoModel requisicao = pedidoService.atualizarPedido(id,pedidoModel);

        return ResponseEntity.ok().body(requisicao);
    }

}
