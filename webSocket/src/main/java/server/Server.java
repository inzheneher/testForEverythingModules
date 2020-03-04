package server;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class Server {

    public static void main(String[] args) {

        ServerSocket serverSocket;
        Socket socket;
        BufferedReader inbound = null;
        OutputStream outbound = null;

        try {
            serverSocket = new ServerSocket(3000);
            while (true) {
                socket = serverSocket.accept();
                inbound = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                outbound = socket.getOutputStream();

                String symbol = inbound.readLine();
                String price = Double.toString(Math.random() * 100);
                outbound.write(("The price of " + symbol + " is " + price + "\n").getBytes());
                log.info("Request for " + symbol + " has been processed - price of " + symbol + " is " + price + "\n");
                outbound.write("End\n".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inbound.close();
                outbound.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
