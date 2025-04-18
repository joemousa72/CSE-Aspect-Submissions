package com.example.lab3.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

public record CreateBrandDTO(@NotBlank String name) {}

