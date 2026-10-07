package com.fikri.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fikri.product.entity.Produk;
import com.fikri.product.repository.ProdukRepository;

@Service
public class ProdukService {
    @Autowired
    private ProdukRepository produkRepository;

    public List<Produk> getAllProduk() {
        return produkRepository.findAll();
    }

    public Produk getProdukById(Long id) {
        return produkRepository.findById(id).orElse(null);
    }

    public Produk saveProduk(Produk produk) {
        return produkRepository.save(produk);
    }

    public void deleteProduk(Long id) {
        produkRepository.deleteById(id);
    }

    public Produk updateProduk(Long id, Produk produk) {
        Produk existing = produkRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNama(produk.getNama());
            existing.setHarga(produk.getHarga());
            existing.setDeskripsi(produk.getDeskripsi());
            existing.setIdJenis(produk.getIdJenis());
            return produkRepository.save(existing);
        }
        return null;
    }

    public List<Produk> getAllBarangByIdJenis(Long idjenis) {
        return produkRepository.getAllBarangByIdJenis(idjenis);
    }
}
