package bobr.flashcards.cards;

import bobr.flashcards.cards.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlashCardService {

    private final FlashCardRepository flashCardRepository;
    private final CategoryService categoryService;

    public List<FlashCard> findAllByCategory(String categoryName) {
        return flashCardRepository.findAllByCategory(categoryService.findByName(categoryName));
    }

    @Transactional
    public void save(FlashCard flashCard) {
        flashCardRepository.save(flashCard);
    }

    public FlashCard findById(Long id) {
        return flashCardRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        flashCardRepository.deleteById(id);
    }

}
