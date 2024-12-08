package bobr.flashcards.cards;

import bobr.flashcards.cards.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "*")
@RequestMapping("/api/v1/flash-cards")
public class FlashCardController {

    private final FlashCardService flashCardService;
    private final CategoryService categoryService;

    @Transactional
    @GetMapping
    public List<FlashCard> getAllFlashCards(@RequestParam("category") String categoryName) {
        return flashCardService.findAllByCategory(categoryName);
    }

    @Transactional
    @PostMapping
    public void addFlashCard(
            @RequestParam("content") String content,
            @RequestParam("category") String categoryName,
            @RequestParam("image") MultipartFile file
    ) throws IOException {
        FlashCard flashCard = FlashCard.builder()
                .content(content)
                .category(categoryService.findByName(categoryName))
                .image(file.getBytes())
                .build();

        flashCardService.save(flashCard);
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        FlashCard card = flashCardService.findById(id);

        if (card.getImage() == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_PNG_VALUE)
                .body(card.getImage());
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id) {
        flashCardService.deleteById(id);
    }

}
