package com.fikri.pelanggan.Controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.fikri.pelanggan.entity.Pelanggan;
import com.fikri.pelanggan.service.PelangganService;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {

    @Autowired
    private PelangganService pelangganService;

    // --- ENDPOINT PELANGGAN ---

    @GetMapping
    public List<Pelanggan> getAllPelanggan() {
        return pelangganService.getAllPelanggan();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelanggan> getPelangganById(
            @PathVariable("id") Long id) {

        return ResponseEntity.ok(
            pelangganService.findPelangganById(id)
        );
    }

    @PostMapping
    public ResponseEntity<Pelanggan> createPelanggan(
            @RequestBody Pelanggan pelanggan) {

        return ResponseEntity.ok(
            pelangganService.savePelanggan(pelanggan)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelanggan> updatePelanggan(
            @PathVariable("id") Long id,
            @RequestBody Pelanggan pelanggan) {

        return ResponseEntity.ok(
            pelangganService.updatePelanggan(id, pelanggan)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePelanggan(
            @PathVariable("id") Long id) {

        pelangganService.deletePelanggan(id);

        return ResponseEntity.ok(
            "Succes To Delete Data With ID : " + id
        );
    }
}