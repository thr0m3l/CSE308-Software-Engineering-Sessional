package Client;

import Message.Message;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable{
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private String hostname;
    private int PORT;
    private Observer user;

    public Client(String hostname, int PORT) {
        this.hostname = hostname;
        this.PORT = PORT;
    }
    @Override
    public void run() {
        try {
            socket = new Socket(hostname,PORT);

            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);

            inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);

            this.user = new User();
            objectOutputStream.writeObject(user);
            System.out.println("Observer object sent to server");

            try {
                Message allStocks = (Message) objectInputStream.readObject();
                System.out.println(allStocks.getMessage());
            } catch (ClassNotFoundException classNotFoundException){
                classNotFoundException.printStackTrace();
            }

            while (socket.isConnected()){
                String msg = null;
                try {
                    msg = (String) objectInputStream.readObject();
                    System.out.println(msg);
                } catch (EOFException e){
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void send (String msg){
        try {
            Message message = new Message();
            message.setMessage(msg);
            message.setUser(this.user);
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();

        } catch (IOException e){
            System.err.println("Unable to send message");
        }
    }
}
