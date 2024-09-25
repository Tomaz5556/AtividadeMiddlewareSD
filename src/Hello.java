import java.rmi.*;
 
public interface Hello extends Remote {
   public String hello() throws RemoteException;
}
