package it.akaisara.backendtest.domain.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String glass;

    @Column(columnDefinition = "TEXT")
    private String instructions;

    @Column(columnDefinition = "TEXT")
    private List<String> ingredients;
    private String thumbnail;

    public Drink(String name, String glass, String instructions, List<String> ingredients, String thumbnail) {
        this.name = name;
        this.glass = glass;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.thumbnail = thumbnail;
    }

    protected Drink() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return Objects.equals(id, drink.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getName() {
        return name;
    }

    public String getGlass() {
        return glass;
    }

    public String getInstructions() {
        return instructions;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
