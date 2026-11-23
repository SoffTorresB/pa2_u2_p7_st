package com.uce.pa2.u2;

import com.uce.pa2.u2.pedidos.application.CategoriaService;
import com.uce.pa2.u2.pedidos.application.ClienteService;
import com.uce.pa2.u2.pedidos.application.PagoService;
import com.uce.pa2.u2.pedidos.application.PedidoService;
import com.uce.pa2.u2.pedidos.application.ProductoService;
import com.uce.pa2.u2.pedidos.domain.model.Categoria;
import com.uce.pa2.u2.pedidos.domain.model.Cliente;
import com.uce.pa2.u2.pedidos.domain.model.Pago;
import com.uce.pa2.u2.pedidos.domain.model.Pedido;
import com.uce.pa2.u2.pedidos.domain.model.Producto;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {
    @Inject
    private PedidoService pedidoService;
    @Inject
    private CategoriaService categoriaService;
    @Inject
    private ClienteService clienteService;
    @Inject
    private PagoService pagoService;
    @Inject
    private ProductoService productoService;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) throws Exception {
        Pedido pedido = new Pedido();
        pedido.setProducto("Producto de prueba");
        pedido.setPrecio(100.0);
        pedido.setFecha("2023-06-01");
        this.pedidoService.guardar(pedido);

        Categoria categoria = new Categoria();
        categoria.setNombre("Electrónica");
        categoria.setDescripcion("Productos electrónicos");
        categoria.setEstado("ACTIVA");
        categoria.setFechaCreacion("2023-06-01");
        this.categoriaService.guardar(categoria);

        Cliente cliente = new Cliente();
        cliente.setNombre("Ana");
        cliente.setApellido("Torres");
        cliente.setCorreo("ana@ejemplo.com");
        cliente.setTelefono("0999999999");
        this.clienteService.guardar(cliente);

        Pago pago = new Pago();
        pago.setMetodo("Tarjeta");
        pago.setMonto(100.0);
        pago.setFecha("2023-06-01");
        pago.setEstado("APROBADO");
        this.pagoService.guardar(pago);

        Producto producto = new Producto();
        producto.setNombre("Producto de prueba");
        producto.setDescripcion("Producto creado desde Main");
        producto.setPrecio(100.0);
        producto.setStock(10);
        this.productoService.guardar(producto);

        return 0;
    }

}