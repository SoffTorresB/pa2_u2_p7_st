package com.uce.pa2.u2;

import java.util.Optional;

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

        
        

        //READ
        Optional<Pedido> pedido = this.pedidoService.buscarPorId(1);
        if(pedido.isPresent()) {
            System.out.println("Pedido encontrado: " + pedido.get());
        } else {
            System.out.println("Pedido no encontrado");
        }
       // Pedido pedido1 = this.pedidoService.buscarPorId(2);
        System.out.println("Pedido encontrado: " + pedido); 


        //UPDATE
       // pedido.setPrecio(200.0);
       //this.pedidoService.actualizar(pedido);

       // Pedido pedido2 = this.pedidoService.buscarPorId(1);
       // System.out.println("Pedido encontrado: " + pedido2);

       //READ by number
       Optional <Pedido> pedidoByNumber = this.pedidoService.buscarPorNumero("12345");
       if(pedidoByNumber.isPresent()) {
        System.out.println("Pedido encontrado por número: " + pedidoByNumber.get());    
       }else {
        System.out.println("Pedido no encontrado por número");
       }

        return 0;


    }

}