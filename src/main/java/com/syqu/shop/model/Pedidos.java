<<<<<<< HEAD:src/main/java/com/syqu/shop/domain/Pedidos.java
package com.syqu.shop.domain;
=======
package com.syqu.shop.model;
>>>>>>> aaf5c88875e0e2592216b0a48740ce82bc83ae30:src/main/java/com/syqu/shop/model/Pedidos.java

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
<<<<<<< HEAD:src/main/java/com/syqu/shop/domain/Pedidos.java
import java.util.Set;
=======
import java.util.List;
import java.util.ArrayList;
>>>>>>> aaf5c88875e0e2592216b0a48740ce82bc83ae30:src/main/java/com/syqu/shop/model/Pedidos.java
import java.util.UUID;

@Getter
@Setter
@Entity
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
<<<<<<< HEAD:src/main/java/com/syqu/shop/domain/Pedidos.java
    private Set<PedidoProduct> pedidoProducts = new HashSet<>();
=======
    private List<PedidoProduct> pedidoProducts = new ArrayList<>();
>>>>>>> aaf5c88875e0e2592216b0a48740ce82bc83ae30:src/main/java/com/syqu/shop/model/Pedidos.java




}
