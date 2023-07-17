import { type DrinkDetailsDto } from '@dtos/drinkDetails.dto';
import { DrinkResponse } from '@interfaces/drinkResponse.interface';
import { DrinkTypesDto } from '@dtos/drinkTypes.dto';
import { schemaDrinkDetailsDto } from '@dtos/drinkDetails.dto';
import { schemaDrinkTypesDto } from '@dtos/drinkTypes.dto';
import dotenv from 'dotenv';
import httpClient from '@http/client.http';
dotenv.config();


class DrinkService {
    /**
     *
     * @description Search for drinks using a keyword you provide and return the results
     * @param {keyword: string} - The keyword to use to search for drinks
     * @returns A promise that resolves to a 'Drink Response' object containing the search results
     *
     */
    public async getDrinksByKeyword(keyword: string): Promise<DrinkResponse> {
        const drinks: DrinkResponse = {
            count: 0,
            rows: [],
        };

        // Make an HTTP request to get the details of the drinks matching the given keyword
        const httpResponse = await httpClient.get<DrinkTypesDto>(process.env.COCKTAIL_BASE_URL + '/search.php?s=' + keyword);

        // Validate the data received from the HTTP call
        const drinksValidate = schemaDrinkDetailsDto.parse(httpResponse.data);

        // Process each drink found in the answer by creating a new object
        let index = 0;
        await Promise.all(
            drinksValidate.drinks.map(async drink => {
                const newDrinkFormat = {
                    name: drinksValidate.drinks[index].strDrink,
                    glass: drinksValidate.drinks[index].strGlass,
                    instructions: drinksValidate.drinks[index].strInstructions,
                    ingredients: await this.getDrinkIngredient(drinksValidate), // Gets the drink ingredients via another function
                    thumbnail: drinksValidate.drinks[index].strDrinkThumb,
                };

                drinks.rows.push(newDrinkFormat);
                drinks.count += 1;
                index++;
            }),
        );

        return drinks;
    }

    /**
     *
     * @description Search for drinks using a type you provide and return the results
     * @param {type: string} - The type of drinks to search for
     * @returns A Promise that resolves to a 'DrinkResponse' object containing the search results
     *
     */

    public async getDrinksByType(type: string): Promise<DrinkResponse> {
        const drinks: DrinkResponse = {
            count: 0,
            rows: [],
        };

        // Make an HTTP request to get drinks filtered by the specified type
        const httpResponse = await httpClient.get<DrinkTypesDto>(process.env.COCKTAIL_BASE_URL + '/filter.php?c=' + type);

        // Validate the data received from the HTTP call
        const drinksValidate = schemaDrinkTypesDto.parse(httpResponse.data);

        //Process each drink found in the answer by creating a new object
        await Promise.all(
            drinksValidate.drinks.map(async drink => {
                // Fetch detailed information for each drink using its 'idDrink'
                const drinkTmp = await httpClient.get<DrinkTypesDto>(process.env.COCKTAIL_BASE_URL + '/lookup.php?i=' + drink.idDrink);

                // Validate the data received from the HTTP call
                const drinkDetailsValidate = schemaDrinkDetailsDto.parse(drinkTmp.data);

                const newDrinkFormat = {
                    name: drinkDetailsValidate.drinks[0].strDrink,
                    glass: drinkDetailsValidate.drinks[0].strGlass,
                    instructions: drinkDetailsValidate.drinks[0].strInstructions,
                    ingredients: await this.getDrinkIngredient(drinkDetailsValidate), // Gets the drink ingredients via another function
                    thumbnail: drinkDetailsValidate.drinks[0].strDrinkThumb,
                };

                drinks.rows.push(newDrinkFormat);
                drinks.count += 1;
            }),
        );

        return drinks;
    }

    /**
     *
     * @description: Extracts drink ingredients from the provided 'DrinkDetailsDto' object and returns them as a comma-separated string
     * @param {obj: DrinkDetailsDto} - The 'DrinkDetailsDto' object containing detailed information about a drink
     * @returns A Promise that resolves to a string representing the drink ingredients separated by commas
     *
     */

    public async getDrinkIngredient(obj: DrinkDetailsDto): Promise<string> {
        const ingredients = [];

        // Check if the 'drinks' property is an array in the provided 'DrinkDetailsDto' object
        if (Array.isArray(obj.drinks)) {
            // Extract the keys of properties that contain the word 'Ingredient' in their name
            const ingredientKeys = Object.keys(obj.drinks[0]).filter(key => key.includes('Ingredient'));

            // Loop through the ingredient keys and add non-null values to the 'ingredients' array
            for (const key of ingredientKeys) {
                if (obj.drinks[0][key] !== null) {
                    ingredients.push(obj.drinks[0][key]);
                }
            }
        }

        // Return the ingredients as a comma-separated string
        return ingredients.join(', ');
    }
}

export default DrinkService;
