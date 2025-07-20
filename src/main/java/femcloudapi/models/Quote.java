package femcloudapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="quotes")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String author;
    private String year;

    public Quote() {
    }

    public Quote(@NotBlank(message = "Text is required") @Size(min = 1, max = 200, message = "Text must contain min 1 and max 200 characters") String text, @NotBlank(message = "Author is required") String author, @NotBlank(message = "Year is required") String year) {
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }
}
