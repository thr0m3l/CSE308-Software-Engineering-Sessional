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
    private User user;
    private boolean isAdmin = false;

    public Client(String hostname, int PORT, boolean isAdmin) {
        this.hostname = hostname;
        this.PORT = PORT;
        this.isAdmin = isAdmin;
    }
    @Override
    public void run() {
        try {

            initConnection();
            sendObserver();
            receiveAllStockInfo();

            while (socket.isConnected()){
                Message msg = null;
                try {
                    msg =  (Message) objectInputStream.readObject();
                    System.out.println(msg.getMessage());
                } catch (EOFException | ClassNotFoundException e){
                    e.printStackTrace();
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void receiveAllStockInfo(){
        try {
            Message allStocks = (Message) objectInputStream.readObject();
            System.out.println(allStocks.getMessage());
        } catch (ClassNotFoundException | IOException classNotFoundException){
            classNotFoundException.printStackTrace();
        }
    }

    private void sendObserver(){
        this.user = new User();
        this.user.setAdmin(isAdmin);
        try {
            objectOutputStream.writeObject(user);
            System.out.println("Observer object sent to server");
        } catch (IOException e) {
            System.err.println("Error sending observer to server");
        }

    }

    private void initConnection(){
        try {
            socket = new Socket(hostname,PORT);
            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg){
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
