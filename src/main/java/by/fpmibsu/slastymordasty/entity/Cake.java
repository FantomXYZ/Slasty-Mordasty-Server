package by.fpmibsu.slastymordasty.entity;

public class Cake extends Entity implements Item{

    private NutritionalValue nutritionalValue100g;

    private Image image;
    private NutritionalValue nutritionalValue;
    private String title;
    private String description;
    private double price;

    public NutritionalValue getNutritionalValue100g() {
        return nutritionalValue100g;
    }

    public void setNutritionalValue100g(NutritionalValue nutritionalValue100g) {
        this.nutritionalValue100g = nutritionalValue100g;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public NutritionalValue getNutritionalValue() {
        return nutritionalValue;
    }

    public void setNutritionalValue(NutritionalValue nutritionalValue) {
        this.nutritionalValue = nutritionalValue;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
