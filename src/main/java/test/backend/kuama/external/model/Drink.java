package test.backend.kuama.external.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Drink {

    @JsonProperty("strCategory")
    private String strCategory;

    @JsonProperty("strDrink")
    private String strDrink;

    @JsonProperty("idDrink")
    private Integer idDrink;

    @JsonProperty("strDrinkThumb")
    private String strDrinkThumb;

    @JsonProperty("strGlass")
    private String strGlass;

    @JsonProperty("strInstructions")
    private String strInstructions;

    @JsonProperty("strInstructionsES")
    private String strInstructionsES;

    @JsonProperty("strInstructionsDE")
    private String strInstructionsDE;

    @JsonProperty("strInstructionsFR")
    private String strInstructionsFR;

    @JsonProperty("strInstructionsIT")
    private String strInstructionsIT;

    @JsonProperty("strIngredient1")
    private String strIngredient1;

    @JsonProperty("strIngredient2")
    private String strIngredient2;

    @JsonProperty("strIngredient3")
    private String strIngredient3;

    @JsonProperty("strIngredient4")
    private String strIngredient4;

    @JsonProperty("strIngredient5")
    private String strIngredient5;

    @JsonProperty("strIngredient6")
    private String strIngredient6;

    @JsonProperty("strIngredient7")
    private String strIngredient7;

    @JsonProperty("strIngredient8")
    private String strIngredient8;

    @JsonProperty("strIngredient9")
    private String strIngredient9;

    @JsonProperty("strIngredient10")
    private String strIngredient10;

    @JsonProperty("strIngredient11")
    private String strIngredient11;

    @JsonProperty("strIngredient12")
    private String strIngredient12;

    @JsonProperty("strIngredient13")
    private String strIngredient13;

    @JsonProperty("strIngredient14")
    private String strIngredient14;

    @JsonProperty("strIngredient15")
    private String strIngredient15;
}
