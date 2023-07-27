-- Table drink_types
DROP TABLE IF EXISTS drinkTypes;
CREATE TABLE drinkTypes (
    drink_type INTEGER NOT NULL,
    type_label VARCHAR(50) NOT NULL,
    PRIMARY KEY (drink_type)
);

-- Table drinks
DROP TABLE IF EXISTS drinks;
CREATE TABLE drinks (
    drink_id SERIAL,
    drink_type INTEGER NOT NULL,
    drink_name VARCHAR(50) NOT NULL,
    glass_type VARCHAR(50) NOT NULL,
    drink_instructions JSON,
    drink_ingredients JSON,
    PRIMARY KEY (drink_id),
    CONSTRAINT fk_drink_type
        FOREIGN KEY (drink_type)
        REFERENCES drinkTypes(drink_type)
);