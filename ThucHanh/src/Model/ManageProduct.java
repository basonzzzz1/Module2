package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ManageProduct {
    ArrayList<Product> productslist = new ArrayList<>();

    public ManageProduct() {
    }

    public void add(Product product) {
        productslist.add(product);
    }

    public void printAll() {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        int choice = 1;
        int count = 0;
        for(int i = 0;i<productslist.size();i++){
            count = 0;
            if(check == true){
                if(count < 5){
                    count += 1;
                    productslist.get(i).toString();
                }else{
                    System.out.println("có xác nhận hiển thị tiếp không!");

                }
            }
        }
    }

    public void edit(int id, Product product) {
        productslist.set(findIndexById(id), product);
    }

    public void delete(int id) {
        productslist.remove(findIndexById(id));
    }

//    public void softByPrice() {
//        Collections.sort(productslist, new Comparator<Product>() {
//            @Override
//            public int compare(Product product1, Product product2) {
//                if (product1.getPrice() < product2.getPrice()) {
//                    return 1;
//                }
//                return -1;
//            }
//        });
//    }
    public void softByPrice(){
        Collections.sort(productslist, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getPrice() < o2.getPrice()){
                    return 1;
                }
                return -1;
            }
        });
    }

    public float MaxPrice() {
        float max = 0;
        for (int i = 0; i < productslist.size(); i++) {
            if (productslist.get(i).getPrice() > max) {
                max = productslist.get(i).getPrice();
            }
        }
        return max;
    }

    public void SearchByMaxPrice() {
        for (int i = 0; i < productslist.size(); i++) {
            if (productslist.get(i).getPrice() == MaxPrice()) {
                System.out.println("Sản phẩm có giá đắt nhất là : " + productslist.get(i).toString());
            }
        }
    }

    public int findIndexById(int id) {
        for (int i = 0; i < productslist.size(); i++) {
            if (productslist.get(i).getIdProduct() == id) {
                return i;
            }
        }
        return -1;
    }
public void loadFile(){
        try(BufferedReader reader = new BufferedReader(new FileReader("ThucHanh/src/Product.txt"))){
            String line ;
            while ((line = reader.readLine()) != null){
                String []data = line.split(" , ");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                float price = Float.parseFloat(data[2]);
                Product product = new Product(id,name,price);
                productslist.add(product);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
}
public void saveFile(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("ThucHanh/src/Product.txt"))){
            for(Product product : productslist){
                writer.write(product.getIdProduct()+" , "+product.getNameProduct()+" , "+product.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
}
}
