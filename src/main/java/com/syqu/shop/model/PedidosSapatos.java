package com.syqu.shop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class PedidosSapatos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinColumn(name = "pedidos_sapatos_product")
    private Set<Product> products;



}
