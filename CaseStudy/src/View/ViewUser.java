package View;

import Model.ManageStudent.ManageStudent;
import Model.ManageUser.ManageUser;
import Model.ManageUser.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewUser extends JFrame {
    ManageUser manageUser;
    ManageStudent manageStudent = new ManageStudent();
    private JTextField jTextFieldAccountName;
    private JPasswordField jPasswordField;
    public JPanel jPanelHead;
    public JPanel jPanelTail;
    public JButton jButtonLogin;
    public JButton jButtonRegister;

    public ViewUser() throws HeadlessException {
        this.manageUser = new ManageUser("");
        this.init();


    }
    private void init() {
        this.setTitle("Trang Chủ");
        this.setSize(500, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Arial", Font.BOLD, 30);
        Color foregroundColor = Color.BLACK;
        JLabel jLabelAccountName = new JLabel("Account Name");
        jLabelAccountName.setForeground(foregroundColor);
        jLabelAccountName.setFont(font);
        JLabel jLabelPassword = new JLabel("Password");
        jLabelPassword.setForeground(foregroundColor);
        jLabelPassword.setFont(font);

        jTextFieldAccountName = new JTextField(20);
        jTextFieldAccountName.setFont(font);
        jPasswordField = new JPasswordField(20);
        jPasswordField.setFont(font);

        jPanelHead = new JPanel();
        jPanelHead.setLayout(new GridLayout(2, 2, 50, 50));
        jPanelHead.add(jLabelAccountName);
        jPanelHead.add(jTextFieldAccountName);
        jPanelHead.add(jLabelPassword);
        jPanelHead.add(jPasswordField);

        jButtonLogin = new JButton("Login");
        jButtonLogin.setFont(font);
        jButtonRegister = new JButton("Register");
        jButtonRegister.setFont(font);

        jPanelTail = new JPanel();
        jPanelTail.setLayout(new GridLayout(1, 2, 10, 10));
        jPanelTail.add(jButtonLogin);
        jPanelTail.add(jButtonRegister);

        this.setLayout(new BorderLayout(10, 10));
        this.add(jPanelHead, BorderLayout.CENTER);
        this.add(jPanelTail, BorderLayout.SOUTH);
        jButtonRegister.addActionListener(new ActionListener() {
            ViewUseRegister viewUseRegister = new ViewUseRegister();

            public void  setViewUseRegister(ViewUseRegister viewUseRegister) {
                dispose();
                viewUseRegister.setVisible(true);
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                 setViewUseRegister(viewUseRegister);
            }
        });
    }
    public void addLoginListener(ActionListener listener) {
        jButtonLogin.addActionListener(listener);
    }
    public void addRegisterListener(ActionListener listener){
        jButtonRegister.addActionListener(listener);
    }
    public User getUser() {
        System.out.println(jTextFieldAccountName.getText()+""+jPasswordField.getPassword().toString());
        return new User(jTextFieldAccountName.getText(),
                String.copyValueOf(jPasswordField.getPassword()));
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
