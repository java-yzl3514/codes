package ba.yzl3514.framework;

import ba.yzl3514.jdbc.DBConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Framework {

    private static Logger logger = LoggerFactory.getLogger(Framework.class);
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";


    public static void run() {

        String banner = """
                 __  __ _       _ _____                                            _   \s
                |  \\/  (_)_ __ (_)  ___| __ __ _ _ __ ___   _____      _____  _ __| | __
                | |\\/| | | '_ \\| | |_ | '__/ _` | '_ ` _ \\ / _ \\ \\ /\\ / / _ \\| '__| |/ /
                | |  | | | | | | |  _|| | | (_| | | | | | |  __/\\ V  V / (_) | |  |   <\s
                |_|  |_|_|_| |_|_|_|  |_|  \\__,_|_| |_| |_|\\___| \\_/\\_/ \\___/|_|  |_|\\_\\
                
                """;

        System.out.println(ANSI_RESET + banner + ANSI_GREEN);
        System.out.println(" :: Mini-Framework :: yzl3514                              (v1.0.0)");
        System.out.println("------------------------------------------------------------------------------");

        long start = System.currentTimeMillis();
        try {
            logger.info("[Framework] starting...");
            DBConnectionManager.start();
            // TODO
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[ERROR] The Application could not started");
        } finally {
            DBConnectionManager.shutdown();
            long end = System.currentTimeMillis();
            logger.info(String.format("[Framework] started in %.3f seconds%n", (end - start) / 1000.0));
        }
    }

}
