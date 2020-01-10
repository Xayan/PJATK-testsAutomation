package pl.xayan;

import pl.xayan.figure.FigureFactory;
import pl.xayan.figure.FigureInterface;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Integer[] lengths = null;

        try {
             lengths = Arrays.stream(args).map(Integer::new).toArray(Integer[]::new);
        } catch(NumberFormatException e) {
            System.out.print("nierozpoznano");
            System.exit(1);
        }

        FigureFactory figureFactory = new FigureFactory();
        FigureInterface figure = null;

        try {
            figure = figureFactory.createFromLengths(lengths);
        } catch (Exception e) {
            System.out.print("nierozpoznano");
            System.exit(1);
        }

        if (!figure.isValid()) {
            System.out.print("nierozpoznano");
            System.exit(1);
        }

        System.out.print(figure.getType());
    }
}
