package bobr.flashcards.cards.category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "name", unique = true, nullable = false)
    private String name;

}
