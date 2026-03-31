package com.sammy.budgettracker.data.models;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.Month;

@Document(collection = "transactions")
@Data
public class Transaction {
    @Id
    private String id;

    private String userId;

    @NotBlank(message = "Category is required")
    private String categoryId;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than zero")
    private double amount;

    @NotNull(message = "Month is required")
    private Month month;

    @Min(value = 2000, message = "Year must be valid")
    @Max(value = 2100, message = "Year must be valid")
    private int year;

    private String note;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
}
