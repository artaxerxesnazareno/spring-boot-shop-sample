package com.syqu.shop.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;


@Getter
@Setter

@Entity
@Table(name = "product")
public class Product {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "pedidos_sapatos_id")
    private UUID pedidosSapatosId;

    @ManyToMany
    @JoinColumn(name = "pedidos_sapatos_product")
    private Set<PedidosSapatos> pedidosSapatos;


    @Transient
    private MultipartFile imageFile;


    @Column(name = "name")
    @NotNull
    @NotEmpty
    private String name;

    @Column(name = "marca")
    private String marca;

    @Column(name = "tamanho")
    private String tamanho;

    @Column(name = "cor")
    private String cor;


    @Column(name = "description",length = 2000)
    @NotNull
    @NotEmpty
    private String description;

    @Column(name = "image")
    private String imageUrl;

    @Column(name = "price")
    @NotNull
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;

        return id == product.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
}

