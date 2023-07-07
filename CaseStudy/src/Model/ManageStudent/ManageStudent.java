package Model.ManageStudent;

import Controller.ActionLitenerLogin;
import View.ViewUser;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ManageStudent {
    private static List<Student> listStudents;

    public ManageStudent() {
        if (listStudents == null) {
            listStudents = new ArrayList<>();
            readStudentsFromFile();
        }
    }

    public void add(Student student) {
        int id = 1;
        if (listStudents != null && listStudents.size() > 0) {
            id = listStudents.size() + 1;
        }
        student.setId(id);
        listStudents.add(student);
        saveStudentsToFile();
    }

    public void edit(Student student) {
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            if (listStudents.get(i).getId() == student.getId()) {
                listStudents.get(i).setName(student.getName());
                listStudents.get(i).setAge(student.getAge());
                listStudents.get(i).setAddress(student.getAddress());
                listStudents.get(i).setGpa(student.getGpa());
                break;
            }
        }
        saveStudentsToFile();
    }

    public boolean delete(Student student) {
        boolean isFound = false;
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            if (listStudents.get(i).getId() == student.getId()) {
                student = listStudents.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listStudents.remove(student);
            saveStudentsToFile();
            return true;
        }
        return false;
    }

    public void sortStudentByName() {
        Collections.sort(listStudents, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                return student1.getName().compareTo(student2.getName());
            }
        });
        saveStudentsToFile();
    }

    public void logOut() {
        ViewUser view = new ViewUser();
        ActionLitenerLogin controller = new ActionLitenerLogin(view);
        controller.showLoginView();
    }

    public void sortStudentByGPA() {
        Collections.sort(listStudents, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                if (student1.getGpa() > student2.getGpa()) {
                    return 1;
                }
                return -1;
            }
        });
        saveStudentsToFile();
    }

    public List<Student> searchStudents(String keyword) {
        List<Student> result = new ArrayList<>();

        for (Student student : listStudents) {
            if (student.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(student);
            }
        }

        return result;
    }

    public static List<Student> getListStudents() {
        return listStudents;
    }

    private void readStudentsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("CaseStudy/src/Model/Student.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String address = data[3];
                double gpa = Double.parseDouble(data[4]);

                Student student = new Student(id, name, age, address, gpa);
                listStudents.add(student);
                System.out.println("Đọc file thành công !");
            }
        } catch (IOException e) {
            // hàm để đọc file
            System.out.println("Lỗi khi đọc không thể đọc file !");
            e.printStackTrace();
        }
    }

    private void saveStudentsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("CaseStudy/src/Model/Student.txt"))) {
            for (Student student : listStudents) {
                writer.write(student.getId() + "," + student.getName() + "," + student.getAge()
                        + "," + student.getAddress() + "," + student.getGpa());
                writer.newLine();
                System.out.println("Đã lưu thông tin vào file !");
            }
        } catch (IOException e) {
            // hàm để lưu file
            System.out.println("Lỗi khi lưu không thể lưu file !");
            e.printStackTrace();
        }
    }
}
