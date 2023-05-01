package it.akaisara.backendtest.infrastructure.externalApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.akaisara.backendtest.domain.model.Category;
import it.akaisara.backendtest.domain.model.Drink;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DrinkDto {

    @JsonProperty("idDrink")
    private String idDrink;
    @JsonProperty("strDrink")
    private String strDrink;
    @JsonProperty("strDrinkAlternate")
    private Object strDrinkAlternate;
    @JsonProperty("strTags")
    private String strTags;
    @JsonProperty("strVideo")
    private Object strVideo;
    @JsonProperty("strCategory")
    private String strCategory;
    @JsonProperty("strIBA")
    private Object strIBA;
    @JsonProperty("strAlcoholic")
    private String strAlcoholic;
    @JsonProperty("strGlass")
    private String strGlass;
    @JsonProperty("strInstructions")
    private String strInstructions;
    @JsonProperty("strInstructionsES")
    private Object strInstructionsES;
    @JsonProperty("strInstructionsDE")
    private Object strInstructionsDE;
    @JsonProperty("strInstructionsFR")
    private Object strInstructionsFR;
    @JsonProperty("strInstructionsIT")
    private Object strInstructionsIT;
    @JsonProperty("strInstructionsZH-HANS")
    private Object strInstructionsZHHANS;
    @JsonProperty("strInstructionsZH-HANT")
    private Object strInstructionsZHHANT;
    @JsonProperty("strDrinkThumb")
    private String strDrinkThumb;
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
    @JsonProperty("strMeasure1")
    private String strMeasure1;
    @JsonProperty("strMeasure2")
    private String strMeasure2;
    @JsonProperty("strMeasure3")
    private String strMeasure3;
    @JsonProperty("strMeasure4")
    private String strMeasure4;
    @JsonProperty("strMeasure5")
    private String strMeasure5;
    @JsonProperty("strMeasure6")
    private String strMeasure6;
    @JsonProperty("strMeasure7")
    private String strMeasure7;
    @JsonProperty("strMeasure8")
    private String strMeasure8;
    @JsonProperty("strMeasure9")
    private String strMeasure9;
    @JsonProperty("strMeasure10")
    private String strMeasure10;
    @JsonProperty("strMeasure11")
    private String strMeasure11;
    @JsonProperty("strMeasure12")
    private String strMeasure12;
    @JsonProperty("strMeasure13")
    private String strMeasure13;
    @JsonProperty("strMeasure14")
    private String strMeasure14;
    @JsonProperty("strMeasure15")
    private String strMeasure15;
    @JsonProperty("strImageSource")
    private String strImageSource;
    @JsonProperty("strImageAttribution")
    private Object strImageAttribution;
    @JsonProperty("strCreativeCommonsConfirmed")
    private String strCreativeCommonsConfirmed;
    @JsonProperty("dateModified")
    private Object dateModified;

    public Category convertToCategory() {
        return new Category(strCategory);
    }

    public Drink convertToDrink() {
        List<String> ingredients = Stream.of(strIngredient1, strIngredient2, strIngredient3, strIngredient4,
                strIngredient5, strIngredient6, strIngredient7, strIngredient8, strIngredient9, strIngredient10,
                strIngredient11, strIngredient12, strIngredient13, strIngredient14, strIngredient15)
                .filter(Objects::nonNull).collect(Collectors.toList());
        return new Drink(strDrink, strGlass, strInstructions, ingredients, strDrinkThumb);
    }

    @JsonProperty("idDrink")
    public String getIdDrink() {
        return idDrink;
    }

    @JsonProperty("idDrink")
    public void setIdDrink(String idDrink) {
        this.idDrink = idDrink;
    }

    @JsonProperty("strDrink")
    public String getStrDrink() {
        return strDrink;
    }

    @JsonProperty("strDrink")
    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

    @JsonProperty("strDrinkAlternate")
    public Object getStrDrinkAlternate() {
        return strDrinkAlternate;
    }

    @JsonProperty("strDrinkAlternate")
    public void setStrDrinkAlternate(Object strDrinkAlternate) {
        this.strDrinkAlternate = strDrinkAlternate;
    }

    @JsonProperty("strTags")
    public String getStrTags() {
        return strTags;
    }

    @JsonProperty("strTags")
    public void setStrTags(String strTags) {
        this.strTags = strTags;
    }

    @JsonProperty("strVideo")
    public Object getStrVideo() {
        return strVideo;
    }

    @JsonProperty("strVideo")
    public void setStrVideo(Object strVideo) {
        this.strVideo = strVideo;
    }

    @JsonProperty("strCategory")
    public String getStrCategory() {
        return strCategory;
    }

    @JsonProperty("strCategory")
    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    @JsonProperty("strIBA")
    public Object getStrIBA() {
        return strIBA;
    }

    @JsonProperty("strIBA")
    public void setStrIBA(Object strIBA) {
        this.strIBA = strIBA;
    }

    @JsonProperty("strAlcoholic")
    public String getStrAlcoholic() {
        return strAlcoholic;
    }

    @JsonProperty("strAlcoholic")
    public void setStrAlcoholic(String strAlcoholic) {
        this.strAlcoholic = strAlcoholic;
    }

    @JsonProperty("strGlass")
    public String getStrGlass() {
        return strGlass;
    }

    @JsonProperty("strGlass")
    public void setStrGlass(String strGlass) {
        this.strGlass = strGlass;
    }

    @JsonProperty("strInstructions")
    public String getStrInstructions() {
        return strInstructions;
    }

    @JsonProperty("strInstructions")
    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    @JsonProperty("strInstructionsES")
    public Object getStrInstructionsES() {
        return strInstructionsES;
    }

    @JsonProperty("strInstructionsES")
    public void setStrInstructionsES(Object strInstructionsES) {
        this.strInstructionsES = strInstructionsES;
    }

    @JsonProperty("strInstructionsDE")
    public Object getStrInstructionsDE() {
        return strInstructionsDE;
    }

    @JsonProperty("strInstructionsDE")
    public void setStrInstructionsDE(Object strInstructionsDE) {
        this.strInstructionsDE = strInstructionsDE;
    }

    @JsonProperty("strInstructionsFR")
    public Object getStrInstructionsFR() {
        return strInstructionsFR;
    }

    @JsonProperty("strInstructionsFR")
    public void setStrInstructionsFR(Object strInstructionsFR) {
        this.strInstructionsFR = strInstructionsFR;
    }

    @JsonProperty("strInstructionsIT")
    public Object getStrInstructionsIT() {
        return strInstructionsIT;
    }

    @JsonProperty("strInstructionsIT")
    public void setStrInstructionsIT(Object strInstructionsIT) {
        this.strInstructionsIT = strInstructionsIT;
    }

    @JsonProperty("strInstructionsZH-HANS")
    public Object getStrInstructionsZHHANS() {
        return strInstructionsZHHANS;
    }

    @JsonProperty("strInstructionsZH-HANS")
    public void setStrInstructionsZHHANS(Object strInstructionsZHHANS) {
        this.strInstructionsZHHANS = strInstructionsZHHANS;
    }

    @JsonProperty("strInstructionsZH-HANT")
    public Object getStrInstructionsZHHANT() {
        return strInstructionsZHHANT;
    }

    @JsonProperty("strInstructionsZH-HANT")
    public void setStrInstructionsZHHANT(Object strInstructionsZHHANT) {
        this.strInstructionsZHHANT = strInstructionsZHHANT;
    }

    @JsonProperty("strDrinkThumb")
    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    @JsonProperty("strDrinkThumb")
    public void setStrDrinkThumb(String strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
    }

    @JsonProperty("strIngredient1")
    public String getStrIngredient1() {
        return strIngredient1;
    }

    @JsonProperty("strIngredient1")
    public void setStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    @JsonProperty("strIngredient2")
    public String getStrIngredient2() {
        return strIngredient2;
    }

    @JsonProperty("strIngredient2")
    public void setStrIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
    }

    @JsonProperty("strIngredient3")
    public String getStrIngredient3() {
        return strIngredient3;
    }

    @JsonProperty("strIngredient3")
    public void setStrIngredient3(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }

    @JsonProperty("strIngredient4")
    public String getStrIngredient4() {
        return strIngredient4;
    }

    @JsonProperty("strIngredient4")
    public void setStrIngredient4(String strIngredient4) {
        this.strIngredient4 = strIngredient4;
    }

    @JsonProperty("strIngredient5")
    public String getStrIngredient5() {
        return strIngredient5;
    }

    @JsonProperty("strIngredient5")
    public void setStrIngredient5(String strIngredient5) {
        this.strIngredient5 = strIngredient5;
    }

    @JsonProperty("strIngredient6")
    public String getStrIngredient6() {
        return strIngredient6;
    }

    @JsonProperty("strIngredient6")
    public void setStrIngredient6(String strIngredient6) {
        this.strIngredient6 = strIngredient6;
    }

    @JsonProperty("strIngredient7")
    public String getStrIngredient7() {
        return strIngredient7;
    }

    @JsonProperty("strIngredient7")
    public void setStrIngredient7(String strIngredient7) {
        this.strIngredient7 = strIngredient7;
    }

    @JsonProperty("strIngredient8")
    public String getStrIngredient8() {
        return strIngredient8;
    }

    @JsonProperty("strIngredient8")
    public void setStrIngredient8(String strIngredient8) {
        this.strIngredient8 = strIngredient8;
    }

    @JsonProperty("strIngredient9")
    public String getStrIngredient9() {
        return strIngredient9;
    }

    @JsonProperty("strIngredient9")
    public void setStrIngredient9(String strIngredient9) {
        this.strIngredient9 = strIngredient9;
    }

    @JsonProperty("strIngredient10")
    public String getStrIngredient10() {
        return strIngredient10;
    }

    @JsonProperty("strIngredient10")
    public void setStrIngredient10(String strIngredient10) {
        this.strIngredient10 = strIngredient10;
    }

    @JsonProperty("strIngredient11")
    public String getStrIngredient11() {
        return strIngredient11;
    }

    @JsonProperty("strIngredient11")
    public void setStrIngredient11(String strIngredient11) {
        this.strIngredient11 = strIngredient11;
    }

    @JsonProperty("strIngredient12")
    public String getStrIngredient12() {
        return strIngredient12;
    }

    @JsonProperty("strIngredient12")
    public void setStrIngredient12(String strIngredient12) {
        this.strIngredient12 = strIngredient12;
    }

    @JsonProperty("strIngredient13")
    public String getStrIngredient13() {
        return strIngredient13;
    }

    @JsonProperty("strIngredient13")
    public void setStrIngredient13(String strIngredient13) {
        this.strIngredient13 = strIngredient13;
    }

    @JsonProperty("strIngredient14")
    public String getStrIngredient14() {
        return strIngredient14;
    }

    @JsonProperty("strIngredient14")
    public void setStrIngredient14(String strIngredient14) {
        this.strIngredient14 = strIngredient14;
    }

    @JsonProperty("strIngredient15")
    public String getStrIngredient15() {
        return strIngredient15;
    }

    @JsonProperty("strIngredient15")
    public void setStrIngredient15(String strIngredient15) {
        this.strIngredient15 = strIngredient15;
    }

    @JsonProperty("strMeasure1")
    public String getStrMeasure1() {
        return strMeasure1;
    }

    @JsonProperty("strMeasure1")
    public void setStrMeasure1(String strMeasure1) {
        this.strMeasure1 = strMeasure1;
    }

    @JsonProperty("strMeasure2")
    public String getStrMeasure2() {
        return strMeasure2;
    }

    @JsonProperty("strMeasure2")
    public void setStrMeasure2(String strMeasure2) {
        this.strMeasure2 = strMeasure2;
    }

    @JsonProperty("strMeasure3")
    public String getStrMeasure3() {
        return strMeasure3;
    }

    @JsonProperty("strMeasure3")
    public void setStrMeasure3(String strMeasure3) {
        this.strMeasure3 = strMeasure3;
    }

    @JsonProperty("strMeasure4")
    public String getStrMeasure4() {
        return strMeasure4;
    }

    @JsonProperty("strMeasure4")
    public void setStrMeasure4(String strMeasure4) {
        this.strMeasure4 = strMeasure4;
    }

    @JsonProperty("strMeasure5")
    public String getStrMeasure5() {
        return strMeasure5;
    }

    @JsonProperty("strMeasure5")
    public void setStrMeasure5(String strMeasure5) {
        this.strMeasure5 = strMeasure5;
    }

    @JsonProperty("strMeasure6")
    public String getStrMeasure6() {
        return strMeasure6;
    }

    @JsonProperty("strMeasure6")
    public void setStrMeasure6(String strMeasure6) {
        this.strMeasure6 = strMeasure6;
    }

    @JsonProperty("strMeasure7")
    public String getStrMeasure7() {
        return strMeasure7;
    }

    @JsonProperty("strMeasure7")
    public void setStrMeasure7(String strMeasure7) {
        this.strMeasure7 = strMeasure7;
    }

    @JsonProperty("strMeasure8")
    public String getStrMeasure8() {
        return strMeasure8;
    }

    @JsonProperty("strMeasure8")
    public void setStrMeasure8(String strMeasure8) {
        this.strMeasure8 = strMeasure8;
    }

    @JsonProperty("strMeasure9")
    public String getStrMeasure9() {
        return strMeasure9;
    }

    @JsonProperty("strMeasure9")
    public void setStrMeasure9(String strMeasure9) {
        this.strMeasure9 = strMeasure9;
    }

    @JsonProperty("strMeasure10")
    public String getStrMeasure10() {
        return strMeasure10;
    }

    @JsonProperty("strMeasure10")
    public void setStrMeasure10(String strMeasure10) {
        this.strMeasure10 = strMeasure10;
    }

    @JsonProperty("strMeasure11")
    public String getStrMeasure11() {
        return strMeasure11;
    }

    @JsonProperty("strMeasure11")
    public void setStrMeasure11(String strMeasure11) {
        this.strMeasure11 = strMeasure11;
    }

    @JsonProperty("strMeasure12")
    public String getStrMeasure12() {
        return strMeasure12;
    }

    @JsonProperty("strMeasure12")
    public void setStrMeasure12(String strMeasure12) {
        this.strMeasure12 = strMeasure12;
    }

    @JsonProperty("strMeasure13")
    public String getStrMeasure13() {
        return strMeasure13;
    }

    @JsonProperty("strMeasure13")
    public void setStrMeasure13(String strMeasure13) {
        this.strMeasure13 = strMeasure13;
    }

    @JsonProperty("strMeasure14")
    public String getStrMeasure14() {
        return strMeasure14;
    }

    @JsonProperty("strMeasure14")
    public void setStrMeasure14(String strMeasure14) {
        this.strMeasure14 = strMeasure14;
    }

    @JsonProperty("strMeasure15")
    public String getStrMeasure15() {
        return strMeasure15;
    }

    @JsonProperty("strMeasure15")
    public void setStrMeasure15(String strMeasure15) {
        this.strMeasure15 = strMeasure15;
    }

    @JsonProperty("strImageSource")
    public String getStrImageSource() {
        return strImageSource;
    }

    @JsonProperty("strImageSource")
    public void setStrImageSource(String strImageSource) {
        this.strImageSource = strImageSource;
    }

    @JsonProperty("strImageAttribution")
    public Object getStrImageAttribution() {
        return strImageAttribution;
    }

    @JsonProperty("strImageAttribution")
    public void setStrImageAttribution(Object strImageAttribution) {
        this.strImageAttribution = strImageAttribution;
    }

    @JsonProperty("strCreativeCommonsConfirmed")
    public String getStrCreativeCommonsConfirmed() {
        return strCreativeCommonsConfirmed;
    }

    @JsonProperty("strCreativeCommonsConfirmed")
    public void setStrCreativeCommonsConfirmed(String strCreativeCommonsConfirmed) {
        this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
    }

    @JsonProperty("dateModified")
    public Object getDateModified() {
        return dateModified;
    }

    @JsonProperty("dateModified")
    public void setDateModified(Object dateModified) {
        this.dateModified = dateModified;
    }
}
