package sample;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author Sophie Kadletz
 * @version 21.12.2020
 */

public class DoubleStack extends Stack<Double> {
    public DoubleStack() {
        super();
    }

    @Override
    public synchronized String toString() {
        Iterator<Double> iterator = this.iterator();
        String output = "";
        while (iterator.hasNext()) {
            output += iterator.next() + "\n";
        }
        return output;
    }
}
