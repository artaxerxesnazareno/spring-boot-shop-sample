package com.syqu.shop.repository;


import com.syqu.shop.domain.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, UUID> {


}
