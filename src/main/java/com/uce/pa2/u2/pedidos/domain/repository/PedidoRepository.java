package com.uce.pa2.u2.pedidos.domain.repository;

import com.uce.pa2.u2.pedidos.domain.model.Pedido;

public interface PedidoRepository {
    //CREATE
    public void create(Pedido pedido);
    //READ: por id
    public Pedido read(Integer id);
    //UPDATE    
    public void update(Pedido pedido);
    //DELETE
    public void delete(Integer id);

}
