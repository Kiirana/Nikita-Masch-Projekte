import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Date;

class main {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6789);
            System.out.println("Waiting for incoming connections...");
            while (true) {
                Socket s = null;
                try {
                    s = serverSocket.accept();
                    s.setSoTimeout(200000);
                    System.out.println("Connected to: " + s.getRemoteSocketAddress());
                    String request = readText(s);
                    System.out.println( request);
                    Date lastAccessTimestamp = parseCookie(request);
                    String response = generateResponse(lastAccessTimestamp);
                    System.out.println("Response: " + response);
                    sendText(s, response);
                    s.close();



                } catch (IOException e) {
                    System.out.println("Error handling connection");
                    e.printStackTrace();
                } finally {
                    if (s != null) {
                        try {
                            s.close();
                        } catch (IOException e) {
                            System.out.println("Error closing socket");
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error creating socket");
            e.printStackTrace();
        }
    }
    private static String readText(Socket s) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str;
        StringBuilder sb = new StringBuilder();
        try {
            while ((str = br.readLine()) != null) {
                sb.append(str);
                sb.append("\r\n");
            }
        } catch (SocketTimeoutException e) {
            System.out.println("Socket read timed out");
            // Handle the timeout error here, e.g. by sending an error response to the client
        }
        return sb.toString();
    }


    private static void sendText(Socket s, String string) {
        System.out.println("Transmitting via socket...");
        try {
            OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
            osw.write(string);
            osw.write("\n\r\n\r");
            osw.flush();
        } catch (IOException e) {
            System.out.println("Error transmitting via socket");
            e.printStackTrace();
        }
    }

    private static Date parseCookie(String cookie) {
        Date timestamp = null;
        String[] parts = cookie.split(";");
        for (String part : parts) {
            part = part.trim();
            if (part.contains("timestamp")) {
                System.out.println("Timestamp gefunden");
                String value = part.substring(25);

                //      String value = part.substring("timestamp=".length());
                long millis = Long.parseLong(value);
                timestamp = new Date(millis);
                System.out.println(" gefundene Zeit : "+  part.substring("timestamp=".length()));
            }
        }
        return timestamp;
    }

    private static String generateResponse(Date lastAccessTimestamp) {
        Date now = new Date();
        String Nachricht;
        String message;
        String news;



        Date datum = new Date();
        System.out.println(datum.toString());
        long timestamp = datum.getTime();
        System.out.println(timestamp);
        Date eingelesenesDatum = new Date(timestamp);
        news = eingelesenesDatum.toString();
        Nachricht = eingelesenesDatum.toString();

        if (lastAccessTimestamp == null) {
            message = "Thanks for checking out the server ";
        } else {
            long diff = now.getTime() - lastAccessTimestamp.getTime();
            int seconds = (int) (diff / 1000);
            message = "Thanks for checking out the server again last visit " + seconds + " seconds ago.";
        }
        String timestampCookie = "Set-Cookie: timestamp=" + now.getTime() + "\r\n";
        return "HTTP/1.0 200 OK\r\n" +
                "Content-Type: text/plain\r\n" +
                timestampCookie +
                "\r\n" +
                message + Nachricht ;
    }
}
