package filters;

import java.util.List;
import java.util.Collections;

public class SortFilter extends Filter<String> {
    String order;

    public SortFilter(String order) {
        this.order = order;
    }

    @Override
    public List<String> run(List<String> input) {
        if (order.equals(ACC)) {
            input.sort(String.CASE_INSENSITIVE_ORDER);
        } else {
            input.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        }

        return input;
    }

    public static String ACC = "acc";
    public static String DEC = "dec";
}