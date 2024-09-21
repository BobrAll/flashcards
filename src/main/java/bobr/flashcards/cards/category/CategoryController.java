package bobr.flashcards.cards.category;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "*")
@RequestMapping("/api/v1/flash-cards/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<String> getAllCategories() {
        return categoryService.findAll();
    }

    @PostMapping
    public void addCategory(@RequestBody Category category) {
        categoryService.save(category);
    }

    @DeleteMapping("/{categoryName}")
    public void deleteCategory(@PathVariable("categoryName") String id) {
        categoryService.deleteById(id);
    }

}
