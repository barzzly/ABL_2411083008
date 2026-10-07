package com.fikri.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fikri.product.entity.JenisProduk;
import com.fikri.product.entity.Produk;
import com.fikri.product.service.JenisProdukService;
import com.fikri.product.service.ProdukService;


@RestController
@RequestMapping("/api/produk")
public class ProdukController {
    @Autowired
    private ProdukService produkService;
    @Autowired
    private JenisProdukService jenisProdukService;

    // --- ENDPOINT PRODUK ---
    @GetMapping
    public List<Produk> getAllProduk(@RequestParam(value = "idjenis", required = false) Long idjenis) {
        if (idjenis != null) {
            return produkService.getAllBarangByIdJenis(idjenis);
        }
        return produkService.getAllProduk();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produk> getProdukById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(produkService.getProdukById(id));
    }

    @PostMapping
    public ResponseEntity<Produk> createProduk(@RequestBody Produk produk) {
        return ResponseEntity.ok(produkService.saveProduk(produk));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Produk> updateProduk(@PathVariable("id") Long id, @RequestBody Produk produk) {
        return ResponseEntity.ok(produkService.updateProduk(id, produk));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduk(@PathVariable("id") Long id) {
        produkService.deleteProduk(id);
        return ResponseEntity.ok("Succes To Delete Data With ID : "+id);
    }

    // --- ENDPOINT JENIS PRODUK ---
    @GetMapping("/jenis")
    public List<JenisProduk> getAllJenisProduk() {
        return jenisProdukService.getAllJenisProduk();
    }

    @GetMapping("/jenis/{id}")
    public ResponseEntity<JenisProduk> getJenisProdukById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(jenisProdukService.getJenisProdukById(id));
    }

    @PostMapping("/jenis")
    public ResponseEntity<JenisProduk> createJenisProduk(@RequestBody JenisProduk jenisProduk) {
        return ResponseEntity.ok(jenisProdukService.saveJenisProduk(jenisProduk));
    }
    
    @PutMapping("/jenis/{id}")
    public ResponseEntity<JenisProduk> updateJenisProduk(@PathVariable("id") Long id, @RequestBody JenisProduk jenisproduk) {
        return ResponseEntity.ok(jenisProdukService.updateJenisProduk(id, jenisproduk));
    }
    
    @DeleteMapping("/jenis/{id}")
    public ResponseEntity<String> deleteJenisProduk(@PathVariable("id") Long id) {
        jenisProdukService.deleteJenisProduk(id);
        return ResponseEntity.ok("Succes To Delete Data With ID : "+id);
    }
}
