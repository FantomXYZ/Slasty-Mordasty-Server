package by.fpmibsu.slastymordasty.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order extends Entity{
    long userId;
    List<Item> basket = new ArrayList<Item>();
    double cost;
    String comment;
    Date orderDate;
    Date deliveryDate;

    public Order(long userId, Item item, double cost, String comment, Date orderDate, Date deliveryDate) {
        this.userId = userId;
        this.basket = basket;
        this.cost = cost;
        this.comment = comment;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Item> getBasket() {
        return basket;
    }

    public void setItem(Item item) {
        this.basket = basket;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
