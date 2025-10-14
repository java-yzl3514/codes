package receiver_parameter;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Socket {
    public boolean connected = false;

    public void connect(){
        this.connected = true;
        System.out.println("Socket is connected.");
    }

    public void sendData(@Connected Socket this, String data){
        if(!this.connected){
            System.out.println("Illegal socket state !");
            //throw exception!
        }
        System.out.println("Data is send.....");
    }
}
