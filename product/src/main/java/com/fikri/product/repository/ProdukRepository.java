package com.fikri.product.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.fikri.product.entity.Produk;

@Repository
public interface ProdukRepository extends JpaRepository<Produk, Long> {
    @Query(value = "SELECT * FROM produk WHERE idjenis = :idjenis", nativeQuery = true)
    List<Produk> getAllBarangByIdJenis(@Param("idjenis") Long idjenis);
}