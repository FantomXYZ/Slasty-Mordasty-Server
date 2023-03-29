package java.by.fpmibsu.slastymordasty.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order extends Entity{
    User user;
    List<Item> basket = new ArrayList<>();
    Date orderDate;
    Date deliveryDate;
}
