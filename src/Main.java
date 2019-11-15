import filters.Filter;
import filters.LowerCaseFilter;
import filters.ShiftFilter;
import filters.SortFilter;

import inputs.LineCounter;
import pipeline.PipeLine;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        LineCounter lineCounter = new LineCounter();
        lineCounter.readFile("KWIC2_input.txt");
        lineCounter.printLines();

        System.out.println("Quieres quitar lineas? especificalas separadas por comas o pon 'no'\n");
        Scanner scanner = new Scanner(System.in);
        lineCounter.setDeleteLines(scanner);

        System.out.println("Quieres quitar stopwords? y/n\n");
        if (scanner.nextLine().equals("y")) {
            lineCounter.deleteStopWords();
        }

        System.out.println("Orden asc o desc?\n");
        String filter = scanner.nextLine().equals("asc") ? SortFilter.ACC : SortFilter.DEC;
        lineCounter.setFiltersToList(filter);


        /*
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("%d) %s\n", i, result.get(i));
        }

        System.out.println("Quieres quitar lineas? especificalas separadas por comas o pon 'no'\n");
        for (String s : scanner.nextLine().split(",")) {
            try {
                result.set(Integer.parseInt(s), null);
            } catch (NumberFormatException err) {
                //
            }

        }

        result.removeAll(Collections.singleton(null));
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("%d) %s\n", i, result.get(i));
        }
*/

    }
}