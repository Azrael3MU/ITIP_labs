import java.util.regex.*;

public class IPAddressValidator {
    public static void main(String[] args) {
        String ipAddress = "192.168.1.1";//это строка, представляющая IP-адрес, который мы проверяем

        Pattern pattern = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
        //компилирует регулярное выражение, которое проверяет корректность IP-адреса

        Matcher matcher = pattern.matcher(ipAddress);
        //создает объект Matcher, который будет искать совпадения в IP-адресе с использованием регулярного выражения.

        if (matcher.matches()) {
            System.out.println("Корректный IP адресс");
        } else {
            System.out.println("Некорректный IP адресс");
        }//проверяет, соответствует ли IP-адрес критериям, заданным в регулярном выражении
    }
}