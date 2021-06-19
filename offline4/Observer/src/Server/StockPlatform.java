package Server;

import Client.Observer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class StockPlatform implements Observable{
    private HashMap<String, Stock> stocks = new HashMap<>();
    private HashMap<Stock, ArrayList<Observer>> observerList = new HashMap<>();


    public void readFile(String filename){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename)))
        {
            String line = " ";
            while(true){
                line = bufferedReader.readLine();
                if (line == null) break;
                String tokens[] = line.split(" ");
                Stock stock = new Stock(Double.parseDouble(tokens[2]), Integer.parseInt(tokens[1]), tokens[0]);
                stocks.put(tokens[0], stock);
                observerList.put(stock, new ArrayList<Observer>());
            }
            System.out.println("Stock data read from file");
            System.out.println(stocks);

        } catch (FileNotFoundException fileNotFoundException){
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Error while reading the file");
        }
    }


    @Override
    public void addObserver(String stockName, Observer observer) {
        observerList.get(stocks.get(stockName)).add(observer);
        observer.setObservable(this);
    }

    @Override
    public void removeObserver(String stockName, Observer observer) {
        observerList.get(stocks.get(stockName)).remove(observer);
    }

    @Override
    public void notifyObserver(String stockName) {
        for(Observer observer : observerList.get(stocks.get(stockName))){
            observer.update(stocks.get(stockName));
        }
    }

    public Stock getState(String state) {
        return stocks.get(state);
    }

    public void incPrice(String stockName, double price){
        Stock stock = stocks.get(stockName);
        stock.setPrice(stock.getPrice() + price);
        notifyObserver(stockName);
    }

    public void decPrice(String stockName, double price){
        Stock stock = stocks.get(stockName);
        stock.setPrice(stock.getPrice() - price);
        notifyObserver(stockName);
    }

    public void setQuantity(String stockName, int quantity){
        stocks.get(stockName).setQuantity(quantity);
        notifyObserver(stockName);
    }

    public Collection<Stock> getStocks(){
        return stocks.values();
    }

}
