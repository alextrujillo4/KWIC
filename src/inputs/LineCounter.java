package inputs;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;

public class LineCounter {
    public static void readFile() throws FileNotFoundException, IOException{

        File file =  new File(LineCounter.class.getResource("KWIC2_input.txt").getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);
    }


}