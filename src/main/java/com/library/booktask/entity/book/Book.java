package com.library.booktask.entity.book;

import com.library.booktask.entity.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Where(clause = "is_deleted = false")
@Table(indexes = {@Index(name = "book_title_index", columnList = "title"),
                  @Index(name = "book_author_index", columnList = "author")})
public class Book extends Auditable {

    @Column(name = "title", length = 150, nullable = false)
    private String title;

    @Column(name = "author", length = 150, nullable = false)
    private String author;

    @Column(name = "description", length = 150, nullable = true)
    private String description;

}
