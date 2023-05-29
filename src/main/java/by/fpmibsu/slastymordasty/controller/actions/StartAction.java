package by.fpmibsu.slastymordasty.controller.actions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StartAction extends AbstractAction{
    public StartAction(HttpServletRequest req, HttpServletResponse res) {
        super(req, res);
    }

    @Override
    public void doAction() {

        try{
            req.getRequestDispatcher("/view/index.jsp").forward(req, res);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
