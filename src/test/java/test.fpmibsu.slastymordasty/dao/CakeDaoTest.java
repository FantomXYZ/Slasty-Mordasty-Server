package test.fpmibsu.slastymordasty.dao;

import by.fpmibsu.slastymordasty.dao.CakeDao;
import by.fpmibsu.slastymordasty.entity.Cake;
import by.fpmibsu.slastymordasty.entity.Image;
import by.fpmibsu.slastymordasty.entity.NutritionalValue;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;


public class CakeDaoTest {

    private CakeDao cakeDao = new CakeDao();

    public CakeDaoTest() throws SQLException, InterruptedException {
    }

    @Test()
    void getByIdTest() throws InterruptedException {
        long id = 1;
        Cake expectObject = new Cake(1,new NutritionalValue(6,
                19, 21, 1118, 267),
                new Image("https://www.google.com/url?sa=i&url=https%3A%2F%2Flifehacker.ru%2Frecipe%2Fklassicheskij-chizkejk%2F&psig=AOvVaw1OJxZTkZXoY3QAOlMl6j49&ust=1676226780545000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCIiuocCNjv0CFQAAAAAdAAAAABAQ"),
                "Чизкейк «НЬЮ-ЙОРК»", "сыр сливочный (сливки пастеризованные, молоко пастеризованное, регулятор кислотности - лимонная кислота, лактоза, антиокислитель -натуральный экстракт розмарина), печенье сахарное (мука пшеничная, сахар, маргарин (масла растительные рафинированные дезодорированные, вода, соль пищевая поваренная йодированная (йодат калия, агент антислеживающий: ферроцианид калия), эмульгаторы (лецитин соевый, моно- и диглицериды жирных кислот, антиокислитель: кислота лимонная), сыворотка молочная сухая, консервант: сорбат калия, краситель: бета-каротин, ароматизатор, антиокислитель: концентрат смеси токоферолов)), сыворотка молочная сухая, ароматизатор); яйца куриные, сливки, сахар, масло сливочное.\n" +
                " Может содержать следы арахиса, кунжута, корицы и мёда.", 55);

        assertEquals(cakeDao.getById(id),expectObject);
    }
}