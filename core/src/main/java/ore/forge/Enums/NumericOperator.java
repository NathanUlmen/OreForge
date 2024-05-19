package ore.forge.Enums;

import java.util.function.DoubleBinaryOperator;

public enum NumericOperator {
    ADD, SUBTRACT, MULTIPLY, DIVIDE, EXPONENT, ASSIGNMENT, MODULO;

    public final double apply(double x, double y) {
        return operator.applyAsDouble(x, y);
    }
    public enum Associativity {LEFT, RIGHT}

    private final DoubleBinaryOperator operator;
    private final Associativity associativity;
    private final int precedence;

    public static NumericOperator fromSymbol(char operatorSymbol) {
        return switch (operatorSymbol) {
            case '+' -> NumericOperator.ADD;
            case '-' -> NumericOperator.SUBTRACT;
            case '*' -> NumericOperator.MULTIPLY;
            case '/' -> NumericOperator.DIVIDE;
            case '^' -> NumericOperator.EXPONENT;
            case '=' -> NumericOperator.ASSIGNMENT;
            case '%' -> NumericOperator.MODULO;
            default -> throw new IllegalArgumentException("Invalid operator: " + operatorSymbol);
        };
    }

    public static NumericOperator fromSymbol(String operatorSymbol) {
        return switch (operatorSymbol) {
            case "+" -> NumericOperator.ADD;
            case "-" -> NumericOperator.SUBTRACT;
            case "*" -> NumericOperator.MULTIPLY;
            case "/" -> NumericOperator.DIVIDE;
            case "^" -> NumericOperator.EXPONENT;
            case "=" -> NumericOperator.ASSIGNMENT;
            case "%" -> NumericOperator.MODULO;
            default -> throw new IllegalArgumentException("Invalid operator: " + operatorSymbol);
        };
    }

    public String asSymbol() {
        return switch (this) {
            case ADD -> "+";
            case SUBTRACT -> "-";
            case MULTIPLY -> "*";
            case DIVIDE -> "/";
            case EXPONENT -> "^";
            case ASSIGNMENT -> "=";
            case MODULO -> "%";
        };
    }

    public static boolean isOperator(String symbol) {
        return switch (symbol) {
            case "+", "-" , "*", "/", "^", "=", "%" -> true;
            default -> false;
        };
    }

    public Associativity getAssociativity() {
        return associativity;
    }

    public int getPrecedence() {
        return precedence;
    }

    NumericOperator() {
        operator = switch (this) {
            case ADD -> (x, y) -> x + y;
            case SUBTRACT -> (x, y) -> x - y;
            case MULTIPLY -> (x, y) -> x * y;
            case DIVIDE -> (x, y) -> x / y; //TODO: Handle division by zero....
            case EXPONENT -> (x, y) -> Math.pow(x, y);
            case ASSIGNMENT -> (x, y) -> y;
            case MODULO -> (x, y) -> x % y;
        };
        associativity = switch (this) {
            case ADD, SUBTRACT, MULTIPLY, DIVIDE, MODULO -> Associativity.LEFT;
            case EXPONENT, ASSIGNMENT -> Associativity.RIGHT;
        };
        precedence = switch (this) {
            case ADD, SUBTRACT -> 2;
            case MULTIPLY, DIVIDE, MODULO -> 3;
            case EXPONENT -> 4;
            case ASSIGNMENT -> 0;
        };


    }

}
