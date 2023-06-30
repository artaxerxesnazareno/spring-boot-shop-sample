package com.syqu.shop.service;


import com.syqu.shop.model.PedidoProduct;
import com.syqu.shop.model.Pedidos;
import com.syqu.shop.model.Product;
import com.syqu.shop.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.syqu.shop.model.User;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.math.BigDecimal;
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
   public Pedidos createPedidosSapatos(Set<Product> products, User user) {
       Pedidos pedidos = new Pedidos();


       for (Product product : products) {
           PedidoProduct pedidoProduct = new PedidoProduct();
           pedidoProduct.setPedido(pedidos);
           pedidoProduct.setProduct(product);

           pedidos.getPedidoProducts().add(pedidoProduct);
       }
        pedidos.setUser(user);
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

    public BigDecimal totalPedidosValor(){
        List<Pedidos> pedidosList = pedidosRepository.findAll();
        BigDecimal totalAmount = BigDecimal.ZERO;
        for(Pedidos pedidos: pedidosList){
            double orderTotal = pedidos.getPedidoProducts().stream()
            .mapToDouble(pedidoProduct -> pedidoProduct.getProduct().getPrice().doubleValue())
            .sum();
            totalAmount = totalAmount.add(BigDecimal.valueOf(orderTotal));
        }
        return totalAmount;
    }

    public long countAllPedidos(){
        return pedidosRepository.count();
    }
}
