package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import Client.Observer;
import Client.User;
import Message.Message;

public class Server {
    private static final int PORT = 8818;
    private static ArrayList<Observer> users = new ArrayList<>();
    private static HashMap<Observer, ObjectOutputStream> oos = new HashMap<>();
    private static ServerSocket listener;
    private static StockPlatform stockPlatform = new StockPlatform();

    public static void main(String[] args) {
        System.out.println("Server.Server running . . .");
        stockPlatform.readFile("stocks.txt");

        try {
            listener = new ServerSocket(PORT);
            System.out.println("Started the serverSocket");
        } catch (IOException e){
            System.err.println("Unable to start the server");
        }

        try{
            while (true){
                Handler serverHandler = new Handler(listener.accept());
                Thread serverThread = new Thread(serverHandler);
                serverThread.start();
            }
        } catch (IOException e){
            System.err.println("Unable to listen");
        } finally {
            try {
                listener.close();
            } catch (IOException e){
                System.err.println("Unable to close the serverThread");
            }
        }
    }
    private static class Handler implements Runnable{
        private Socket socket;
        private InputStream inputStream;
        private OutputStream outputStream;
        private ObjectInputStream objectInputStream;
        private ObjectOutputStream objectOutputStream;
        private Observer user;

        public Handler(Socket accept) {
            this.socket = accept;
        }

        @Override
        public void run() {
            initConnection();
            getUser();
            sendAllStockInfo();

            while (socket.isConnected()){
               Message msg = receiveMsg();
               String token[] = msg.getMessage().split(" ");

               if (token[0].equalsIgnoreCase("S")){
                   stockPlatform.addObserver(token[1], this.user);
                   System.out.println("Added observer");
               } else if (token[0].equalsIgnoreCase("U")){
                   stockPlatform.removeObserver(token[1],this.user);
                   System.out.println("Removed observer");
               } else {
                   sendMessage("Invalid command");
               }


            }

        }
        public void getUser(){
            try {
                Observer user = (User) objectInputStream.readObject();
                users.add(user);
                oos.put(user, objectOutputStream);
                this.user = user;
                System.out.println("User object received");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void sendAllStockInfo(){
            try {
                Message allStocks  = new Message();
                for(Stock stock : stockPlatform.getStocks()){
                    allStocks.setMessage(allStocks.getMessage() + "\n" + stock.toString());
                }

                objectOutputStream.writeObject(allStocks);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void initConnection(){
            try {
                System.out.println("Attempting to connect to an user . . .");
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
                objectInputStream = new ObjectInputStream(inputStream);
                objectOutputStream = new ObjectOutputStream(outputStream);
                System.out.println("User connected");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        Message receiveMsg(){
            try {
                Message message = (Message) objectInputStream.readObject();
                return message;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
            return new Message();
        }

        void sendMessage(String msg){
            Message message = new Message();
            message.setMessage(msg);
            try {
                objectOutputStream.writeObject(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

