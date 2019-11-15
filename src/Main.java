import filters.LowerCaseFilter;
import filters.ShiftFilter;
import filters.SortFilter;

import pipeline.PipeLine;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PipeLine<String> pipeline = new PipeLine<String>()
                .addFilter(new LowerCaseFilter())
                .addFilter(new ShiftFilter())
                .addFilter(new SortFilter());


        List<String> input =
                Arrays.asList(new String[] { "Clouds are white", "Pittsburgh is beautiful" });
        System.out.println(pipeline.run(input));

    }
}
