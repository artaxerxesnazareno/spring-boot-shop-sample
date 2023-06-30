<<<<<<< HEAD:src/main/java/com/syqu/shop/domain/PedidoProduct.java
package com.syqu.shop.domain;
=======
package com.syqu.shop.model;
>>>>>>> aaf5c88875e0e2592216b0a48740ce82bc83ae30:src/main/java/com/syqu/shop/model/PedidoProduct.java

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;


@Getter
@Setter
@Entity
public class PedidoProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedidos pedido;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}

