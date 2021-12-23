import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        for (Integer number : source) {
            if (number >= treshold) {
                result.add(number);
                logger.log("Элемент \"" + number + "\" проходит");
            } else {
                logger.log("Элемент \"" + number + "\" не проходит");
            }

        }
        return result;
    }
}
