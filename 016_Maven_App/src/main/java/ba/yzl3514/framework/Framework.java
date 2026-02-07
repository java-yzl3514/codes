package ba.yzl3514.framework;

import ba.yzl3514.app.InvoiceFindAllCase;
import ba.yzl3514.jdbc.DBConnectionManager;
import ba.yzl3514.jdbc.core.JdbcTemplate;
import ba.yzl3514.repository.InvoiceJdbcRepositoryImpl;
import ba.yzl3514.repository.InvoiceRepository;
import ba.yzl3514.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

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
            JdbcTemplate jdbcTemplate = new JdbcTemplate(DBConnectionManager.getDataSource());
            // Dependency Injection View....
            InvoiceRepository invoiceRepository = new InvoiceJdbcRepositoryImpl(jdbcTemplate);
            InvoiceService invoiceService = new InvoiceService(invoiceRepository);

            ApplicationRunner runner = new InvoiceFindAllCase(invoiceService);
            runner.run();

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                logger.info("[Framework] The Application is shutting down...");
                // close actions
                logger.info("[Framework] Bye");
            }));

            long end = System.currentTimeMillis();
            logger.info(String.format("[Framework] started in %.3f seconds%n", (end - start) / 1000.0));

            keepAlive();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[ERROR] The Application could not started");
        } finally {
            DBConnectionManager.shutdown();
        }
    }

    private static void keepAlive() {
        try {
            new CountDownLatch(1).await();
        } catch (InterruptedException e) {
            logger.info("[Framework] Cancel accepted");
        }
    }
}
