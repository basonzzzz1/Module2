package Model.ManageUser;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageUser {
    private ArrayList<User> usersList;
    private String filePath;

    public ManageUser(String filePath) {
        this.usersList = new ArrayList<>();
        this.filePath = filePath;
        loadUsersFromFile();
    }

    String accountAdmin = "admin";
    String passWordAdmin = "admin";
    User userAdmin = new User(accountAdmin, passWordAdmin);

    public void addUserAdmin() {
        usersList.add(userAdmin);
        saveUsersToFile();
    }

    public void addUser(User user) {
        usersList.add(user);
        saveUsersToFile();
        System.out.println(usersList.size());
    }

    public boolean checkUser(User user) {
        if (user != null) {
            for (User existingUser : usersList) {
                if (existingUser.getAccountName().equals(user.getAccountName())
                        && existingUser.getPassword().equals(user.getPassword())) {
                    return true;
                }
            }
        }
        System.out.println(usersList.toString());
        return false;
    }

    public void deleteAccount() {
        for (int i = 0; i < usersList.size(); i++) {
            usersList.remove(i);
            saveUsersToFile();
            System.out.println("xóa acc thành công !");
        }
    }

    private void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String accountName = parts[0].trim();
                    String password = parts[1].trim();
                    User user = new User(accountName, password);
                    usersList.add(user);
                    System.out.println("đọc file user thành công !");
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file ");
        }
    }

    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (User user : usersList) {
                String line = user.getAccountName() + "," + user.getPassword();
                writer.write(line);
                writer.newLine();
                System.out.println("ghi file user thành công !");
            }
        } catch (IOException e) {
            System.out.println(" lỗi ghi file user ! ");
        }
    }

    public void menuHide() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. delete All account \n" +
                    "2. add account admin !");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    deleteAccount();
                    break;
                case 2:
                    addUserAdmin();
                    System.out.println("đã add thành công tài khoản admin !");
                default:
                    System.out.println("nhập lựa chọn sai !");
            }
            choice = sc.nextInt();
        } while (choice != 0);
    }

    public static void main(String[] args) {
        ManageUser manageUser = new ManageUser("CaseStudy/src/Model/User.txt");
        manageUser.menuHide();
    }
}
