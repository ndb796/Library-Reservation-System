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
			alert.setTitle("오류 메시지");
			alert.setHeaderText("오류가 발생했습니다.");
			alert.setContentText("아이디 혹은 비밀번호는 빈 공간일 수 없습니다.");
			alert.showAndWait();
			return;
		}
		UserDAO userDAO = new UserDAO();
		int result = userDAO.login(userID, userPassword);
		if(result == 1) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("성공 메시지");
			alert.setHeaderText("성공 메시지입니다.");
			alert.setContentText("로그인에 성공했습니다.");
			alert.showAndWait();
			return;
		} else if (result == 0) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("오류 메시지");
			alert.setHeaderText("오류가 발생했습니다.");
			alert.setContentText("비밀번호가 틀립니다.");
			alert.showAndWait();
			return;
		} else if (result == -1) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("오류 메시지");
			alert.setHeaderText("오류가 발생했습니다.");
			alert.setContentText("존재하지 않는 아이디입니다.");
			alert.showAndWait();
			return;
		} else if (result == -2) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("오류 메시지");
			alert.setHeaderText("오류가 발생했습니다.");
			alert.setContentText("데이터베이스 오류가 발생했습니다.");
			alert.showAndWait();
			return;
		}
	}
	
	public void joinButtonAction(ActionEvent event) {
		
	}

}
