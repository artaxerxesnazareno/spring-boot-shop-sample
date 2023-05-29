package com.syqu.shop.repository;

import com.syqu.shop.model.PedidosSapatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface PedidosSapatosRepository extends JpaRepository<PedidosSapatos, UUID> {


}
