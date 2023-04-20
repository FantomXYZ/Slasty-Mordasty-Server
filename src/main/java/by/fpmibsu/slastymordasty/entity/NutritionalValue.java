package by.fpmibsu.slastymordasty.entity;

public class NutritionalValue extends Entity {
    private double proteins;
    private double fats;
    private double carbohydrates;
    private double caloriesKJoules;
    private double caloriesKcal;

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getCaloriesKJoules() {
        return caloriesKJoules;
    }

    public void setCaloriesKJoules(double caloriesKJoules) {
        this.caloriesKJoules = caloriesKJoules;
    }

    public double getCaloriesKcal() {
        return caloriesKcal;
    }

    public void setCaloriesKcal(double caloriesKcal) {
        this.caloriesKcal = caloriesKcal;
    }
}
