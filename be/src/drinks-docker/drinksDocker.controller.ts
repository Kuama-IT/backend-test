import { Controller, Get, Param } from '@nestjs/common';
import { DrinksDockerService } from './drinksDocker.service';
import { DtoDrinksFilter } from '../dtos/drinks';

@Controller('/api/drinks-docker')
export class DrinksDockerController {
  constructor(private readonly drinksService: DrinksDockerService) {}

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
