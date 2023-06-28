import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManageStudent manageStudent = new ManageStudent();
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("1. thêm học sinh");
            System.out.println("2. sửa học sinh theo id");
            System.out.println("3. xóa học sinh theo id");
            System.out.println("4. tìm kiếm học sinh theo id");
            System.out.println("5. in ra tất cả học sinh:");
            System.out.println("0. thoát khỏi chương trình:");
            System.out.println("nhập lựa chọn của bạn:");
            try {
                choice = sc.nextInt();
                sc.nextLine(); // Đọc dòng mới sau khi đọc số nguyên
                switch (choice) {
                    case 1:
                        manageStudent.addStudent();
                        break;
                    case 2:
                        System.out.println("Nhập id học sinh:");
                        int id = sc.nextInt();
                        sc.nextLine(); // Đọc dòng mới sau khi đọc số nguyên
                        manageStudent.editStudentById(id);
                        break;
                    case 3:
                        System.out.println("Nhập id học sinh muốn xóa:");
                        int id1 = sc.nextInt();
                        sc.nextLine(); // Đọc dòng mới sau khi đọc số nguyên
                        manageStudent.deleteStudentById(id1);
                        break;
                    case 4:
                        System.out.println("Nhập tên học sinh muốn tìm:");
                        String name = sc.nextLine();
                        manageStudent.searchStudentByName(name);
                        break;
                    case 5:
                        manageStudent.printAllStudents();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi. Vui lòng thử lại.");
                sc.nextLine(); // Đọc dòng mới để tránh lỗi lặp lại
            }
        }
    }
}
