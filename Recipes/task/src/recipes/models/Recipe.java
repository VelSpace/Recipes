package recipes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @NotBlank(message = "Name should not be blank")
    private String name;

    @NotBlank(message = "Category should not be blank")
    private String category;

    @NotBlank(message = "Description should not be blank")
    private String description;

    @Size(min = 8)
    private String date;

    @NotNull(message = "There should be at least one ingredient")
    @Size(min = 1, message = "There should be at least one ingredient")
    private String[] ingredients;

    @NotNull(message = "Directions should not be null")
    @Size(min = 1, message = "There should be at least one direction")
    private String[] directions;

    public Recipe() {
    }

    public Recipe(String name, String description, String[] ingredients, String[] directions, String category) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
        this.category = category;
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        this.date = currentDateTime.format(formatter);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String[] getDirections() {
        return directions;
    }

    public void setDirections(String[] directions) {
        this.directions = directions;
    }

    @Override
    public String toString() {
        // change the format such that it prints the recipe as JSON
        return "{" +
                "\"name\":\"" + name + '\"' +
                ", \"description\":\"" + description + '\"' +
                ", \"ingredients\":" + Arrays.toString(ingredients) +
                ", \"directions\":" + Arrays.toString(directions) +
                '}';
    }
}