package pl.gm.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @NotBlank
    private String isbn;

    @NotBlank
    @Size(min = 2,max=45)
    private String title;

    @NotBlank
    @Size(min = 5,max=60)
    private String author;

    @NotBlank
    @Size(min = 2,max=45)
    private String publisher;

    @NotBlank
    @Size(min = 2,max=20)
    private String type;


    @Override
    public int compareTo(Book book) {
        return Comparator.comparing(Book::getId, Comparator.nullsLast(Long::compare)).compare(this, book);
    }
}
