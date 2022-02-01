CREATE TABLE IF NOT EXISTS RecipeBook(
id LONG AUTO_INCREMENT NOT NULL,
PRIMARY KEY(id),
recipeName VARCHAR(50) NOT NULL,
recipeDetails VARCHAR(255) NOT NULL,
author VARCHAR(40) NOT NULL,
    CHECK(recipeName <> ''),
    CHECK(recipeDetails <> ''),
    CHECK(author <> '')
);