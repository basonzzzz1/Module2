package View;

import Controller.ActionLitenerLogin;
import Model.ManageUser.ManageUser;
import Model.ManageUser.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewUseRegister extends JFrame {
    ActionListener actionListener;
    ManageUser manageUser ;
    public JTextField jTextFieldEmail;
    public JTextField jTextFieldPassword2;
    public JTextField jTextFieldPassword1;
    public JTextField jTextFieldAccountName;
    public JPanel jPanelTail;
    public JPanel jPanelhead;
    public JButton jButtonRegister;
    public JButton jButtonExit;

    public ViewUseRegister() throws HeadlessException {
        this.init();
    }

    private void init() {
        manageUser = new ManageUser("CaseStudy/src/Model/User.txt");
        this.setTitle("Register");
        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        Font font = new Font("Arial", Font.BOLD, 20);
        JLabel jLabelAccountName = new JLabel("Tên tài khoản");
        jLabelAccountName.setFont(font);
        jTextFieldAccountName = new JTextField();
        jTextFieldAccountName.setFont(font);
        jTextFieldAccountName.setText("");
        JLabel jLabelPasswordFirst = new JLabel("Mật khẩu");
        jLabelPasswordFirst.setFont(font);
        jTextFieldPassword1 = new JTextField();
        jTextFieldPassword1.setFont(font);
        jTextFieldPassword1.setText("");
        JLabel jLabelPasswordLast = new JLabel("Nhập lại mật khẩu");
        jLabelPasswordLast.setFont(font);
        jTextFieldPassword2 = new JTextField();
        jTextFieldPassword2.setFont(font);
        jTextFieldPassword2.setText("");
        JLabel jLabelEmail = new JLabel("Email");
        jLabelEmail.setFont(font);
        jTextFieldEmail = new JTextField();
        jTextFieldEmail.setFont(font);
        jTextFieldEmail.setText("");


        jPanelhead = new JPanel();
        jPanelhead.setLayout(new GridLayout(4, 4, 30, 30));
        jPanelhead.add(jLabelAccountName);
        jPanelhead.add(jTextFieldAccountName);
        jPanelhead.add(jLabelPasswordFirst);
        jPanelhead.add(jTextFieldPassword1);
        jPanelhead.add(jLabelPasswordLast);
        jPanelhead.add(jTextFieldPassword2);
        jPanelhead.add(jLabelEmail);
        jPanelhead.add(jTextFieldEmail);

        jButtonRegister = new JButton("Register");
        jButtonRegister.setFont(font);
        jButtonExit = new JButton("Exit");
        jButtonExit.setFont(font);
        jPanelTail = new JPanel();
        jPanelTail.setLayout(new GridLayout(1, 1, 10, 10));
        jPanelTail.add(jButtonRegister);
        jPanelTail.add(jButtonExit);


        this.add(jPanelhead, BorderLayout.CENTER);
        this.add(jPanelTail, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jButtonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountName = jTextFieldAccountName.getText();
                String password = jTextFieldPassword1.getText();
                String passwordFake = jTextFieldPassword2.getText();
                String email = jTextFieldEmail.getText();
                User user = new User(accountName, password);
                if (password.equals(passwordFake) && !(email.equals("")) && !(accountName.equals("")) && isValidEmail(email)
                && isValidPassWord(password) && isValidPassWord(passwordFake) && isValidName(accountName)) {
                    manageUser.addUser(user);
                    setVisible(false);
                    ViewUser view = new ViewUser();
                    ActionLitenerLogin controller = new ActionLitenerLogin(view);
                    controller.showLoginView();
                    showMessage("Đăng ký Thành công ! chuyển qua trang đăng nhập !");
                } else if (!(password.equals(passwordFake) )) {
                    showMessage("Mật khẩu không trùng nhau vui lòng nhập lại !");
                } else if (email.equals("")) {
                    showMessage("Bạn chưa nhập email vui lòng nhập email !");
                } else if (accountName.equals("")) {
                    showMessage("Tên đăng nhập không được để trống !");
                } else if(!(isValidName(accountName))){
                    showMessage("Tên Tài khoản không hợp lệ !");
                } else if(!(isValidPassWord(password))){
                    showMessage("Mật khẩu không hợp lệ !");
                } else if(!(isValidPassWord(passwordFake))){
                    showMessage("Mật khẩu không hợp lệ !");
                } else if(!(isValidEmail(email))){
                    showMessage("Email không hợp lệ !");
                }else {
                    showMessage("Ngoại lệ !");
                }
//                setVisible(false);
//                ViewUser view = new ViewUser();
//                ActionLitenerLogin controller = new ActionLitenerLogin(view);
//                controller.showLoginView();
            }
        });
        jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ViewUser view = new ViewUser();
                ActionLitenerLogin controller = new ActionLitenerLogin(view);
                controller.showLoginView();
            }
        });
    }
    public boolean isValidEmail(String email) {
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(EMAIL_REGEX);
    }
    public boolean isValidPassWord(String passWord) {
        String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
        return passWord.matches(PASSWORD_REGEX);
    }
    public boolean isValidName(String name) {
        String ACCOUNT_NAME_REGEX = "^[A-Za-z0-9_]+$";
        return name.matches(ACCOUNT_NAME_REGEX);
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
