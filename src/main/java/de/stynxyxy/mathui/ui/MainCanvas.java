package de.stynxyxy.mathui.ui;

import de.stynxyxy.mathui.objects.Function;
import de.stynxyxy.mathui.objects.Vector2;
import de.stynxyxy.mathui.util.GuiUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainCanvas extends JPanel {
    private Graphics2D oopg;
    ArrayList<Function> functions = new ArrayList<>();
    public MainCanvas() {
        this.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2));
    }
    public MainCanvas(Function function) {
        super();
        functions.add(function);
    }
    public MainCanvas(Function[] x) {
        for (Function f : x) {
            functions.add(f);
        }
    }
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        this.oopg = graphics2D;

        paintCoordinateSystem(graphics2D);
        Random r = new Random();
        int i = 1;
        for (Function function: functions) {
            graphics2D.setColor(new Color(r.nextInt(0,255),r.nextInt(0,255),r.nextInt(0,255)));
            drawFunction(function.getFactora(),function.getExponent(),graphics2D,i *-25);
            i++;
        }
    }
    public void paintCoordinateSystem(Graphics2D g) {
        //Draw X Axis
        Vector2 translatedFrom = GuiUtil.translateCoords(GuiUtil.getScreenMiddle().x(),0);
        Vector2 translatedTo = GuiUtil.translateCoords(-GuiUtil.getScreenMiddle().x() ,0);
        g.drawLine((int)translatedFrom.x(),(int)translatedFrom.y(),(int)translatedTo.x(),(int) translatedTo.y());
        for (int i =(int) -GuiUtil.getScreenMiddle().x() ; i <= GuiUtil.getScreenMiddle().x() ; i++) {
            if (i % 25 == 0) {
                Vector2 from = GuiUtil.translateCoords(i,-5);
                Vector2 to = GuiUtil.translateCoords(i,5);
                g.setColor(Color.BLACK);
                g.drawLine((int) from.x(),(int) from.y(),(int) to.x(),(int) to.y());
                if (i  == 0) continue;
                g.setColor(Color.RED);
                g.drawString(""+(i / 25),(int) to.x(),(int) to.y());

            }
        }
        //Draw Y Axis
        g.setColor(Color.BLACK);
        translatedFrom = GuiUtil.translateCoords(0,GuiUtil.getScreenMiddle().y() );
        translatedTo = GuiUtil.translateCoords(0,-GuiUtil.getScreenMiddle().y());
        g.drawLine((int) translatedFrom.x(),(int) translatedFrom.y(),(int) translatedTo.x(),(int) translatedTo.y());
        for (int i =(int) -GuiUtil.getScreenMiddle().y() ; i <= GuiUtil.getScreenMiddle().y() ; i++) {
            if (i % 25 == 0) {
                Vector2 from = GuiUtil.translateCoords(-5,i);
                Vector2 to = GuiUtil.translateCoords(5,i);
                g.setColor(Color.BLACK);
                g.drawLine((int) from.x(),(int) from.y(),(int) to.x(),(int) to.y());
                if (i  == 0) continue;
                g.setColor(Color.RED);
                g.drawString(""+(i / 25),(int) to.x() ,(int) to.y()+10);
            }
        }
    }

    public void drawFunction(double factora,double exponent, Graphics2D g,int ypos) {
        double scale = 25.0;


        double startX = -GuiUtil.getScreenMiddle().x() / scale;
        double endX = GuiUtil.getScreenMiddle().x() / scale;
        double step = 0.1;

        Vector2 from = GuiUtil.translateCoordsForFunction(startX, factora * Math.pow(startX, exponent));
        g.drawString("f(x) = "+factora+"*x^"+exponent,500,500+ypos);
        for (double x = startX; x <= endX; x += step) {
            double y = Math.pow(x, exponent);
            Vector2 to = GuiUtil.translateCoordsForFunction(x, y);


            g.drawLine((int) from.x(), (int) from.y(), (int) to.x(), (int) to.y());


            from = to;
        }
    }



}
