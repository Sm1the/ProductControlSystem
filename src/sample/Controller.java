package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Controller {

    public Date date = new Date();
    public ScrollPane scrollPane;
    public ScrollPane scrollPaneadd;
    public TextField userLoginText;
    public TextField userPasswordText;
    String userTextlog;
    String userTextpass;
    public JFrame frame = new JFrame();


    public ObservableList<TableDataBase> usersData = FXCollections.observableArrayList();
    public TableView<TableDataBase> tabledb;
    public TableColumn<TableDataBase, Integer> tableId;
    public TableColumn<TableDataBase, String> tableName;
    public TableColumn<TableDataBase, Integer> tableCount;
    public TableColumn<TableDataBase, String> tableStatus;
    public TableColumn<TableDataBase, String> tablePerson;

    public void initialize() {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        tableId.setCellValueFactory(new PropertyValueFactory<TableDataBase, Integer>("id"));
        tableName.setCellValueFactory(new PropertyValueFactory<TableDataBase, String>("name"));
        tableCount.setCellValueFactory(new PropertyValueFactory<TableDataBase, Integer>("count"));
        tableStatus.setCellValueFactory(new PropertyValueFactory<TableDataBase, String>("status"));
        tablePerson.setCellValueFactory(new PropertyValueFactory<TableDataBase, String>("person"));

        // заполняем таблицу данными
        tabledb.setItems(usersData);
    }

    private void initData() {

        usersData.add(new TableDataBase(1,"СтройМатериалы",10,"На складе","ФИО"));
        usersData.add(new TableDataBase(2,"СтройМатериалы",10,"В пути","ФИО"));
        usersData.add(new TableDataBase(3,"СтройМатериалы",10,"В пути","ФИО"));
        usersData.add(new TableDataBase(4,"СтройМатериалы",10,"В пути","ФИО"));
        usersData.add(new TableDataBase(5,"СтройМатериалы",10,"В пути","ФИО"));
        usersData.add(new TableDataBase(6,"СтройМатериалы",10,"Отсутствует","ФИО"));
        usersData.add(new TableDataBase(7,"СтройМатериалы",10,"На складе","ФИО"));
        usersData.add(new TableDataBase(8,"СтройМатериалы",10,"На складе","ФИО"));
        usersData.add(new TableDataBase(9,"СтройМатериалы",10,"В пути","ФИО"));
        usersData.add(new TableDataBase(10,"СтройМатериалы",10,"В пути","ФИО"));
        usersData.add(new TableDataBase(11,"СтройМатериалы",10,"В пути","ФИО"));
        usersData.add(new TableDataBase(12,"СтройМатериалы",10,"В пути","ФИО"));
        usersData.add(new TableDataBase(13,"СтройМатериалы",10,"Отсутствует","ФИО"));
        usersData.add(new TableDataBase(14,"СтройМатериалы",10,"Отсутствует","ФИО"));
        usersData.add(new TableDataBase(15,"СтройМатериалы",10,"Отсутствует","ФИО"));

    }

    public void inLogin(){
        userTextlog = userLoginText.getText();
        userTextpass = userPasswordText.getText();
        System.out.print(userTextlog+userTextpass);
        scrollPane.setDisable(true);
        scrollPane.setVisible(false);
        log("["+date+"]"+"Пользователь авторизировался в PCS.");
        //JOptionPane.showMessageDialog(frame, "Вы успешно вошли в PCS!");

    }

    public void userOut(){
        scrollPane.setDisable(false);
        scrollPane.setVisible(true);
        log("["+date+"]"+"Пользователь вышел из PCS.");
    }

    public void exportTxt(){
        //
        log("["+date+"]"+"Экспорт таблицы в текстовый файл.");
        ArrayList<String> getTable = new ArrayList<>();
        getTable.add(usersData+"\n");
        String exportTxt = String.valueOf(getTable);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/sample/Table.txt",false))){
            writer.write(exportTxt);
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        File exportTxtFile = new File("src/sample/Table.txt");
        Desktop desktop = null;
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }try {
            desktop.open(exportTxtFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public void exportHtml(){
        log("["+date+"]"+"Экспорт таблицы в файл HTML.");
        ArrayList<ObservableList<TableDataBase>> getTable = new ArrayList<>();
        getTable.add(usersData);
        String exportHtml= String.valueOf(getTable);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/sample/Table.html",false))){
            writer.write(exportHtml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File exportHtmlFile = new File("src/sample/Table.html");
        Desktop desktop = null;
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }try {
            desktop.open(exportHtmlFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void tableAdd(){
        log("["+date+"]"+"Добавление данных в таблицу.");
        scrollPaneadd.setVisible(true);
        scrollPaneadd.setDisable(false);
    }

    public void tableDelete(){
        log("["+date+"]"+"Удаление из таблицы данных.");
        scrollPaneadd.setVisible(true);
        scrollPaneadd.setDisable(false);
    }

    public void backAdd(){
        scrollPaneadd.setVisible(false);
        scrollPaneadd.setDisable(true);
    }

    public void Guide(){
        //Открывает Help.html
        File Help = new File("src/sample/Help.html");
        Desktop desktop = null;

        if (Desktop.isDesktopSupported()) {
        desktop = Desktop.getDesktop();
    }try {
        desktop.open(Help);
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
    //Лог
    log("["+date+"]"+"Просмотр инструкции.");
}

    public void checkLogs(){
        log("["+date+"]"+"Просмотр файла логирования.");
        File log = new File("src/log/log.dat");
        Desktop desktop = null;

        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }try {
            desktop.open(log);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    //Система логирования
    public void log(String log){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/log/log.dat",true))){
            writer.write(log);
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
