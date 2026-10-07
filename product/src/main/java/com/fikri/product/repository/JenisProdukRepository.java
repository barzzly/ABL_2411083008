package com.fikri.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fikri.product.entity.JenisProduk;

@Repository
public interface JenisProdukRepository extends JpaRepository<JenisProduk, Long> {
}