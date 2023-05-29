package by.fpmibsu.slastymordasty.controller.actions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrateAction extends AbstractAction{

    RegistrateAction(HttpServletRequest req, HttpServletResponse res) {
        super(req, res);
    }

    @Override
    public void doAction() throws IOException, SQLException, ServletException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String street = req.getParameter("street");
        String phone = req.getParameter("phone");
        String houseFlat = req.getParameter("houseFlat");
    }
}
