package bobr.flashcards.cards.category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Category {

    @Id
    @Column(unique = true, nullable = false)
    private String name;

}
