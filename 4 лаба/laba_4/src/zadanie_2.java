import java.io.*;

public class zadanie_2 {
    public static void main(String[] args) {
        String sourceFileName = "source.txt"; //изначальный файл
        String destinationFileName = "destination.txt"; //куда скопируется

        try {
            File sourceFile = new File(sourceFileName); //находим начальный файл
            File destinationFile = new File(destinationFileName); //находим файл куда кидать

            // Проверка существования файла-источника
            if (!sourceFile.exists()) {
                System.out.println("Ошибка: файл-источник не существует.");
                return;
            }

            // Создание потоков чтения и записи файлов
            FileReader fileReader = new FileReader(sourceFile);
            FileWriter fileWriter = new FileWriter(destinationFile);

            // Копирование содержимого
            int character;
            while ((character = fileReader.read()) != -1) {
                fileWriter.write(character);
            }

            // Закрытие потоков чтения и записи файлов
            fileReader.close();
            fileWriter.close();

            System.out.println("Файл успешно скопирован.");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл не найден.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла.");
        }
    }
}