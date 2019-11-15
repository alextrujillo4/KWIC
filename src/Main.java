import filters.Filter;
import filters.LowerCaseFilter;
import filters.ShiftFilter;
import filters.SortFilter;

import inputs.LineCounter;
import pipeline.PipeLine;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        LineCounter lineCounter = new LineCounter();
        lineCounter.readFile("KWIC2_input.txt");
        lineCounter.printLines();

        System.out.println("Quieres quitar lineas? especificalas separadas por comas o pon 'no'\n");
        Scanner scanner = new Scanner(System.in);
        for (String s : scanner.nextLine().split(",")) {
            try {
                lineCounter.deleteResultado(Integer.parseInt(s));
            } catch (NumberFormatException err) {
                //
            }

        }
        lineCounter.removeAll();

        System.out.println("Quieres quitar stopwords? y/n\n");
        Collection<String> stopWords = lineCounter.readFileFrom("KWIC2_stop.txt");
        if (scanner.nextLine().equals("y")) {
            lineCounter.deleteStopWords(scanner,stopWords);
        }

        System.out.println("Orden asc o desc?\n");
        String filter = scanner.nextLine().equals("asc") ? SortFilter.ACC : SortFilter.DEC;
        lineCounter.setFilters(filter);

        lineCounter.printLines();

        System.out.println("Quieres quitar lineas? especificalas separadas por comas o pon 'no'\n");
        for (String s : scanner.nextLine().split(",")) {
            try {
                lineCounter.deleteResultado(Integer.parseInt(s));
            } catch (NumberFormatException err) {
                //
            }

        }
        lineCounter.removeAll();

        lineCounter.printLines();

    }

}