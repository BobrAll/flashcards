package bobr.flashcards.cards.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category findByName(String name) {
        return categoryRepository.findById(name).get();
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public List<String> findAll() {
        return categoryRepository.findAll().stream()
                .map(Category::getName)
                .toList();
    }
}
