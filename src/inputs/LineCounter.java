package inputs;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;

public class LineCounter {
    public static ArrayList <String> readFile() throws FileNotFoundException, IOException{

        File file =  new File(LineCounter.class.getResource("KWIC2_input.txt").getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList <String> file = new ArrayList<String>() ;
        while ((st = br.readLine()) != null)
            file.add(st);
        return file;
    }


}