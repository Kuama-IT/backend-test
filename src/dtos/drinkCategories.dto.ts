import { z } from 'zod';

// Define schemas
export const schemaDrinkCategoryDto = z.object({
    strCategory: z.string().nonempty(),
});

export const schemaDrinkCategoriesDto = z.object({
    drinks: z.array(schemaDrinkCategoryDto),
});

//Define Typescript type
export type DrinkCategoriesDto = z.infer<typeof schemaDrinkCategoriesDto>;
