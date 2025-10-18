package ba.yzl3514.exercises.solution_4;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Server {
    private int port;
    private int timeout = 2000;
    private int maxConnections = 1024;
    private boolean useSSL;

    //...
    private Server(int port) {
        this.port = port;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void setUseSSL(boolean useSSL) {
        this.useSSL = useSSL;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void run() {
        System.out.println("Server is running on port : " + port);
    }

    @Override
    public String toString() {
        return String.format("Server { port:  %d, timeout: %d, maxConnection: %d, useSSL: %b }", port, timeout, maxConnections, useSSL);
    }

    public static class Builder {
        private int port;
        private int timeout;
        private int maxConnections;
        private boolean useSSL;

        private Builder() {
        }

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public Builder maxConnections(int maxConnections) {
            this.maxConnections = maxConnections;
            return this;
        }

        public Builder useSSL(boolean useSSL) {
            this.useSSL = useSSL;
            return this;
        }

        public Server build() {
            Server server = new Server(port);
            //server.port = port;
            server.setTimeout(timeout);
            server.setMaxConnections(maxConnections);
            server.setUseSSL(useSSL);
            return server;
        }
    }
}
