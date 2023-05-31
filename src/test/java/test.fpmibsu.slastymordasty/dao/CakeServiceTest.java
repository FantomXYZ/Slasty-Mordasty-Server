package test.fpmibsu.slastymordasty.dao;

import by.fpmibsu.slastymordasty.dao.CakeDao;
import by.fpmibsu.slastymordasty.entity.Cake;
import by.fpmibsu.slastymordasty.entity.Image;
import by.fpmibsu.slastymordasty.entity.NutritionalValue;
import by.fpmibsu.slastymordasty.service.CakeService;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;


public class CakeServiceTest {

    private CakeService cakeDao = new CakeService();

    public CakeServiceTest() throws SQLException, InterruptedException {
    }

    @Test()
    void getByIdTest() throws InterruptedException {
        long id = 8;
        Cake expectObject = new Cake(8,new NutritionalValue(8,7,
                28, 28, 1663, 397),
                new Image(8,"8.jpg"),
                "Торт «Сникерс»", "масло сливочное, молоко пастеризованное, арахис жареный, сахар, молоко сгущенное вареное (нормализованное молоко, сахар), сметана, мука пшеничная, яйца куриные, кукурузный крахмал, какао-порошок, разрыхлитель: карбонат натрия, ароматизатор: ванилин.", 65);

        Cake test = cakeDao.getById(id);

        assertEquals(test,expectObject);
    }
}