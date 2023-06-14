package DonViSanXuat;

import java.util.Scanner;

public class ManageMent {
private CanBo[] canBos;
private int size;
private Scanner sc;

    public ManageMent(int capacity) {
        canBos = new CanBo[capacity];
        size = 0;
        sc = new Scanner(System.in);
    }
    public void addCanBo(){
        if(size == canBos.length){
            System.out.println("list is full. Cannot add more Can Bo.");
            return;
        }
        System.out.println("Enter Can Bo name:");
        String name = sc.nextLine();
        System.out.println("Enter Can Bo age:");
        int age = sc.nextInt();
        System.out.println("Enter Can Bo Gender:");
        sc.nextLine();
        String gender = sc.nextLine();
        System.out.println("Enter Can Bo Address:");
        String address = sc.nextLine();
        CanBo canBo = new CanBo(name,age,gender,address);
        canBos[size] = canBo;
        size++;
        System.out.println("Can Bo added successfully!");
    }
public void searchCanBo(){
    System.out.println("Enter Can Bo name to search:");
    String name = sc.nextLine();
    int index =findCanBoIndexByName(name);
    if(index != -1){
        CanBo canBo = canBos[index];
        System.out.println("Can bo found:");
        System.out.println("Can Bo name : "+canBo.getName());
        System.out.println("Can bo age : "+canBo.getAge());
        System.out.println("Can Bo gender : "+canBo.getGender());
        System.out.println("Can Bo address : "+canBo.getAddress());
    }else{
        System.out.println("Can Bo not found!");
    }
}
    public int findCanBoIndexByName(String name){
        for(int i = 0;i<size;i++){
         if(canBos[i].getName().equalsIgnoreCase(name)){
             return i;
         }
        }
        return -1;
    }
    public void printCanBoList(){
        if(size == 0 ){
            System.out.println("Can Bo list is empty");
        }else{
            System.out.println("Can Bo list:");
            for(int i = 0 ;i<size;i++){
                CanBo canBo = canBos[i];
                System.out.println("name: "+canBo.getName());
                System.out.println("age : "+canBo.getAge());
                System.out.println("gender :"+canBo.getGender());
                System.out.println("address : "+canBo.getAddress());
                System.out.println("-----------------------");
            }
        }
    }
    public void run() {
        boolean quit = false;
        while (!quit) {
            System.out.println("1. Add Can Bo");
            System.out.println("2. Search Can Bo");
            System.out.println("3. Print Can Bo list");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear the newline character from the input buffer

            switch (choice) {
                case 1:
                    addCanBo();
                    break;
                case 2:
                    searchCanBo();
                    break;
                case 3:
                    printCanBoList();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
        sc.close();
    }
}
