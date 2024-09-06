import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        try {
            String host = "localhost";
            inter remoteobj = (inter) Naming.lookup("rmi://" + host + ":1099/inter");
            Scanner s=new Scanner(System.in);
            int a=s.nextInt();
            System.out.println(remoteobj.display(a));
        } catch (RemoteException re) {
            re.printStackTrace();
        } catch (NotBoundException nbe) {
            nbe.printStackTrace();
        } catch (MalformedURLException mfe) {
            mfe.printStackTrace();
        }
    }
}
