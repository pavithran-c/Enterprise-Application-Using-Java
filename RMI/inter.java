import java.rmi.Remote;
import java.rmi.RemoteException;

public interface inter extends Remote {
    public int display(int a) throws RemoteException;
}
