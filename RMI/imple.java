import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class imple extends UnicastRemoteObject implements inter {

    public imple() throws RemoteException {
        super();  // Call the superclass constructor
    }

    @Override
    public int display(int a) throws RemoteException {
        int i,result=1;
        for(i=1;i<=a;i++){
           result=result*i;
        }
        return result;
    }
}
