package bobr.flashcards.cards;

import bobr.flashcards.cards.category.Category;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlashCard {

    private static final String PREFIX = "data/";
    private static final String EXTENSION = ".png";

    @Id
    @JsonIgnore
    @GeneratedValue
    private Long id;

    @Lob
    @JsonIgnore
    private byte[] image;

    private String word;

    private String translation;

    @ManyToOne
    private Category category;

    @JsonGetter(value = "id")
    public Long getId() {
        return id;
    }

    @JsonGetter(value = "category")
    public String getCategory() {
        return category.getName();
    }

}