import express from 'express';
import cors from 'cors';
import { DrinkController } from './drink-controller.js';

const app = express();
const port = 3000;
const drinkController = new DrinkController();

app.use(cors());

//list categories of drinks
app.get('/drinks/categories', (req, res) => {
    drinkController.getAllCategories()        
        .then((categories)=>{
            res.send(categories);
        })
        .catch((error)=>{
            res.status(500).send(error);
        })
});

//accepts only type and name query, if no one specified, send invalid requqest
app.get('/drinks', (req, res) => {
    const filters = req.query;
    if (filters.type)
        drinkController.getDrinksByType(filters.type)
            .then((drinks)=>{
                res.send(drinks);
            })
            .catch((error)=>{
                res.status(500).send(error);
            })
    else if (filters.name)
        drinkController.getDrinksByKeyword(filters.name)
            .then((drinks)=>{
                res.send(drinks);
            })
            .catch((error)=>{
                res.status(500).send(error);
            })
        else
            res.status(400).send("Invalid request");
});

//optional, send the info of a single drink by id
app.get('/drink/:id', (req, res) => {
    drinkController.getDrinkInfo(req.params.id)
        .then((drink)=>{
            res.send(drink);
        })
        .catch((error)=>{
            res.status(500).send(error);
        })
});

app.listen(port, () => console.log(`Server listening on port ${port}!`));

export default app;