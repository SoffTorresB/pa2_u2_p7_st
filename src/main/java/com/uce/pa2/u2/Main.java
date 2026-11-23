package com.uce.pa2.u2;

import com.uce.pa2.u2.pedidos.application.PedidoService;
import com.uce.pa2.u2.pedidos.domain.model.Pedido;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {
    @Inject
    private PedidoService pedidoService;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) throws Exception {
        System.out.println("[Producto de Prueba]");

        //CREATE
      /* Pedido pedido = new Pedido();
        pedido.setProducto("Producto de prueba");
        pedido.setPrecio(100.0);
        pedido.setFecha("2023-06-01");

      
        this.pedidoService.guardar(pedido);*/
        

        //READ
        Pedido pedido = this.pedidoService.buscarPorId(2);
        System.out.println("Pedido encontrado: " + pedido); 


        //UPDATE
        //pedido.setPrecio(200.0);
       // this.pedidoService.actualizar(pedido);

        //Pedido pedido2 = this.pedidoService.buscarPorId(1);
        //System.out.println("Pedido encontrado: " + pedido2);
        return 0;


    }

}