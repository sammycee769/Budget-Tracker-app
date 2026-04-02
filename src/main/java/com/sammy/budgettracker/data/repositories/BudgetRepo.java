package com.sammy.budgettracker.data.repositories;

import com.sammy.budgettracker.data.models.Budget;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;

@Repository
public interface BudgetRepo extends MongoRepository<Budget,String> {
    List<Budget> findAllByUserId(String userId);
    List<Budget> findAllByUserIdAndMonthAndYear(String userId, Month month, int year);
    List<Budget> findAllByUserIdAndYear(String userId, int year);
    List<Budget> findAllByUserIdAndCategoryId(String userId, String categoryId);
}
