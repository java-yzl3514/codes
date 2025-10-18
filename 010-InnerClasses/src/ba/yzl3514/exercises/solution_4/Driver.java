package ba.yzl3514.exercises.solution_4;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {

        Server server = Server.builder()
                .port(8080)
                .maxConnections(1024)
                .timeout(3000)
                .build();


        //...
        server.setUseSSL(true);

        System.out.println(server);

        server.run();

    }
}
