package client;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

@Slf4j
public class Client {

    public static void main(String[] args) {

        if (args.length == 0) {
            log.info("Usage: enter stock name.");
            System.exit(0);
        }

        Socket socket;
        BufferedReader inbound = null;
        OutputStream outbound = null;

        try {
            socket = new Socket("localhost", 3000);

            outbound = socket.getOutputStream();
            inbound = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            outbound.write((args[0] + "\n").getBytes());
            outbound.write("End\n".getBytes());

            String quote;
            while (true) {
                quote = inbound.readLine();
                if ("End".equals(quote)) {
                    break;
                }
                log.info("Got the quote for " + args[0] + ":" + quote);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
