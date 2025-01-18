package de.stynxyxy.mathui.ui;

import de.stynxyxy.mathui.Main;
import de.stynxyxy.mathui.objects.Function;
import de.stynxyxy.mathui.objects.PowerFunction;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class MainUi extends JFrame {
    public MainUi() {
        initialize();
    }

    private void initialize() {
        this.setTitle("Math Functions");
        this.setBackground(Color.WHITE);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new Dimension(size));
        Scanner s = new Scanner(System.in);

        //System.out.print("How many functions do you want to Draw?");
        //int num = s.nextInt();
        Function[] functions = new Function[2];
        /*
        for (int i = 0; i < num; i++) {
            functions[i] = getFunctionByInput(i,s);
        }
         */
        functions[0] = new Function() {
            @Override
            public double calcY(double x) {
                return 2*x;
            }
        };
        functions[1] = new Function() {
            @Override
            public double calcY(double x) {
                return Math.sin(x);
            }
        };


        drawF(functions);


        this.setVisible(true);

    }
    private Function getFunctionByInput(int index, Scanner s) {
        System.out.println("Function: "+index);
        System.out.println("Exponent:");
        double exponent = s.nextDouble();
        System.out.println("\nFactor a:");
        double factora = s.nextDouble();
        return new PowerFunction(exponent,factora);
    }

    private void drawF(Function[] function) {

        MainCanvas canvas = new MainCanvas(function);
        this.add(canvas);
        this.repaint();
    }
}
