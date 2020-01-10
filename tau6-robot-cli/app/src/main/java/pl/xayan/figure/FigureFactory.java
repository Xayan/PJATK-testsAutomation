package pl.xayan.figure;

public class FigureFactory {
    public FigureInterface createFromLengths(Integer[] lengths) throws Exception {
        switch(lengths.length) {
            case 3:
                return new Triangle(lengths);
            case 4:
                return new Quadrangle(lengths);
            default:
                throw new Exception("Invalid number of sides");
        }
    }
}
