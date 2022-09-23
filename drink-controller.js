import { HttpsHandler} from './https-handler.js';

const drinkFullEndpoint='lookup.php?i='; // + id drink
const categoriesEndpoint='list.php?c=list';
const filterCategoryEndpoint='filter.php?c='; // +category
const filterKeywordEndpoint='search.php?s='; // +keyword

export class DrinkController {
    
    constructor() {
        this.https = new HttpsHandler();
    }

    //convert api full drink info to requested ones
    extractInfoFromFullDrink(fullDrink){
        let drink={};
        drink.name=fullDrink.strDrink;
        drink.glass=fullDrink.strGlass;
        drink.instructions=fullDrink.strInstructions;
        drink.ingredients=[];
        for (let i = 1; i <= 15; i++) { //api returns array of 15 ingredients
            if (fullDrink['strIngredient'+i]!=null) drink.ingredients=fullDrink['strIngredient'+i];
        } 
        drink.thumbnail=fullDrink.strDrinkThumb;
        return drink;
    }

    getDrinkInfo(id){
        return new Promise((resolve, reject) => {
            this.https.getRequest(drinkFullEndpoint+id)
                .then((data)=>{                                        
                    resolve(data.drinks[0]);
                })
                .catch((error)=>{
                    reject(error);
                })
        });
    }

    getAllCategories(){
        return new Promise((resolve, reject) => {
            this.https.getRequest(categoriesEndpoint)
                .then((data)=>{
                    const categories=[];
                    if (Array.isArray(data.drinks)){
                        data.drinks.forEach(element => {
                            categories.push(element.strCategory);
                        });
                    }           
                    resolve(categories);
                })
                .catch((error)=>{
                    reject(error);
                })
        });
    }

    getDrinksByType(type){
        return new Promise((resolve, reject) => {
            this.https.getRequest(filterCategoryEndpoint+type)
                .then((data)=>{
                    const idDrinks=[];
                    if (Array.isArray(data.drinks)){
                        data.drinks.forEach(element => {
                            idDrinks.push(element.idDrink);
                        });
                    }
                    Promise.allSettled(idDrinks.map((drink) => {
                        return this.getDrinkInfo(drink);
                    })).then((results)=>{ 
                        resolve(results.map((result)=>this.extractInfoFromFullDrink(result.value)));
                    });
                })
                .catch((error)=>{
                    reject(error);
                })
        });
    }

    getDrinksByKeyword(keyword){
        return new Promise((resolve, reject) => {
            this.https.getRequest(filterKeywordEndpoint+keyword)
                .then((data)=>{
                    resolve(data.drinks.map((drink)=>this.extractInfoFromFullDrink(drink)));
                })
                .catch((error)=>{
                    reject(error);
                })
        });
    }
}