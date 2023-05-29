package com.syqu.shop.service;

import com.syqu.shop.model.PedidosSapatos;
import com.syqu.shop.model.Product;
import com.syqu.shop.repository.PedidosSapatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PedidosSapatosService {

    @Autowired
    private PedidosSapatosRepository pedidosSapatosRepository;

    public Set<Product> findSapatosById(UUID pedidosSapatosId) {
        PedidosSapatos pedidosSapatos = pedidosSapatosRepository.findById(pedidosSapatosId).orElse(null);
        if (pedidosSapatos == null) {
            return null;
        }
        return pedidosSapatos.getProducts();
    }
    public List<PedidosSapatos> findAllPedidosSapatos() {
        return pedidosSapatosRepository.findAll();
    }
    public PedidosSapatos createPedidosSapatos(Set<Product> products) {
        PedidosSapatos pedidosSapatos = new PedidosSapatos();


        pedidosSapatos.setProducts(products);
        pedidosSapatosRepository.save(pedidosSapatos);

        return pedidosSapatos;
    }
    public List<PedidosSapatos> findAllPedidosWithProducts() {
        return pedidosSapatosRepository.findAll().stream()
                .map(pedidosSapatos -> {
                    return new PedidosSapatos();
                })
                .collect(Collectors.toList());
    }

}
