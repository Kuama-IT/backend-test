import { HttpException, HttpStatus, Injectable } from '@nestjs/common';
import { HttpService } from '@nestjs/axios';
import { AxiosResponse } from 'axios';
import { DtoDrinksFilter } from '../dtos/drinks';

@Injectable()
export class DrinksService {
  constructor(private readonly httpService: HttpService) {}

  async getCats(): Promise<AxiosResponse<any>> {
    const cats = await this.httpService.axiosRef.get(
      'https://www.thecocktaildb.com/api/json/v1/1/list.php?c=list',
    );

    const parsedCats = cats.data.drinks.map((cat) => {
      return {
        name: cat.strCategory,
      };
    });
    return parsedCats;
  }

  async getDrink(params: DtoDrinksFilter) {
    try {
      if (params.filterType === 'c') {
        const cocktail = await this.httpService.axiosRef.get(
          `https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=${params.filter}`,
        );

        const parsedDrinks = cocktail.data.drinks.map((drink) => {
          return {
            id: drink.idDrink,
            name: drink.strDrink,
            thumb: drink.strDrinkThumb,
          };
        });

        return parsedDrinks;
      }
      if (params.filterType === 'n') {
        const cocktail = await this.httpService.axiosRef.get(
          `https://www.thecocktaildb.com/api/json/v1/1/search.php?s=${params.filter}`,
        );

        console.log(cocktail);

        const parsedCocktail = cocktail.data.drinks.map((drink) => {
          const ingredients = Object.keys(drink)
            .filter((key) => key.includes('strIngredient') && drink[key])
            .map((key) => drink[key]);

          return {
            id: drink.idDrink,
            name: drink.strDrink,
            glass: drink.strGlass,
            instructions: drink.strInstructions,
            ingredients,
            thumb: drink.strDrinkThumb,
          };
        });

        return parsedCocktail;
      }

      throw new HttpException('Invalid filter type', HttpStatus.BAD_REQUEST);
    } catch (err) {
      throw new HttpException(err, HttpStatus.BAD_REQUEST);
    }
  }
}
