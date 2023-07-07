package Controller;
import Model.ManageStudent.ManageStudent;
import Model.ManageStudent.Student;
import View.ViewStudenList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class ActionLitenerStudentList {
    private ManageStudent manageStudent;
    private ViewStudenList viewStudenList;
    public ActionLitenerStudentList(ViewStudenList view) {
        this.viewStudenList = view;
        manageStudent = new ManageStudent();

        view.addAddStudentListener(new AddStudentListener());
        view.addEdiStudentListener(new EditStudentListener());
        view.addDeleteStudentListener(new DeleteStudentListener());
        view.addClearListener(new ClearStudentListener());
        view.addSortStudentGPAListener(new SortStudentGPAListener());
        view.addSortStudentNameListener(new SortStudentNameListener());
        view.addListStudentSelectionListener(new ListStudentSelectionListener());
        view.addLogOut(new LogOutListener());
        view.addSearchListener(new SearchListener());
    }
    public void showStudentView() {
        List<Student> studentList = manageStudent.getListStudents();
        viewStudenList.setVisible(true);
        viewStudenList.showListStudents(studentList);
    }
    class AddStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = viewStudenList.getStudentInfo();
            if (student != null) {
                manageStudent.add(student);
                viewStudenList.showStudent(student);
                viewStudenList.showListStudents(manageStudent.getListStudents());
                viewStudenList.showMessage("Thêm thành công!");
            }
        }
    }
    class EditStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = viewStudenList.getStudentInfo();
            if (student != null) {
                manageStudent.edit(student);
                viewStudenList.showStudent(student);
                viewStudenList.showListStudents(manageStudent.getListStudents());
                viewStudenList.showMessage("Cập nhật thành công!");
            }
        }
    }
    class DeleteStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = viewStudenList.getStudentInfo();
            if (student != null) {
                manageStudent.delete(student);
                viewStudenList.clearStudentInfo();
                viewStudenList.showListStudents(manageStudent.getListStudents());
                viewStudenList.showMessage("Xóa thành công!");
            }
        }
    }
    class ClearStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ViewStudenList.clearStudentInfo();
        }
    }
    class SortStudentGPAListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            manageStudent.sortStudentByGPA();
            viewStudenList.showListStudents(ManageStudent.getListStudents());
        }
    }
    class SortStudentNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            manageStudent.sortStudentByName();
            viewStudenList.showListStudents(manageStudent.getListStudents());
        }
    }

    class LogOutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            viewStudenList.setVisible(false);
            manageStudent.logOut();
        }
    }
    class ListStudentSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            viewStudenList.fillStudentFromSelectedRow();
        }
    }
    class SearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String keyword = viewStudenList.getSearchKeyword();
                List<Student> searchResult = manageStudent.searchStudents(keyword);
                int id = searchResult.get(0).getId();
                String name = searchResult.get(0).getName();
                int age = searchResult.get(0).getAge();
                String address = searchResult.get(0).getAddress();
                double gpa = searchResult.get(0).getGpa();
                Student student = new Student(id, name, age, address, gpa);
                viewStudenList.showStudent(student);
            } catch (Exception ex) {
                viewStudenList.showMessage("Tìm kiếm thất bại !");
            }
        }
    }
}