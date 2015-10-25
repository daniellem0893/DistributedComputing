
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class TimeStuff {
    private boolean timing;
    private long startTime;
    private String msg;
    private static TimeStuff mainTimer;
    
    //Wrappers for mainTimer. Use these for timing operations
    public static void initTimer(){ //Start a new Timer (i.e. with a new message)
        mainTimer = new TimeStuff();
    }
    public static void startTimer(){
        if(mainTimer == null) return;
        mainTimer._startTimer();
    }
    public static long stopTimer(String m){
        if(mainTimer == null) return -1;
        return mainTimer._stopTimer(m);
    }
    public static void saveMessageToFile(String filename){
        if(mainTimer == null) return;
        mainTimer._saveMessageToFile(filename);
    }
    
    //Timer operations, use the static versions instead (because I'm lazy)
    public TimeStuff(){
        timing = false;
        msg = "";
    }
    public void _startTimer(){
        timing = true;
        startTime = System.currentTimeMillis();
    }
    public long _stopTimer(String message){
        if(timing){
            timing = false;
            long result = System.currentTimeMillis() - startTime;
            msg += message + " " + result + "ms\n";
            return result;
        } else {
            return -1;
        }
    }
    public void _saveMessageToFile(String fileName){
        try {
            PrintWriter writer;
            writer = new PrintWriter(fileName, "UTF-8");
            writer.println("msg");
            writer.close();
        } 
        catch (FileNotFoundException ex) { System.out.println("File not found!"); } 
        catch (UnsupportedEncodingException ex) {}
    }
}
