package by.fpmibsu.slastymordasty.controller.actions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LogoutAction extends AbstractAction{
    public LogoutAction(HttpServletRequest req, HttpServletResponse res) {
        super(req, res);
    }

    @Override
    public void doAction() throws IOException, SQLException, ServletException {
        req.getSession().setAttribute("id",null);
        req.getSession().setAttribute("role",null);
        req.getSession().setAttribute("email",null);
        req.getSession().setAttribute("password",null);
        req.getRequestDispatcher("/view/index.jsp").forward(req, res);
    }
}
