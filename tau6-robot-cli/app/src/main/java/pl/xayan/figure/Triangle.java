package pl.xayan.figure;

import java.util.Arrays;

public class Triangle implements FigureInterface {
    private Integer[] lengths;

    Triangle(Integer[] lengths) {
        this.lengths = lengths;

        Arrays.sort(this.lengths);
    }

    @Override
    public boolean isValid() {
        if(lengths.length != 3) return false;

        return lengths[0] + lengths[1] > lengths[2];
    }

    @Override
    public String getType() {
        if(lengths[0].equals(lengths[1]) && lengths[1].equals(lengths[2])) {
            return "trójkąt równoboczny";
        } else if(lengths[0].equals(lengths[1]) || lengths[1].equals(lengths[2]) || lengths[0].equals(lengths[2])) {
            return "trójkąt równoramienny";
        } else {
            return "trójkąt różnoboczny";
        }
    }
}
