package View;

import Model.ManageStudent.Student;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ViewStudenList extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    private static JButton addStudentBtn;
    private static JButton editStudentBtn;
    private static JButton deleteStudentBtn;
    private JButton clearBtn;
    private JButton sortStudentGPABtn;
    private JButton sortStudentNameBtn;
    private JScrollPane jScrollPaneStudentTable;
    private JScrollPane jScrollPaneAddress;
    private static JTable studentTable;

    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel addressLabel;
    private JLabel gpaLabel;
    private JButton logOut;
    private static JTextField idField;
    private static JTextField nameField;
    private static JTextField ageField;
    private static JTextArea addressTA;
    private static JTextField gpaField;

    // định nghĩa các cột của bảng student
    private static String[] columnNames = new String[]{
            "ID", "Name", "Age", "Address", "GPA"};
    // định nghĩa dữ liệu mặc định của bẳng student là rỗng
    private Object data = new Object[][]{};
    public JButton searchStudent;
    private JTextField searchField;

    public ViewStudenList() {
        this.initComponents();
    }

    private void initComponents() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng
        addStudentBtn = new JButton("Add");
        editStudentBtn = new JButton("Update");
        deleteStudentBtn = new JButton("remove");
        clearBtn = new JButton("Create");
        searchField = new JTextField(20);
        searchStudent = new JButton("Search Student By name");
        sortStudentGPABtn = new JButton("Sort by GPA");
        sortStudentNameBtn = new JButton("Sort by name");
        logOut = new JButton("Log Out");
        // khởi tạo bảng student
        jScrollPaneStudentTable = new JScrollPane();
        studentTable = new JTable();

        // khởi tạo các label
        idLabel = new JLabel("Id");
        nameLabel = new JLabel("Name");
        ageLabel = new JLabel("Age");
        addressLabel = new JLabel("Address");
        gpaLabel = new JLabel("GPA");

        // khởi tạo các trường nhập dữ liệu cho student
        idField = new JTextField(6);
        idField.setEditable(false);
        nameField = new JTextField(15);
        ageField = new JTextField(6);
        addressTA = new JTextArea();
        addressTA.setColumns(15);
        addressTA.setRows(5);
        jScrollPaneAddress = new JScrollPane();
        jScrollPaneAddress.setViewportView(addressTA);
        gpaField = new JTextField(6);

        // cài đặt các cột và data cho bảng student
        studentTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        jScrollPaneStudentTable.setViewportView(studentTable);
        jScrollPaneStudentTable.setPreferredSize(new Dimension(450, 300));

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Student
        JPanel panel = new JPanel();
        panel.setSize(800, 420);
        panel.setLayout(layout);
        panel.add(jScrollPaneStudentTable);

        panel.add(addStudentBtn);
        panel.add(editStudentBtn);
        panel.add(deleteStudentBtn);
        panel.add(clearBtn);
        panel.add(searchField);
        panel.add(searchStudent);
        panel.add(sortStudentGPABtn);
        panel.add(sortStudentNameBtn);
        panel.add(logOut);

        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(ageLabel);
        panel.add(addressLabel);
        panel.add(gpaLabel);

        panel.add(idField);
        panel.add(nameField);
        panel.add(ageField);
        panel.add(jScrollPaneAddress);
        panel.add(gpaField);

        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, gpaLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gpaLabel, 200, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageField, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneAddress, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneAddress, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, gpaField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gpaField, 200, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, jScrollPaneStudentTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneStudentTable, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addStudentBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addStudentBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editStudentBtn, 60, SpringLayout.WEST, addStudentBtn);
        layout.putConstraint(SpringLayout.NORTH, editStudentBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteStudentBtn, 60, SpringLayout.WEST, editStudentBtn);

        layout.putConstraint(SpringLayout.NORTH, clearBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 80, SpringLayout.WEST, deleteStudentBtn);

        layout.putConstraint(SpringLayout.NORTH, searchField, 270, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, searchField, -50, SpringLayout.WEST, deleteStudentBtn);

        layout.putConstraint(SpringLayout.NORTH, searchStudent, 300, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, searchStudent, -50, SpringLayout.WEST, deleteStudentBtn);

        layout.putConstraint(SpringLayout.NORTH, deleteStudentBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortStudentGPABtn, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortStudentGPABtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortStudentNameBtn, 115, SpringLayout.WEST, sortStudentGPABtn);
        layout.putConstraint(SpringLayout.NORTH, sortStudentNameBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, logOut, 600, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, logOut, 330, SpringLayout.NORTH, panel);
        this.add(panel);
        this.pack();
        this.setTitle("Student Information");
        this.setSize(800, 420);
        this.setLocationRelativeTo(null);
        // disable Edit and Delete buttons
        editStudentBtn.setEnabled(false);
        deleteStudentBtn.setEnabled(false);
        // enable Add button
        addStudentBtn.setEnabled(true);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * hiển thị list student vào bảng studentTable
     */
    public static void showListStudents(List<Student> list) {
        int size = list.size();
        // với bảng studentTable có 5 cột,
        // khởi tạo mảng 2 chiều students, trong đó:
        // số hàng: là kích thước của list student
        // số cột: là 5
        Object[][] students = new Object[size][5];
        for (int i = 0; i < size; i++) {
            students[i][0] = list.get(i).getId();
            students[i][1] = list.get(i).getName();
            students[i][2] = list.get(i).getAge();
            students[i][3] = list.get(i).getAddress();
            students[i][4] = list.get(i).getGpa();
        }
        studentTable.setModel(new DefaultTableModel(students, columnNames));
    }

    /**
     * điền thông tin của hàng được chọn từ bảng student
     * vào các trường tương ứng của student.
     */
    public void fillStudentFromSelectedRow() {
        // lấy chỉ số của hàng được chọn
        int row = studentTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(studentTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(studentTable.getModel().getValueAt(row, 1).toString());
            ageField.setText(studentTable.getModel().getValueAt(row, 2).toString());
            addressTA.setText(studentTable.getModel().getValueAt(row, 3).toString());
            gpaField.setText(studentTable.getModel().getValueAt(row, 4).toString());
            // enable Edit and Delete buttons
            editStudentBtn.setEnabled(true);
            deleteStudentBtn.setEnabled(true);
            // disable Add button
            addStudentBtn.setEnabled(false);
        }
    }

    /**
     * xóa thông tin student
     */
    public static void clearStudentInfo() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        addressTA.setText("");
        gpaField.setText("");
        // disable Edit and Delete buttons
        editStudentBtn.setEnabled(false);
        deleteStudentBtn.setEnabled(false);
        // enable Add button
        addStudentBtn.setEnabled(true);
    }

    /**
     * hiện thị thông tin student
     */
    public void showStudent(Student student) {
        idField.setText("" + student.getId());
        nameField.setText(student.getName());
        ageField.setText("" + student.getAge());
        addressTA.setText(student.getAddress());
        gpaField.setText("" + student.getGpa());
        // enable Edit and Delete buttons
        editStudentBtn.setEnabled(true);
        deleteStudentBtn.setEnabled(true);
        // disable Add button
        addStudentBtn.setEnabled(false);
    }

    /**
     * lấy thông tin student
     */
    public Student getStudentInfo() {
        // validate student
        if (!validateName() || !validateAge() || !validateAddress() || !validateGPA()) {
            return null;
        }
        try {
            Student student = new Student();
            if (idField.getText() != null && !"".equals(idField.getText())) {
                student.setId(Integer.parseInt(idField.getText()));
            }
            student.setName(nameField.getText().trim());
            student.setAge(Byte.parseByte(ageField.getText().trim()));
            student.setAddress(addressTA.getText().trim());
            student.setGpa(Float.parseFloat(gpaField.getText().trim()));
            return student;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    private boolean validateName() {
        String name = nameField.getText();
        if (name == null || "".equals(name.trim())) {
            nameField.requestFocus();
            showMessage("Name không đúng vui lòng nhập lại.");
            return false;
        }
        return true;
    }

    private boolean validateAddress() {
        String address = addressTA.getText();
        if (address == null || "".equals(address.trim())) {
            addressTA.requestFocus();
            showMessage("Address không được trống.");
            return false;
        }
        return true;
    }

    private boolean validateAge() {
        try {
            Byte age = Byte.parseByte(ageField.getText().trim());
            if (age < 15 || age > 40) {
                ageField.requestFocus();
                showMessage("Age không hợp lệ, age nên trong khoảng 15 đến 30.");
                return false;
            }
        } catch (Exception e) {
            ageField.requestFocus();
            showMessage("Age không hợp lệ!");
            return false;
        }
        return true;
    }

    private boolean validateGPA() {
        try {
            Float gpa = Float.parseFloat(gpaField.getText().trim());
            if (gpa < 0 || gpa > 10) {
                gpaField.requestFocus();
                showMessage("GPA không hợp lệ, gpa nên trong khoảng 0 đến 10.");
                return false;
            }
        } catch (Exception e) {
            gpaField.requestFocus();
            showMessage("GPA không hợp lệ!");
            return false;
        }
        return true;
    }
    public void addSearchListener(ActionListener listener) {
        searchStudent.addActionListener(listener);
    }

    public String getSearchKeyword() {
        return searchField.getText();
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void valueChanged(ListSelectionEvent e) {
    }

    public void addAddStudentListener(ActionListener listener) {
        addStudentBtn.addActionListener(listener);
    }

    public void addEdiStudentListener(ActionListener listener) {
        editStudentBtn.addActionListener(listener);
    }

    public void addDeleteStudentListener(ActionListener listener) {
        deleteStudentBtn.addActionListener(listener);
    }

    public void addClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }

    public void addSortStudentGPAListener(ActionListener listener) {
        sortStudentGPABtn.addActionListener(listener);
    }

    public void addSortStudentNameListener(ActionListener listener) {
        sortStudentNameBtn.addActionListener(listener);
    }
    public void addLogOut(ActionListener listener){logOut.addActionListener(listener);}

    public void addListStudentSelectionListener(ListSelectionListener listener) {
        studentTable.getSelectionModel().addListSelectionListener(listener);
    }
}