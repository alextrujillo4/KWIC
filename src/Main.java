import filters.LowerCaseFilter;
import filters.ShiftFilter;
import filters.SortFilter;

import inputs.LineCounter;
import pipeline.PipeLine;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        PipeLine<String> pipeline = new PipeLine<String>()
                .addFilter(new LowerCaseFilter())
                .addFilter(new ShiftFilter())
                .addFilter(new SortFilter());

        List<String> input =
                Arrays.asList("Clouds are white", "Pittsburgh is beautiful");
        System.out.println(pipeline.run(input));


        LineCounter.readFile();

    }
}
