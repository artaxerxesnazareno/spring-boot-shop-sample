package com.syqu.shop.controller;

<<<<<<< HEAD
=======
import com.syqu.shop.model.PedidoProduct;
>>>>>>> aaf5c88875e0e2592216b0a48740ce82bc83ae30
import com.syqu.shop.service.PedidosService;
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
import com.syqu.shop.service.UserService;
import java.security.Principal;
import com.syqu.shop.model.User;
import java.util.HashSet;
import java.util.Set;

import java.util.HashSet;
import java.util.Set;

@Controller
public class CartController {
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);
<<<<<<< HEAD
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;
    @Autowired
    private PedidosService pedidosService;
=======
>>>>>>> aaf5c88875e0e2592216b0a48740ce82bc83ae30

    @Autowired
    private  ShoppingCartService shoppingCartService;
    private final ProductService productService;
    @Autowired
    private PedidosService pedidosService;

     @Autowired
    private  UserService userService;

    @Autowired
    public CartController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("products", shoppingCartService.productsInCart());
        model.addAttribute("productsCount", shoppingCartService.productsInCart().size());
        model.addAttribute("totalPrice", shoppingCartService.totalPrice());

        return "cart";
    }

    @GetMapping("/cart/add/{id}")
    public String addProductToCart(@PathVariable("id") long id) {
        Product product = productService.findById(id);
        if (product != null) {
            shoppingCartService.addProduct(product);
            logger.debug(String.format("Product with id: %s added to shopping cart.", id));
        }
        return "redirect:/home";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeProductFromCart(@PathVariable("id") long id) {
        Product product = productService.findById(id);
        if (product != null) {
            shoppingCartService.removeProduct(product);
            logger.debug(String.format("Product with id: %s removed from shopping cart.", id));
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/clear")
    public String clearProductsInCart() {
        shoppingCartService.clearProducts();

        return "redirect:/cart";
    }

    @GetMapping("/cart/checkout")
<<<<<<< HEAD
    public String cartCheckout() {
        Set<Product> list = new HashSet<Product>();
        list = shoppingCartService.productsInCart().keySet();
        pedidosService.createPedidosSapatos(list);

        shoppingCartService.cartCheckout();
        return "confirm_checkout";
=======
    public String cartCheckout(Principal principal) {
       User user = userService.findByUsername(principal.getName());

        Set<Product> list = new HashSet<Product>();
        list = shoppingCartService.productsInCart().keySet();
        pedidosService.createPedidosSapatos(list, user);

        shoppingCartService.cartCheckout();
        return "checkout";
>>>>>>> aaf5c88875e0e2592216b0a48740ce82bc83ae30
    }
}
