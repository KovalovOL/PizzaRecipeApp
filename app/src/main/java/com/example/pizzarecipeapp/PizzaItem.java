package com.example.pizzarecipeapp;

public class PizzaItem {
    private String pizzaName;
    private String pizzaDescribe;
    private String recipe;
    private int image;

    public PizzaItem(int image, String pizzaName, String pizzaDescribe, String recipe) {
        this.pizzaName = pizzaName;
        this.pizzaDescribe = pizzaDescribe;
        this.recipe = recipe;
        this.image = image;
    }

    public String getPizzaName() {
        return this.pizzaName;
    }

    public String getPizzaDescribe() {
        return this.pizzaDescribe;
    }

    public String getRecipe() {
        return this.recipe;
    }

    public int getImage() {
        return this.image;
    }

}
