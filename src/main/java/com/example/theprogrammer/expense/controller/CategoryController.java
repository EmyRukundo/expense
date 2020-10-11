package com.example.theprogrammer.expense.controller;

import com.example.theprogrammer.expense.model.Category;
import expense.repository.CategoryRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryController categoryController){
        super();
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    Collection<Category> categories(){
        return categoryRepository.findAll();
        //select * from category
    }
// category 2
    @GetMapping("/category/{id}")
    ResponseEntity<?> getCategory(@PathVariable Long id){
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(response -> ResponseEntity.ok().body(response))
                .orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/category")
    ResponseEntity<Category> createCategory(@Validated @RequestBody Category category) throws URISyntaxException{
        Category result = categoryRepository.save(category);
        return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);
    }

    @PutMapping("/category/{id}")
    ResponseEntity<Category> updateCategory(@valid @RequestBody Category category){
        Category result = categoryRepository.save(category);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/category/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable long id){
        categoryRepository.deleteById(id);
        return ResponseEntity.ok.build();
    }
}
