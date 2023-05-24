package bioskopku;

import controller.loginController;
import model.loginModel;
import view.loginView;

public class Main {
    public static void main(String[] args) {
        loginView loginView = new loginView();
        loginModel loginModel = new loginModel();
        loginController loginController = new loginController(loginModel, loginView);
    }
}
