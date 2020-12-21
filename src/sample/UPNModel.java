package sample;

import java.util.EmptyStackException;

/**
 * @author Sophie Kadletz
 * @version 21.12.2020
 */

public class UPNModel {
    private DoubleStack numbers;
    private double tmp;

    public UPNModel() {
        this.numbers = new DoubleStack();
    }

    public String addNumber(double num) {
        numbers.add(num);
        return numbers.toString();
    }

    public String addStackNumbers() {
        String output = "";
        double d1 = 0;
        double d2 = 0;

        if (getNumber()) {
            d1 = tmp;

            if (getNumber()) {
                d2 = tmp;
                numbers.push(d1 + d2);
            } else {
                numbers.push(d1);
                output = "e";
            }
        } else {
            output = "e";
        }

        return output + numbers.toString();
    }

    public String substractStackNumbers() {
        String output = "";
        double d1 = 0;
        double d2 = 0;

        if (getNumber()) {
            d1 = tmp;

            if (getNumber()) {
                d2 = tmp;
                numbers.push(d1 - d2);
            } else {
                numbers.push(d1);
                output = "e";
            }
        } else {
            output = "e";
        }

        return output + numbers.toString();
    }

    public String multiplyStackNumbers() {
        String output = "";
        double d1 = 0;
        double d2 = 0;

        if (getNumber()) {
            d1 = tmp;

            if (getNumber()) {
                d2 = tmp;
                numbers.push(d1 * d2);
            } else {
                numbers.push(d1);
                output = "e";
            }
        } else {
            output = "e";
        }

        return output + numbers.toString();
    }

    public String divideStackNumbers() {
        String output = "";
        double d1 = 0;
        double d2 = 0;

        if (getNumber()) {
            d1 = tmp;

            if (getNumber()) {
                d2 = tmp;
                if (d2 != 0) {
                    numbers.push(d1 / d2);
                } else {
                    numbers.push(d2);
                    numbers.push(d1);
                    output = "a";
                }
            } else {
                numbers.push(d1);
                output = "e";
            }
        } else {
            output = "e";
        }

        return output + numbers.toString();
    }

    public String invertStackTop() {
        String output = "";
        if (!numbers.isEmpty()) {
            double d = numbers.pop();
            if (d == 0) {
                output = "a";
                numbers.push(d);
            } else {
                numbers.push(1/d);
            }
        } else {
            output = "e";
        }

        return output + numbers.toString();
    }

    public String swapStackTop() {
        String output = "";
        double d1 = 0;
        double d2 = 0;

        if (getNumber()) {
            d1 = tmp;

            if (getNumber()) {
                d2 = tmp;
                numbers.push(d1);
                numbers.push(d2);
            } else {
                numbers.push(d1);
                output = "e";
            }
        } else {
            output = "e";
        }

        return output + numbers.toString();
    }

    private boolean getNumber() {
        boolean bool = true;
        try {
            tmp = numbers.pop();
        } catch (EmptyStackException ese) {
            bool = false;
        } finally {
            return bool;
        }
    }

    public String clearStack() {
        numbers.clear();
        return numbers.toString();
    }
}
