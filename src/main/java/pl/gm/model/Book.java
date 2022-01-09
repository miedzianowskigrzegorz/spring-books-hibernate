package pl.gm.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Comparator;



@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book implements Comparable<Book>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;


    @Override
    public int compareTo(Book book) {
        return Comparator.comparing(Book::getId, Comparator.nullsLast(Long::compare)).compare(this, book);
    }
}
