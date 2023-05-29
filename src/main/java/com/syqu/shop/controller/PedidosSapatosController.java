package com.syqu.shop.controller;

import com.syqu.shop.model.PedidosSapatos;
import com.syqu.shop.model.Product;
import com.syqu.shop.service.PedidosSapatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class PedidosSapatosController {

    @Autowired
    private PedidosSapatosService pedidosSapatosService;



    @GetMapping("/pedidos/{id}")
    public String getPedidosSapatosById(@PathVariable UUID id, Model model) {
        Set<Product> pedidosSapatos = pedidosSapatosService
                .findSapatosById(id);



        model.addAttribute("pedidosSapatos", pedidosSapatos);
        return "dashboard/pedidosSapatosById";
    }
    @GetMapping("/pedidos")
    public String getAllPedidosSapatos1(Model model) {
        List<PedidosSapatos> pedidosSapatosList = pedidosSapatosService.findAllPedidosSapatos();
        model.addAttribute("pedidosSapatosList", pedidosSapatosList);
        System.out.println(pedidosSapatosList);
        return "dashboard/pedidos";
    }
}
