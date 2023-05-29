package by.fpmibsu.slastymordasty.controller.actions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

public class ToRegPageAction extends AbstractAction {

    public ToRegPageAction(HttpServletRequest req, HttpServletResponse res) {
        super(req, res);
    }

    public void doAction(){
        try{
            req.getRequestDispatcher("/view/reg.jsp").forward(req, res);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
