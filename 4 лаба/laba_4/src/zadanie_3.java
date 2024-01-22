import java.io.FileWriter;
import java.io.IOException;

class CustomUnsupportedOperationException extends UnsupportedOperationException {
    public CustomUnsupportedOperationException(String message) {
        super(message); // будет использоваться везде
    }
}

class MathOperation {
    public static int add(int a, int b) { //+
        throw new CustomUnsupportedOperationException("Addition is not supported");
    }
// throw - указывает, что исключение ЕСТЬ
    public static int subtract(int a, int b) {//-
        throw new CustomUnsupportedOperationException("Subtraction is not supported");
    }

    public static int multiply(int a, int b) {//*
        return a * b;
    }

    public static int divide(int a, int b) {//:
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}

class ExceptionHandler {
    private FileWriter fileWriter;

    public ExceptionHandler() {
        try {
            fileWriter = new FileWriter("exceptions.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleException(Exception e) {
        try {
            fileWriter.write(e.toString());
            fileWriter.write("\n");
            fileWriter.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class zadanie_3 { // вызов операций
    public static void main(String[] args) {
        ExceptionHandler exceptionHandler = new ExceptionHandler();

        try {
            int result = MathOperation.add(5, 10);
            System.out.println("Result: " + result);
        } catch (CustomUnsupportedOperationException e) {
            exceptionHandler.handleException(e);
        }

        try {
            int result = MathOperation.subtract(10, 5);
            System.out.println("Result: " + result);
        } catch (CustomUnsupportedOperationException e) {
            exceptionHandler.handleException(e);
        }

        try {
            int result = MathOperation.multiply(5, 10);
            System.out.println("Result: " + result);
        } catch (CustomUnsupportedOperationException e) {
            exceptionHandler.handleException(e);
        }

        try {
            int result = MathOperation.divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            exceptionHandler.handleException(e);
        }

        exceptionHandler.close();
    }
}