import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int timeout = 2000;

        Socket socket = new Socket();
        Scanner in = new Scanner(System.in);

        System.out.print("Website to connect: ");
        String hostname = in.nextLine();

        System.out.print("Port: ");
        int port = in.nextInt();
        in.close();

        SocketAddress socketAddress = new InetSocketAddress(hostname, port);

        try {
            socket.connect(socketAddress, timeout);
            socket.close();
            System.out.println("\n> " + hostname
                    + " \u001B[32mOK\u001B[0m");
        }

        catch (SocketException exception) {
            System.err.println("\nSocketTimeoutException " + hostname + ":"
                    + port + " " + exception.getMessage());
        }

        catch (IOException exception) {
            System.err.println("\nUnable to connect to " + hostname + ":" + port
                    + " " + exception.getMessage());
        }
    }
}
