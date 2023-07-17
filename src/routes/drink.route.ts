import { Router } from 'express';
import { Routes } from '@interfaces/routes.interface';
import DrinkController from '@controllers/drink.controller';

class DrinkRoute implements Routes {
    public auth = false;
    public path = '/drinks';
    public router = Router();
    public drinkController = new DrinkController();

    constructor() {
        this.initializeRoutes();
    }

    private initializeRoutes() {
        this.router.get(`${this.path}/categories`, this.drinkController.getDrinkCategories);
        this.router.get(`${this.path}/search`, this.drinkController.getSearch);
    }
}

export default DrinkRoute;
