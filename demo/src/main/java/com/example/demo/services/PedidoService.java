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

    public List<PedidoModel> buscarTodosPedidos() { return pedidoRepository.findAll(); }

    public PedidoModel criarPedido(PedidoModel pedidoModel) { return pedidoRepository.save(pedidoModel); }

    public Optional<PedidoModel> buscarPedidoId(Long id) { return pedidoRepository.findById(id); }

    public PedidoModel atualizarPedido(Long id, PedidoModel pedidoModel) {
        PedidoModel model = pedidoRepository.findById(id).get();
        model.setData(pedidoModel.getData());
        model.setValorTotal(pedidoModel.getValorTotal());
        model.setStatus(pedidoModel.getStatus());
        return pedidoRepository.save(model);
    }

    public void excluir(Long id) { pedidoRepository.deleteById(id);}

}
