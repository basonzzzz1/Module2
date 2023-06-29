import java.io.*;

public class FileIOExample {
    // Phương thức để ghi dữ liệu vào tệp văn bản
    public static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("Ghi dữ liệu vào tệp thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi ghi dữ liệu vào tệp: " + e.getMessage());
        }
    }

    // Phương thức để đọc nội dung từ tệp văn bản
    public static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc nội dung từ tệp: " + e.getMessage());
        }
    }

    // Phương thức để kiểm tra sự tồn tại của tệp
    public static void checkFileExists(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("Tệp tồn tại.");
        } else {
            System.out.println("Tệp không tồn tại.");
        }
    }

    // Phương thức để xóa tệp
    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println("Xóa tệp thành công.");
        } else {
            System.out.println("Không thể xóa tệp.");
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("AllFile/src/example.txt");
        file.createNewFile();

        String filePath = "AllFile/src/example.txt";
        String content = "Hello, World!\nThis is a sample file.";

        // Ghi dữ liệu vào tệp văn bản
        writeFile(filePath, content);

        // Đọc nội dung từ tệp văn bản
        System.out.println("Nội dung của tệp:");
        readFile(filePath);

        // Kiểm tra sự tồn tại của tệp
        checkFileExists(filePath);

        // Xóa tệp
//        deleteFile(filePath);

        // Kiểm tra lại sự tồn tại của tệp sau khi xóa
        checkFileExists(filePath);
    }
}
