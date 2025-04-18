
package com.example.lab3.service;

import com.example.lab3.dto.CreateClothDTO;
import com.example.lab3.dto.UpdateClothDTO;
import com.example.lab3.model.Cloth;
import com.example.lab3.repository.BookRepository;
import com.example.lab3.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClothService {
    private final BookRepository   bookRepo;
    private final BrandRepository authorRepo;

    public ClothService(BookRepository bookRepo, BrandRepository authorRepo) {
        this.bookRepo   = bookRepo;
        this.authorRepo = authorRepo;
    }


    public Cloth create(CreateClothDTO dto) {
        com.example.lab3.model.Brand brand = authorRepo.findById(dto.authorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));
        Cloth b = new Cloth();
        b.setTitle(dto.title());
        b.setAuthor(brand);
        return bookRepo.save(b);
    }

    public Cloth update(Long id, UpdateClothDTO dto) {
        Cloth b = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        com.example.lab3.model.Brand brand = authorRepo.findById(dto.authorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));
        b.setTitle(dto.title());
        b.setAuthor(brand);
        return bookRepo.save(b);
    }

    public Cloth get(Long id)    { return bookRepo.findById(id).orElseThrow(); }
    public List<Cloth> list()    { return bookRepo.findAll(); }
    public void delete(Long id) { bookRepo.deleteById(id); }
}
