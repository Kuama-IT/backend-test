import { z } from 'zod';

// Define schemas
export const schemaDrinkTypeDto = z.object({
    strDrink: z.string().nonempty(),
    strDrinkThumb: z.string().nonempty(),
    idDrink: z.string().nonempty(),
});

export const schemaDrinkTypesDto = z.object({
    drinks: z.array(schemaDrinkTypeDto),
});

//Define Typescript type
export type DrinkTypesDto = z.infer<typeof schemaDrinkTypesDto>;
