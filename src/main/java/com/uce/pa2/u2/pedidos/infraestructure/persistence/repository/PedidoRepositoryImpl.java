package com.uce.pa2.u2.pedidos.infraestructure.persistence.repository;

import com.uce.pa2.u2.pedidos.domain.model.Pedido;
import com.uce.pa2.u2.pedidos.domain.repository.PedidoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class PedidoRepositoryImpl implements PedidoRepository {
    @Inject
    private EntityManager entityManager; // Atributo para que en la base de datos se pueda hacer la persistencia de los
                                         // objetos

    // Implementación de los métodos del repositorio
    @Override
    public void create(Pedido pedido) {
        // Lógica para crear un pedido en la base de datos
        this.entityManager.persist(pedido); // Persistir el pedido en la base de datos
    }

    @Override
    public Pedido read(Integer id) {
        return this.entityManager.find(Pedido.class, id); // Retornar el pedido encontrado o null si no existe, tambien
                                                          // se pone el valor por el que se va a buscar y el tipo de
                                                          // objeto que se va a buscar
    }

    @Override
    public void update(Pedido pedido) {
        this.entityManager.merge(pedido); // Fusionar los cambios en el pedido
    }

    @Override
    public void delete(Integer id) {
        Pedido pedido = this.read(id); // Obtener el pedido a eliminar utilizando el método read
        if (pedido != null) {
            this.entityManager.remove(pedido);
        }
    }
}
