import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class server {
    public static void main(String[] args) {
        try {
            imple obj = new imple();
            Naming.rebind("rmi://localhost:1099/inter", obj);
            System.out.println("Server is ready.");
        } catch (RemoteException | MalformedURLException re) {
            re.printStackTrace();
        }
    }
}
