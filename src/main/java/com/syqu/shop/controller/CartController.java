package com.syqu.shop.controller;

import com.syqu.shop.model.PedidosSapatos;
import com.syqu.shop.repository.PedidosSapatosRepository;
import com.syqu.shop.service.PedidosSapatosService;
import com.syqu.shop.service.ShoppingCartService;
import com.syqu.shop.model.Product;
import com.syqu.shop.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class CartController {
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;
    private PedidosSapatosService pedidosSapatosService;

    @Autowired
    private PedidosSapatosRepository pedidosSapatosRepository;
    @Autowired
    public CartController(ShoppingCartService shoppingCartService, ProductService productService,  PedidosSapatosService pedidosSapatosService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
        this.pedidosSapatosService = pedidosSapatosService;
    }

    @GetMapping("/cart")
    public String cart(Model model){
        model.addAttribute("products", shoppingCartService.productsInCart());
        model.addAttribute("productsCount", shoppingCartService.productsInCart().size());
        model.addAttribute("totalPrice", shoppingCartService.totalPrice());

        return "cart";
    }

    @GetMapping("/cart/add/{id}")
    public String addProductToCart(@PathVariable("id") long id){
        Product product = productService.findById(id);
        if (product != null){
            shoppingCartService.addProduct(product);
            logger.debug(String.format("Product with id: %s added to shopping cart.", id));
        }
        return "redirect:/home";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeProductFromCart(@PathVariable("id") long id){
        Product product = productService.findById(id);
        if (product != null){
            shoppingCartService.removeProduct(product);
            logger.debug(String.format("Product with id: %s removed from shopping cart.", id));
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/clear")
    public String clearProductsInCart(){
        shoppingCartService.clearProducts();

        return "redirect:/cart";
    }

    @GetMapping("/cart/checkout")
    public String cartCheckout(){
        Set<Product> list = new HashSet<>();
        list = shoppingCartService.productsInCart().keySet();
        pedidosSapatosService.createPedidosSapatos( list);


        return "redirect:/cart";
    }

}
