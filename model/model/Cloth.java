package com.example.lab3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Cloth {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    public void setTitle(String title)   { this.title = title; }
    public void setAuthor(Brand brand) { this.brand = brand; }



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")    // FK column
    private Brand brand;
}

