package by.fpmibsu.slastymordasty.controller.actions;

import by.fpmibsu.slastymordasty.entity.Cake;
import by.fpmibsu.slastymordasty.service.CakeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class InfoAction extends AbstractAction{

    private long cakeId;

    public InfoAction(HttpServletRequest req, HttpServletResponse res,long id) {
        super(req, res);
        this.cakeId = id;
    }

    @Override
    public void doAction() throws IOException, SQLException, ServletException {
        CakeService cakeService = new CakeService();
        Cake cake = cakeService.getById(cakeId);
        req.setAttribute("cake",cake);
        req.getRequestDispatcher("/view/information.jsp").forward(req, res);
    }
}
