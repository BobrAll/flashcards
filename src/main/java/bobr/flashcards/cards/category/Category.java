package bobr.flashcards.cards.category;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Category {

    @Id
    private String name;

    public Category(String categoryName) {
        this.name = categoryName;
    }

}
