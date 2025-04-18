package com.example.lab3.controller;

import com.example.lab3.dto.CreateClothDTO;
import com.example.lab3.dto.UpdateClothDTO;
import com.example.lab3.model.Cloth;
import com.example.lab3.service.ClothService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class ClothController {

    private final ClothService clothService;

    public ClothController(ClothService clothService) {
        this.clothService = clothService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cloth create(@Valid @RequestBody CreateClothDTO dto) {
        return clothService.create(dto);
    }

    @GetMapping("/{id}")
    public Cloth get(@PathVariable Long id) {
        return clothService.get(id);
    }

    @GetMapping
    public List<Cloth> list() {
        return clothService.list();
    }

    @PutMapping("/{id}")
    public Cloth update(@PathVariable Long id,
                        @Valid @RequestBody UpdateClothDTO dto) {
        return clothService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clothService.delete(id);
    }
}

