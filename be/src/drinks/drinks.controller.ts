import { Controller, Get, Param } from '@nestjs/common';
import { DrinksService } from './drinks.service';
import { DtoDrinksFilter } from '../dtos/drinks';

@Controller('/api/drinks-remote')
export class DrinksController {
  constructor(private readonly drinksService: DrinksService) {}

  @Get('/categories')
  getCats() {
    return this.drinksService.getCats();
  }

  @Get('/drinks/:filterType/:filter')
  getDrink(
    @Param('filterType') filterType: string,
    @Param('filter') filter: string,
  ) {
    const params: DtoDrinksFilter = {
      filter,
      filterType,
    };
    return this.drinksService.getDrink(params);
  }
}
