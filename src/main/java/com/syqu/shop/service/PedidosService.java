package com.syqu.shop.service;


import com.syqu.shop.domain.PedidoProduct;
import com.syqu.shop.domain.Pedidos;
import com.syqu.shop.domain.Product;
import com.syqu.shop.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    public List<Product> findSapatosById(UUID pedidosId) {
        Pedidos pedidos = pedidosRepository.findById(pedidosId).orElse(null);
        if (pedidos == null) {
            return null;
        }
        return pedidos.getPedidoProducts().stream()
                .map(PedidoProduct::getProduct)
                .collect(Collectors.toList());
    }

    public List<Pedidos> findAllPedidos() {
        return pedidosRepository.findAll();
    }
   /* public Pedidos createPedidosSapatos(Set<PedidoProduct> products) {
        Pedidos pedidos = new Pedidos();


        pedidos.setPedidoProducts(products);
        pedidosRepository.save(pedidos);

        return pedidos;
    }*/
   public Pedidos createPedidosSapatos(Set<Product> products) {
       Pedidos pedidos = new Pedidos();


       for (Product product : products) {
           PedidoProduct pedidoProduct = new PedidoProduct();
           pedidoProduct.setPedido(pedidos);
           pedidoProduct.setProduct(product);

           pedidos.getPedidoProducts().add(pedidoProduct);
       }

       pedidosRepository.save(pedidos);
       return pedidos;
   }

    public List<Pedidos> findAllPedidosWithProducts() {
        return pedidosRepository.findAll().stream()
                .map(pedidosSapatos -> {
                    return new Pedidos();
                })
                .collect(Collectors.toList());
    }

}
