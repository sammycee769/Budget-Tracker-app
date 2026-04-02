package com.sammy.budgettracker.data.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "Expenses")
@Data
public class Expense {
    @Id
    private String id;
    private String userId;
    @NotBlank(message = "category is required")
    private String categoryId;
    private String budgetId;
    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than zero")
    private double amount;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
}
