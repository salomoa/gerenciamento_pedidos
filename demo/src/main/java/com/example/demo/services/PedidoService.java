package com.example.demo.services;

import com.example.demo.models.PedidoModel;
import com.example.demo.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository  pedidoRepository;

    public List<PedidoModel> findAll() { return pedidoRepository.findAll(); }

    public PedidoModel criarPedido(PedidoModel pedidoModel) { return pedidoRepository.save(pedidoModel); }

    public Optional<PedidoModel> buscarId(Long id) { return pedidoRepository.findById(id); }

    public PedidoModel atualizarPedido(PedidoModel pedidoModel) {
        PedidoModel model = pedidoRepository.findById(id).get();
    }

}
