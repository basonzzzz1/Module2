package Controller;

import Model.ManageUser.ManageUser;
import Model.ManageUser.User;
import View.ViewStudenList;
import View.ViewUseRegister;
import View.ViewUser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionLitenerLogin {
    private ManageUser manageUser;
    private ViewUser viewUser;
    private ViewStudenList viewStudenList;

    public ActionLitenerLogin(ViewUser view) {
        this.viewUser = view;
        manageUser = new ManageUser("CaseStudy/src/Model/User.txt");
        view.addLoginListener(new LoginListener());
    }

    public void showLoginView() {
        viewUser.setVisible(true);
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User user = viewUser.getUser();
            String button = e.getActionCommand();
            if (manageUser.checkUser(user)) {
                viewStudenList = new ViewStudenList();
                ActionLitenerStudentList actionLitenerStudentList = new ActionLitenerStudentList(viewStudenList);
                actionLitenerStudentList.showStudentView();
                viewUser.setVisible(false);
            } else {
                viewUser.showMessage("username hoặc password không đúng.");
            }
        }

    }
}
