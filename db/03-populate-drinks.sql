-- Load data into the drinks table
INSERT INTO drinks (drink_type, drink_name, glass_type, drink_instructions, drink_ingredients)
VALUES (1, 'margarita', 'Cocktail glass', '{ "procedure": "Shake all ingredients with ice, strain into a chilled cocktail glass, and serve."}', '{"Tequila": "2 oz", "Lime juice": "1 oz", "Triple sec": "1 oz", "Salt": "1 pinch"}'),
       (1, 'martini', 'Cocktail glass', '{ "procedure": "Stir ingredients with ice, strain into a chilled cocktail glass, and serve."}', '{"Gin": "2 oz", "Dry vermouth": "1 oz", "Olive": "1"}'),
       (1, 'manhattan', 'Cocktail glass', '{ "procedure": "Stir with ice and strain into a chilled cocktail glass."}', '{"Rye whiskey": "2 oz", "Sweet vermouth": "1 oz", "Angostura bitters": "2 dashes", "Cherry": "1"}'),
       (4, 'ipa', 'Pint glass', '{ "procedure": "Pour into a chilled pint glass and serve."}', '{}'),
       (4, 'stout', 'Pint glass', '{ "procedure": "Pour into a chilled pint glass and serve."}', '{}'),
       (4, 'pilsner', 'Pilsner glass', '{ "procedure": "Pour into a chilled pilsner glass and serve."}', '{}'),
       (5, 'chardonnay', 'White wine glass', '{ "procedure": "Pour into a chilled white wine glass and serve."}', '{}'),
       (5, 'merlot', 'Red wine glass', '{ "procedure": "Pour into a chilled red wine glass and serve."}', '{}'),
       (5, 'pinot', 'Red wine glass', '{ "procedure": "Pour into a chilled red wine glass and serve."}', '{}');