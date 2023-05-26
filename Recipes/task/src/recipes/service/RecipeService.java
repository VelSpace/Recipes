package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.models.Recipe;
import recipes.repository.RecipeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public int addRecipe(Recipe recipe) {
        Recipe savedRecipe = recipeRepository.save(recipe);
        return savedRecipe.getId();
    }

    public Recipe getRecipe(int id) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        if (optionalRecipe.isPresent()) {
            return optionalRecipe.get();
        }
        throw new IllegalArgumentException("Recipe not found");
    }

    public void updateRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public void deleteRecipe(int id) {
        try {
            recipeRepository.deleteById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Recipe not found");
        }
    }

    public List<Recipe> getRecipesByCategory(String category) {
        return recipeRepository.findByCategoryIgnoreCaseOrderByDateDesc(category);
    }

    public List<Recipe> getRecipesByNameContaining(String name) {
        return recipeRepository.findByNameContainingIgnoreCaseOrderByDateDesc(name);
    }
}
