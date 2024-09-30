import java.rmi.registry.*;
import java.util.Scanner;

public class HelloClient {
	public static void main(String[] args) {
		try {
			try (Scanner scanner = new Scanner(System.in)) {
				// Chama o método do servidor e imprime a mensagem
				System.out.println("Invocando metodo do servidor");
				
				System.out.println("Digite o valor de (a):");
				float a = scanner.nextFloat();

				System.out.println("Digite o valor de (b):");
				float b = scanner.nextFloat();

				System.out.println("Digite o valor de (c):");
				float c = scanner.nextFloat();

				// Procura o registro do RMI no Servidor
				// Se o servidor estiver em outro host basta substituir pelo seu IP
				Registry registry = LocateRegistry.getRegistry("192.168.56.1");

				// Procura a stub do servidor
				Hello stub = (Hello) registry.lookup("Servidor");

				float delta = stub.hello(a, b, c);
				System.out.println("Servidor informa: o valor de delta é " + delta);
				System.out.println("Pois:");
				System.out.println(delta + " = " + b + "² - 4 . " + a + " . " + c);
			} 
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}
}
