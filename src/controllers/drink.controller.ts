import { schemaDrinkCategoriesDto, type DrinkCategoriesDto } from '@dtos/drinkCategories.dto';
import { DrinkResponse } from '@interfaces/drinkResponse.interface';
import { NextFunction, Request, Response } from 'express';
import { HttpException } from '@exceptions/HttpException';
import dotenv from 'dotenv';
import httpClient from '@http/client.http';
import DrinkService from '@services/drink.service';
dotenv.config();

class DrinkController {
    private drinkService = new DrinkService();

    /**
     *
     * @method: GET /api/drinks/categories
     * @param {req, res, next}
     * @returns {Object} list of ingredients
     * @description: Get drink categories with pagination
     * @access: Public
     *
     */

    public getDrinkCategories = async (req: Request, res: Response, next: NextFunction) => {
        try {
            const { skip, take } = res.locals.pagination || {};

            // Make an HTTP call to get the drink categories
            const httpResponse = await httpClient.get<DrinkCategoriesDto>(process.env.COCKTAIL_BASE_URL + '/list.php?c=list');

            // Validate the data received from the HTTP call
            const drinkValidate = schemaDrinkCategoriesDto.parse(httpResponse.data);

            // Build the beverage categories object
            const drinkCategories = {
                count: drinkValidate.drinks.length,
                rows: drinkValidate.drinks.map(drink => drink.strCategory),
            };

            // If skip and take values are set, then modify the beverage category array according to them
            if (skip != undefined && take != undefined) {
                drinkCategories.rows = drinkCategories.rows.slice(skip, skip + take);
            }

            return res.status(200).json(drinkCategories);
        } catch (error) {
            next(error);
        }
    };

    /**
     *
     * @method: GET /api/drinks/search
     * @param {req, res, next}
     * @returns {Object} list of cocktails
     * @description: Get drinks by type, by keyword or both of them
     * @access: Public
     *
     */

    public getSearch = async (req: Request, res: Response, next: NextFunction) => {
        try {
            const { skip, take } = res.locals.pagination || {};
            let drinks: DrinkResponse = {
                count: 0,
                rows: [],
            };

            if (req.query.type_search && req.query.keyword_search) {
                // Search by keyword and type of drink with two auxiliary functions
                const drinksByKeyword = await this.drinkService.getDrinksByKeyword(req.query.keyword_search);
                const drinksByType = await this.drinkService.getDrinksByType(req.query.type_search);

                // Find common drinks in keyword and type search results
                const commonDrinks = drinksByKeyword.rows.filter(drink1 => drinksByType.rows.some(drink2 => drink1.name === drink2.name));

                const drinks: DrinkResponse = {
                    count: commonDrinks.length,
                    rows: commonDrinks,
                };

                // If skip and take values are set, then modify the beverage category array according to them
                if (skip != undefined && take != undefined) {
                    drinks.rows = drinks.rows.slice(skip, skip + take);
                }

                return res.status(200).json(drinks);
            } else if (req.query.keyword_search) {
                // Search by keyword with auxiliary function
                drinks = await this.drinkService.getDrinksByKeyword(req.query.keyword_search);

                // If skip and take values are set, then modify the beverage category array according to them
                if (skip != undefined && take != undefined) {
                    drinks.rows = drinks.rows.slice(skip, skip + take);
                }

                return res.status(200).json(drinks);
            } else if (req.query.type_search) {
                // Search by type with auxiliary function
                drinks = await this.drinkService.getDrinksByType(req.query.type_search);

                // If skip and take values are set, then modify the beverage category array according to them
                if (skip != undefined && take != undefined) {
                    drinks.rows = drinks.rows.slice(skip, skip + take);
                }

                return res.status(200).json(drinks);
            } else {
                // If neither keyword nor type is present in the request query, throw an exception
                throw new HttpException(400, 'keyword_search and type_search not valid');
            }
        } catch (error) {
            next(error);
        }
    };
}

export default DrinkController;
