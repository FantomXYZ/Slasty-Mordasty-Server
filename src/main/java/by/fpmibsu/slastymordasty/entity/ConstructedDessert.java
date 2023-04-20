package by.fpmibsu.slastymordasty.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class ConstructedDessert extends Entity implements Item{
    private List<Component> recipe = new ArrayList<>();
}
