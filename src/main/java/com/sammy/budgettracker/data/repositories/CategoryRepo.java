package com.sammy.budgettracker.data.repositories;

import com.sammy.budgettracker.data.models.Category;
import com.sammy.budgettracker.data.models.CategoryType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends MongoRepository<Category,String> {
    List<Category> findAllByUserId(String userId);
    List<Category> findAllByUserIdAndType(String userId, CategoryType type);
    Category findByUserIdAndName(String userId, String categoryName);
}
