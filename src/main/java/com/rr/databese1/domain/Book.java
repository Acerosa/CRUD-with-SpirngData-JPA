package com.rr.databese1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="books")
public class Book {
    @Id
    private String isbn;
    private String title;

@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name = "author_id")
    public Author author;

}
