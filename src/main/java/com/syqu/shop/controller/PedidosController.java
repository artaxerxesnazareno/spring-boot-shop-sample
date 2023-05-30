package com.syqu.shop.controller;


import com.syqu.shop.domain.Pedidos;
import com.syqu.shop.domain.Product;
import com.syqu.shop.repository.PedidosRepository;
import com.syqu.shop.repository.ProductRepository;
import com.syqu.shop.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Controller
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/pedidos/{id}")
    public String getPedidosSapatosById(@PathVariable UUID id, Model model) {
        List<Product> pedidosSapatos = pedidosService
                .findSapatosById(id);



        model.addAttribute("pedidosSapatos", pedidosSapatos);
        return "pedidosById";
    }
    @GetMapping("/pedidos")
    public String getAllPedidosSapatos1(Model model) {
        List<Pedidos> pedidosList = pedidosService.findAllPedidos();
        model.addAttribute("pedidosList", pedidosList);
        return "pedidos";
    }
    @GetMapping("/pedidos1")
    public String listarPedidos(Model model) {
        List<Pedidos> pedidos1 = pedidosRepository.findAll();
        model.addAttribute("pedidos1", pedidos1);
        return "pedidos1";
    }

}
