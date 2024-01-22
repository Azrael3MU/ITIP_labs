import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The price of the product is $1.0, but there are also 20 items available.";
        try {
            findNumbersInText(text);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            // здесь можно выполнить другие действия при необходимости
        }
    }
    public static void findNumbersInText(String text) throws IllegalArgumentException { //функция, в которой обрабатываются ошибки
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");//pattern - ШАБЛОН
        Matcher matcher = pattern.matcher(text);//matcher - СОПОСТАВИТЕЛЬ

        if (!matcher.find()) { //точно делается
            throw new IllegalArgumentException("В тексте нет чисел");
        }
        do { //возможно делается
            System.out.println("Найдено число: " + matcher.group());
        } while (matcher.find());
    }
}
