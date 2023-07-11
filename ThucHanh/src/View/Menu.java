package View;

import Model.ManageProduct;
import Model.Product;

import java.util.Scanner;

public class Menu {
    ManageProduct manageProduct = new ManageProduct();
    Scanner scNum = new Scanner(System.in);
    Scanner scStr = new Scanner(System.in);

    public void rumMain(){
        int choice;
        do {
            System.out.println("======Menu======\n" +
                    "1. Danh sách sản phẩm\n" +
                    "2. Thêm mới \n" +
                    "3. Cập nhật \n" +
                    "4. Xóa \n" +
                    "5. Sắp xếp\n" +
                    "6. Tìm sản phẩm có giá đắt nhất \n" +
                    "7. Đọc từ file \n" +
                    "8. Ghi vào file \n" +
                    "9. Thoát");
            System.out.println("Chọn chức năng:");
            choice = scNum.nextInt();
            switch (choice){
                case 1:
                    printAll();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    editProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    softPrice();
                    break;
                case 6:
                    searchMaxPrice();
                    break;
                case 7:
                    loadFile();
                    break;
                case 8:
                    saveFile();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("nhập lựa chọn sai vui lòng nhập lại !");
                    break;
            }
        }while (choice != 9);
    }
    public void printAll(){
        manageProduct.printAll();
    }
    public void addProduct(){
        System.out.println("Nhập vào id của sản phẩm !");
        int id = scNum.nextInt();
        System.out.println("nhập tên sản phẩm !");
        String nameProduct = scStr.nextLine();
        System.out.println("Nhập vào giá của sản phẩm !");
        float price = scNum.nextFloat();
        Product product = new Product(id,nameProduct,price);
        manageProduct.add(product);
    }
    public void editProduct(){
        System.out.println("Nhập vào id sản phẩm cần sửa !");
        int id = scNum.nextInt();
        System.out.println("Cập nhật id sản phẩm !");
        int id1 = scNum.nextInt();
        System.out.println("Cập nhật tên sản phẩm !");
        String nameProduct = scStr.nextLine();
        System.out.println("Cập nhật giá sản phẩm !");
        float price = scNum.nextFloat();
        Product product = new Product(id1,nameProduct,price);
        manageProduct.edit(id,product);
    }
    public void deleteProduct(){
        System.out.println("Nhập Id sản phẩm cần xóa !");
        int id = scNum.nextInt();
        manageProduct.delete(id);
    }
    public void softPrice(){
        manageProduct.softByPrice();
        System.out.println("Đã xắp xếp thành công giá từ cao đến thấp !");
    }
    public void searchMaxPrice(){
        manageProduct.SearchByMaxPrice();
    }
    public void saveFile(){
        manageProduct.saveFile();
    }
    public void loadFile(){
        manageProduct.loadFile();
    }
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.rumMain();
    }
}
