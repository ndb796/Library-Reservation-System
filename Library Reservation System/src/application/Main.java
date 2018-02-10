package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../user/userLogin.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("도서관 예약 시스템");
			primaryStage.setScene(scene);
			
			
			// primaryStage.initStyle(StageStyle.UNDECORATED);
			
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
