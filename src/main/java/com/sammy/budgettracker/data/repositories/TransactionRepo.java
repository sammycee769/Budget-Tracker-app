package com.sammy.budgettracker.data.repositories;

import com.sammy.budgettracker.data.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;

@Repository
public interface TransactionRepo extends MongoRepository<Transaction,String> {
    List<Transaction> findAllByUserId(String userId);
    List<Transaction> findAllByUserIdAndMonthAndYear(String userId, Month month, int year);
    List<Transaction> findAllByUserIdAndYear(String userId, int year);
    List<Transaction> findAllByUserIdAndCategoryId(String userId, String categoryId);
}
