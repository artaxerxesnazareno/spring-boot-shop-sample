package com.syqu.shop.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
<<<<<<< HEAD:src/main/java/com/syqu/shop/domain/Product.java
=======
import java.util.List;
>>>>>>> aaf5c88875e0e2592216b0a48740ce82bc83ae30:src/main/java/com/syqu/shop/model/Product.java
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

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
<<<<<<< HEAD:src/main/java/com/syqu/shop/domain/Product.java
    private List<PedidoProduct> pedidoProducts;
=======
    private List <PedidoProduct> pedidoProducts;
>>>>>>> aaf5c88875e0e2592216b0a48740ce82bc83ae30:src/main/java/com/syqu/shop/model/Product.java



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


<<<<<<< HEAD:src/main/java/com/syqu/shop/domain/Product.java


=======
>>>>>>> aaf5c88875e0e2592216b0a48740ce82bc83ae30:src/main/java/com/syqu/shop/model/Product.java

    @Column(name = "description",length = 2000)
    @NotNull
    @NotEmpty
    private String description;

    @Column(name = "image")
    private String imageUrl;

    @Column(name = "price")
    @NotNull
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;
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

