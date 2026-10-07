package com.fikri.pelanggan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fikri.pelanggan.entity.Pelanggan;
import com.fikri.pelanggan.repository.PelangganRepository;

@Service
public class PelangganService {

    @Autowired
    private PelangganRepository pelangganRepository;

    public List<Pelanggan> getAllPelanggan() {
        return pelangganRepository.findAll();
    }

    public Pelanggan findPelangganById(Long id) {
        return pelangganRepository.findById(id).orElse(null);
    }

    public Pelanggan savePelanggan(Pelanggan pelanggan) {
        return pelangganRepository.save(pelanggan);
    }

    public void deletePelanggan(Long id) {
        pelangganRepository.deleteById(id);
    }

    public Pelanggan updatePelanggan(Long id, Pelanggan pelanggan) {
        Pelanggan existing = pelangganRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setNama(pelanggan.getNama());
            existing.setEmail(pelanggan.getEmail());
            existing.setNoHp(pelanggan.getNoHp());
            existing.setAlamat(pelanggan.getAlamat());

            return pelangganRepository.save(existing);
        }

        return null;
    }
}