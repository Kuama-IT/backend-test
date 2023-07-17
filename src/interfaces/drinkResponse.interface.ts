export interface DrinkResponse {
    count: number;
    rows: Drink[];
}

interface Drink {
    name: string;
    glass: string;
    instructions: string;
    ingredients: string;
    thumbnail: string;
}
