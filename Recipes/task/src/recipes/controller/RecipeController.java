package recipes.controller;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.models.Recipe;
import recipes.service.RecipeService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @GetMapping
    public String get(){
        return "war is connected";
    }

    @PostMapping("/new")
    public ResponseEntity<?> setSeat(@RequestBody @Valid Recipe recipe) {
        try {
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
            recipe.setDate(currentDateTime.format(formatter));
            int id = recipeService.addRecipe(recipe);
            return ResponseEntity.ok().body(
                    Map.of("id", id)
            );
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSeat(@PathVariable int id) {
        try {
            Recipe recipe = recipeService.getRecipe(id);
            return ResponseEntity.ok().body(recipe);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> updateRecipe(@PathVariable("id") int id, @RequestBody @Valid Recipe updatedRecipe) {
        try {
            Recipe recipe = recipeService.getRecipe(id);
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
            recipe.setDate(currentDateTime.format(formatter));
            recipe.setName(updatedRecipe.getName());
            recipe.setCategory(updatedRecipe.getCategory());
            recipe.setDescription(updatedRecipe.getDescription());
            recipe.setIngredients(updatedRecipe.getIngredients());
            recipe.setDirections(updatedRecipe.getDirections());
            recipeService.updateRecipe(recipe);

            return ResponseEntity.noContent().build(); // Recipe updated successfully, return 204
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Recipe not found, return 404
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // Invalid request, return 400
        }
    }

    @GetMapping("/search/")
    public ResponseEntity<List<Recipe>> searchRecipes(@RequestParam(required = false) String category,
                                                      @RequestParam(required = false) String name) {
        if ((category == null && name == null) || (category != null && name != null)) {
            return ResponseEntity.badRequest().build(); // Invalid request, return 400
        }

        List<Recipe> matchingRecipes;

        if (category != null) {
            // Filter recipes by category (case-insensitive) and sort by date (newer first)
            matchingRecipes = recipeService.getRecipesByCategory(category.toLowerCase());
        } else {
            // Filter recipes by name (case-insensitive) and sort by date (newer first)
            matchingRecipes = recipeService.getRecipesByNameContaining(name.toLowerCase());
        }

        return ResponseEntity.ok(matchingRecipes); // Return the matching recipes, return 200
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable int id) {
        try {
            recipeService.deleteRecipe(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}