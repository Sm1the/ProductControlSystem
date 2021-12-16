package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    private static String TITLE_NAME = "Система Контроля Продукции";
    private static String VERSION_PROGRAM = "1.0.0";
    private static int WIDTH_WINDOW = 990;
    private static int HEIGHT_WINDOW = 590;

    Controller importMethods = new Controller();


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle(TITLE_NAME + " " + "["+"version" + " " + VERSION_PROGRAM+"]");
        primaryStage.setScene(new Scene(root, WIDTH_WINDOW, HEIGHT_WINDOW));
        //Отключение возможности расширять окно
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.show();
        importMethods.log("["+importMethods.date+"]"+"Запуск программы.");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
