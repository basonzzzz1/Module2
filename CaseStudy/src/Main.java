
import Controller.ActionLitenerLogin;
import View.ViewUser;

import javax.swing.*;
import java.awt.EventQueue;
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                ViewUser view = new ViewUser();
                ActionLitenerLogin controller = new ActionLitenerLogin(view);
                // hiển thị màn hình login
                controller.showLoginView();
            }
        });
    }
    //chú ý ngày mai tạo sự kiện lắng nghe jtextFile cho ViewUseRegister
}