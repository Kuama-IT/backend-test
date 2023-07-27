import { HttpException, HttpStatus, Injectable } from '@nestjs/common';
import { Knex } from 'knex';
import { InjectModel } from 'nest-knexjs';
import { DtoDrinksFilter } from '../dtos/drinks';

@Injectable()
export class DrinksDockerService {
  constructor(@InjectModel() private readonly knex: Knex) {}

  async getCats() {
    const cats = await this.knex.table('drinktypes').select('*');

    return cats;
  }

  async getDrink(params: DtoDrinksFilter) {
    try {
      if (params.filterType === 'c') {
        const drinks = await this.knex
          .select('drinks.*', 'drinktypes.type_label')
          .from('drinks')
          .innerJoin('drinktypes', 'drinks.drink_type', 'drinktypes.drink_type')
          .where('drinktypes.type_label', params.filter);

        return drinks;
      }
      if (params.filterType === 'n') {
        const drinks = await this.knex
          .select('*')
          .from('drinks')
          .whereLike('drink_name', `%${params.filter}%`);

        const parsedDrinks = drinks.map((drink) => {
          return {
            name: drink.drink_name,
            type: drink.drink_type_id,
            glass: drink.glass_type,
            instructions: drink.drink_instructions,
            ingredients: drink.drink_ingredients,
          };
        });

        return parsedDrinks;
      }

      throw new HttpException('Invalid filter type', HttpStatus.BAD_REQUEST);
    } catch (err) {
      throw new HttpException(err, HttpStatus.BAD_REQUEST);
    }
  }
}
