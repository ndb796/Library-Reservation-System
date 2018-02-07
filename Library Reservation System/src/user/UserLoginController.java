package user;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class UserLoginController implements Initializable {

	@FXML private Button loginButton;
	@FXML private Button joinButton;
	@FXML private TextField userID;
	@FXML private PasswordField userPassword;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loginButton.setOnAction(event->loginButtonAction(event));
		joinButton.setOnAction(event->joinButtonAction(event));
	}
	
	public void loginButtonAction(ActionEvent event) {
		String userID = this.userID.getText();
		String userPassword = this.userPassword.getText();
		if(userID == null || userPassword == null ||
		   userID.equals("") || userPassword.equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("���� �޽���");
			alert.setHeaderText("������ �߻��߽��ϴ�.");
			alert.setContentText("���̵� Ȥ�� ��й�ȣ�� �� ������ �� �����ϴ�.");
			alert.showAndWait();
			return;
		}
		UserDAO userDAO = new UserDAO();
		int result = userDAO.login(userID, userPassword);
		if(result == 1) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("���� �޽���");
			alert.setHeaderText("���� �޽����Դϴ�.");
			alert.setContentText("�α��ο� �����߽��ϴ�.");
			alert.showAndWait();
			return;
		} else if (result == 0) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("���� �޽���");
			alert.setHeaderText("������ �߻��߽��ϴ�.");
			alert.setContentText("��й�ȣ�� Ʋ���ϴ�.");
			alert.showAndWait();
			return;
		} else if (result == -1) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("���� �޽���");
			alert.setHeaderText("������ �߻��߽��ϴ�.");
			alert.setContentText("�������� �ʴ� ���̵��Դϴ�.");
			alert.showAndWait();
			return;
		} else if (result == -2) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("���� �޽���");
			alert.setHeaderText("������ �߻��߽��ϴ�.");
			alert.setContentText("�����ͺ��̽� ������ �߻��߽��ϴ�.");
			alert.showAndWait();
			return;
		}
	}
	
	public void joinButtonAction(ActionEvent event) {
		
	}

}
