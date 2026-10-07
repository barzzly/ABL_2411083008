package com.fikri.product.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fikri.product.entity.JenisProduk;
import com.fikri.product.repository.JenisProdukRepository;

@Service
public class JenisProdukService {
    @Autowired
    private JenisProdukRepository jenisProdukRepository;

    public List<JenisProduk> getAllJenisProduk() {
        return jenisProdukRepository.findAll();

    }

    public JenisProduk getJenisProdukById(Long id) {
        return jenisProdukRepository.findById(id).orElse(null);
    }

    public JenisProduk saveJenisProduk(JenisProduk jenisProduk) {
        return jenisProdukRepository.save(jenisProduk);
    }

    public void deleteJenisProduk(Long id) {
        jenisProdukRepository.deleteById(id);
    }

    public JenisProduk updateJenisProduk(Long id, JenisProduk jenisProduk) {
        JenisProduk existing = jenisProdukRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setJenis(jenisProduk.getJenis());
            return jenisProdukRepository.save(existing);
        }
        return null;
    }
}
