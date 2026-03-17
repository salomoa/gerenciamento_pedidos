package com.example.demo.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_PEDIDO")
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime data;
    private BigDecimal valorTotal;
    private String status;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    @Column(name = "dataPedido")
    public LocalDateTime getData() { return data; }


    public void setData(LocalDateTime data) { this.data = LocalDateTime.now(); }

    @Column(name = "valorPedido")
    public BigDecimal getValorTotal() { return valorTotal; }

    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    @Column(name = "statusPedido")
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
