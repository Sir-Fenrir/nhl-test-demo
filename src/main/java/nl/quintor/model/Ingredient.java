package nl.quintor.model;

import nl.quintor.exception.CookingException;

public class Ingredient {

    private final String name;

    private double amount;

    private final String metric;

    public Ingredient(String name, double amount, String metric) {
        this.name = name;
        this.amount = amount;
        this.metric = metric;
    }

    public String getName() {
        return name;
    }

    public String getMetric() {
        return metric;
    }

    public double use(double subtraction) {
        if(subtraction > this.amount) {
            throw new CookingException("We don't have " + subtraction + " " + this.metric + " of " + this.name + ", we only have " + this.amount + " " + this.metric + ".");
        }
        this.amount -= subtraction;
        return this.amount;
    }

    public double add(double addition) {
        this.amount += addition;
        return this.amount;
    }

    public double getAmount() {
        return amount;
    }
}
