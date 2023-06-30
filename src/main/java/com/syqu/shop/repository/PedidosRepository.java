package com.syqu.shop.repository;


<<<<<<< HEAD
import com.syqu.shop.domain.Pedidos;
=======
import com.syqu.shop.model.Pedidos;
>>>>>>> aaf5c88875e0e2592216b0a48740ce82bc83ae30
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, UUID> {


}
