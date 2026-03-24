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
    @Column(name = "dataPedido")
    private LocalDateTime data;
    @Column(name = "valorPedido")
    private BigDecimal valorTotal;
    @Column(name = "statusPedido")
    private String status;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public LocalDateTime getData() { return data; }

    public void setData(LocalDateTime data) { this.data = LocalDateTime.now(); }

    public BigDecimal getValorTotal() { return valorTotal; }

    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }
    
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
