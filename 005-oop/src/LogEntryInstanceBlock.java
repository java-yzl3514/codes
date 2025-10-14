/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class LogEntryInstanceBlock {

    public final String entryId;
    private final long timestamp;
    private String message;


    {
        this.entryId = java.util.UUID.randomUUID().toString();
        this.timestamp = System.currentTimeMillis();
    }

    public LogEntryInstanceBlock(String message){
        this.message = message;
    }

    public LogEntryInstanceBlock(){
        this("Default Message");
    }
}
