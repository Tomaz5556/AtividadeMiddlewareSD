import java.rmi.registry.*;

public class HelloClient {
	public static void main(String[] args) {
		try {
			// Procura o registro do RMI no Servidor
			// Se o servidor estiver em outro host basta substituir pelo seu IP
			Registry registry = LocateRegistry.getRegistry("192.168.56.1");

			// Procura a stub do servidor
			Hello stub= (Hello) registry.lookup("Servidor");

			// Chama o método do servidor e imprime a mensagem
			System.out.println("Invocando metodo do servidor");
			String msg = stub.hello();
			System.out.println("Mensagem retornada pelo Servidor: " + msg); 
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}
}
