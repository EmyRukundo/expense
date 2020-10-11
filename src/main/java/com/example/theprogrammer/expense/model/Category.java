package com.example.theprogrammer.expense.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name="category")
public class Category {

    @Id
    private Long id;


    @NonNull
    // Travel, Grocery,...
    private String name;

}
