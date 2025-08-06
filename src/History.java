/**
 *
 * @author Vincenzo Scarso
 */
import java.io.*;

public class History {
    private File output_file;
    private FileOutputStream out_byte;
    private PrintWriter out_line;
    private int current_record_ID;
    
    public History (String path) {
        this.current_record_ID = 0;
        this.output_file = new File(path);
        
        if (!output_file.exists()) {
            try{
                output_file.createNewFile();
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        
        try {
            out_byte = new FileOutputStream(output_file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            out_byte = null;
        }
        
        out_line = new PrintWriter(out_byte);
        
    }
    
    public void saveToBuffer(String record) {
        out_line.println("[ID:" + String.valueOf(current_record_ID)+ "]" + " Calcolo:{" + record + "}");
        current_record_ID++;
    }
    
    public void saveHistoryToFile () {
        out_line.flush();
    }
    
    public void freeResources () {
        out_line.close();
    }
}