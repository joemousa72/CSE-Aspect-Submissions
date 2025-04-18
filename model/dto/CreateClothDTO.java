package com.example.lab3.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CreateClothDTO(@NotBlank String title,
                             @NotNull  Long authorId) {}

