import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class ManageStudent {
    Scanner sc = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    ArrayList<Student> studentsList;
    static String data = "";

    public ManageStudent() {
        this.studentsList = new ArrayList<>();
        loadDataFromFile(); // Load dữ liệu từ tệp khi khởi tạo lớp ManageStudent
    }
    // hàm kiểm tra xem id có trùng lặp hay không
    private boolean isIdDuplicate(int id) {
        for (Student student : studentsList) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public void addStudent() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Nhập ID của học sinh:");
                int id = sc.nextInt();
                // Kiểm tra trùng lặp ID
                if (isIdDuplicate(id)) {
                    System.out.println("ID đã tồn tại. Không thể thêm học sinh.");
                    return;
                }
                sc.nextLine(); // Đọc bỏ dòng new line
                System.out.println("Nhập tên học sinh:");
                String name = inputString.nextLine();
                System.out.println("Nhập tuổi học sinh:");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.println("Nhập địa chỉ học sinh:");
                String address = inputString.nextLine();
                Student student = new Student(id, name, age, address);
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Student/src/students.txt"))) {
                    data += id + " , " + name + " , " + age + " , " + address + "\n";
                    writer.write(data);
                } catch (IOException e) {
                    System.out.println("Đã xảy ra lỗi khi ghi vào tệp tin.");
                    e.printStackTrace();
                }
                studentsList.add(student);
                System.out.println("Thêm học sinh thành công!");
                validInput = true; // Kết thúc vòng lặp
            } catch (InputMismatchException e) {
                System.out.println("Đã xảy ra lỗi khi nhập dữ liệu. Vui lòng thử lại.");
                sc.nextLine(); // Đọc bỏ dòng new line
            }
        }
    }
    public void editStudentById(int id) {
        try {
            boolean found = false;
            for (int i = 0; i < studentsList.size(); i++) {
                if (studentsList.get(i).getId() == id) {
                    found = true;
                    System.out.println("Sửa tên cho học sinh thứ " + (i + 1));
                    String name = inputString.nextLine();
                    System.out.println("Sửa tuổi học sinh thứ " + (i + 1));
                    int age = sc.nextInt();
                    System.out.println("Sửa địa chỉ của học sinh thứ " + (i + 1));
                    String address = inputString.nextLine();
                    studentsList.get(i).setName(name);
                    studentsList.get(i).setAge(age);
                    studentsList.get(i).setAddress(address);

                    saveDataToFile(); // Lưu dữ liệu vào tệp sau khi chỉnh sửa thông tin học sinh
                    System.out.println("Sửa thông tin học sinh thành công!");
                    break;
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy học sinh có ID = " + id);
            }
        } catch (InputMismatchException e) {
            System.out.println("Đã xảy ra lỗi khi nhập dữ liệu: ");
        }
    }
    public void deleteStudentById(int id) {
        boolean found = false;
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getId() == id) {
                found = true;
                studentsList.remove(i);
                saveDataToFile(); // Lưu dữ liệu vào tệp sau khi xóa học sinh
                System.out.println("Xóa học sinh thành công!");
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy học sinh có ID = " + id);
        }
    }
    public void searchStudentByName(String name) {
        boolean found = false;
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getName().equals(name)) {
                found = true;
                System.out.println(studentsList.get(i).toString());
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy học sinh có tên = " + name);
        }
    }
    public void printAllStudents() {
        for (int i = 0; i < studentsList.size(); i++) {
            System.out.println(studentsList.get(i).toString());
        }
    }
    private void loadDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Student/src/students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] studentData = line.split(" , ");
                int id = Integer.parseInt(studentData[0]);
                String name = studentData[1];
                int age = Integer.parseInt(studentData[2]);
                String address = studentData[3];
                Student student = new Student(id, name, age, address);
                studentsList.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void saveDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Student/src/students.txt"))) {
            for (Student student : studentsList) {
                String studentData = student.getId() + " , " + student.getName() + " , " + student.getAge() + " , " + student.getAddress();
                writer.write(studentData);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
