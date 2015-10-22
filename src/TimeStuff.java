
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimeStuff {
    private boolean timing;
    private long startTime;
    private String msg;
    public TimeStuff(){
        timing = false;
        msg = "";
    }
    public void startTimer(){
        timing = true;
        startTime = System.currentTimeMillis();
    }
    public long stopTimer(String message){
        if(timing){
            timing = false;
            long result = System.currentTimeMillis() - startTime;
            msg += message + " " + result + "\n";
            return result;
        } else {
            return -1;
        }
    }
    public void saveMessageToFile(String fileName){
        try {
            PrintWriter writer;
            writer = new PrintWriter(fileName, "UTF-8");
            writer.println("The first line");
            writer.println("The second line");
            writer.close();
        } 
        catch (FileNotFoundException ex) { System.out.println("File not found!"); } 
        catch (UnsupportedEncodingException ex) {}
    }
}
