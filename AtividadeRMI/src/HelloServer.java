import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class HelloServer implements Hello {
	public HelloServer() {}  // Construtor

	public static void main(String[] args) {
		try {
			HelloServer server = new HelloServer();
			//Exporta o server para o stub ("apendice ou toco") do RMI na porta 0
			Hello stub = (Hello) UnicastRemoteObject.exportObject(server, 0);
			
			Registry registry = LocateRegistry.getRegistry();
			// Registra a stub no RMI para que ela seja obtida pelos clientes
			registry.bind("Servidor", stub);
			
			System.out.println("Servidor inicializado com sucesso.");
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}

	public float hello(float a, float b, float c) throws RemoteException {
        System.out.println("Executando metodo neste host, o cálculo do valor de delta da fórmula de Bhaskara");
        return b * b - 4 * a * c;
    }
}