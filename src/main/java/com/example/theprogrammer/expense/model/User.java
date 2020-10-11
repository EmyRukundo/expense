package com.example.theprogrammer.expense.model;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;


import javax.persistence.*;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="User")
public class User {

    @Id
    private Long id;


    private String name;

    private String email;

}
