package com.example.lab3.service;

import com.example.lab3.dto.CreateBrandDTO;
import com.example.lab3.dto.UpdateBrandDTO;
import com.example.lab3.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BrandService {

    private final BrandRepository repo;

    public BrandService(BrandRepository repo) {   // explicit constructor
        this.repo = repo;
    }

    public com.example.lab3.model.Brand create(CreateBrandDTO dto) {
        com.example.lab3.model.Brand brand = new com.example.lab3.model.Brand();
        brand.setName(dto.name());
        return repo.save(brand);
    }

    public com.example.lab3.model.Brand update(Long id, UpdateBrandDTO dto) {
        com.example.lab3.model.Brand brand = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        brand.setName(dto.name());
        return repo.save(brand);
    }

    public com.example.lab3.model.Brand get(Long id) { return repo.findById(id).orElseThrow(); }

    public List<com.example.lab3.model.Brand> list() { return repo.findAll(); }

    public void delete(Long id) { repo.deleteById(id); }
}
