package by.fpmibsu.slastymordasty.controller.actions;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ImageAction extends AbstractAction{

    public ImageAction(HttpServletRequest req, HttpServletResponse res) {
        super(req, res);
    }

    @Override
    public void doAction() throws IOException {
        Scanner sc = new Scanner(req.getRequestURI());
        sc.useDelimiter("/");



        String imageName = "";

        while (sc.hasNext()){
            imageName = sc.next();
        }


        File file = new File("D:\\TP\\Slasty-Mordasty\\src\\main\\webapp\\img\\" + imageName);
        BufferedImage image = ImageIO.read(file);
        ImageIO.write(image, "JPG", res.getOutputStream());
    }
}
