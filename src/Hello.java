import java.rmi.*;
 
public interface Hello extends Remote {
   public float hello(float a, float b, float c) throws RemoteException;
}
