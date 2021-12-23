import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        int listSize = 0;
        int maximum = 0;
        int treshold = 0;
        List<Integer> source = new ArrayList<>();
        Random random = new Random();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.println("Введите размер списка:");
        try {
            listSize = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Введите верхнюю границу для значений: ");
        try {
            maximum = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.log("Создаём и наполняем список");
        for (int i = 0; i < listSize; i++) {
            source.add(random.nextInt(maximum));
        }
        System.out.print("Вот случайный список: ");
        source.forEach(n -> System.out.print(n + " "));
        System.out.println();

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите порог для фильтра: ");
        try {
            treshold = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.log("Запускаем фильтрацию");

        Filter filter = new Filter(treshold);
        List<Integer> result = filter.filterOut(source);
        logger.log("Прошло фильтр " + result.size() + " элемента(ов) из " + listSize);
        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список: ");
        result.forEach(n -> System.out.print(n + " "));
        System.out.println();
        logger.log("Завершаем программу");
    }
}
