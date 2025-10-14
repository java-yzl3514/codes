
/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class LogEntry {

    public final String entryId;
    private final long timestamp;
    private String message;

    public LogEntry(String message){
        this.entryId = java.util.UUID.randomUUID().toString();
        this.timestamp = System.currentTimeMillis();
        this.message = message;
    }

    public LogEntry(){
        this("Default Message");
    }
}
