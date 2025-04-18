package com.example.lab3.controller;

import com.example.lab3.dto.CreateBrandDTO;
import com.example.lab3.dto.UpdateBrandDTO;
import com.example.lab3.model.Brand;
import com.example.lab3.service.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/authors")
public class BrandController {

    private final BrandService service;

    public BrandController(BrandService service) {   // constructor injection
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Brand> create(@Valid @RequestBody CreateBrandDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping("/{id}")
    public Brand read(@PathVariable Long id){ return service.get(id); }

    @PutMapping("/{id}")
    public Brand update(@PathVariable Long id,
                        @Valid @RequestBody UpdateBrandDTO dto){
        return service.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){ service.delete(id); }

    @GetMapping
    public List<Brand> list(){ return service.list(); }
}

