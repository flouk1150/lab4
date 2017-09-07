import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    TableView<Table> tableID;

    @FXML
    TableColumn<Table,Integer> iID;

    @FXML
    TableColumn<Table,String> iName;

    @FXML
    TableColumn<Table,String> iDate;


    @FXML
    TableColumn<Table,String> iPlace;

    @FXML
    TableColumn<Table,String> iTime;

    @FXML
    protected Button button;

    @FXML
    protected Button button2;

    @FXML
    protected  TextField name;

    @FXML
    protected  TextField day;

    @FXML
    protected  TextField place;

    @FXML
    protected   TextField time;




    private int number = 1;

    ObservableList<Table> data = FXCollections.observableArrayList(

    );

    private IntegerProperty index = new SimpleIntegerProperty();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        index.set(-1);

        iID.setCellValueFactory(new PropertyValueFactory<Table,Integer>("rID"));
        iName.setCellValueFactory(new PropertyValueFactory<Table,String>("rName"));
        iDate.setCellValueFactory(new PropertyValueFactory<Table,String>("rDate"));
        iTime.setCellValueFactory(new PropertyValueFactory<Table, String>("rTime"));
        iPlace.setCellValueFactory(new PropertyValueFactory<Table,String>("rPlace"));

        tableID.setItems(data);

        tableID.setEditable(true);
        iName.setCellFactory(TextFieldTableCell.<Table>forTableColumn());
        iDate.setCellFactory(TextFieldTableCell.<Table>forTableColumn());
        iTime.setCellFactory(TextFieldTableCell.<Table>forTableColumn());
        iPlace.setCellFactory(TextFieldTableCell.<Table>forTableColumn());



        tableID.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {

                index.set(data.indexOf(newValue));



            }
        });

    }

    public void changeName(TableColumn.CellEditEvent edittedCell){
        Table t = tableID.getSelectionModel().getSelectedItem();
        t.setRName(edittedCell.getNewValue().toString());
    }

    public void changeDate(TableColumn.CellEditEvent edittedCell){
        Table t = tableID.getSelectionModel().getSelectedItem();
        t.setRDate(edittedCell.getNewValue().toString());
    }

    public void changeTime(TableColumn.CellEditEvent edittedCell){
        Table t = tableID.getSelectionModel().getSelectedItem();
        t.setrTime(edittedCell.getNewValue().toString());
    }

    public void changePlace(TableColumn.CellEditEvent edittedCell){
        Table t = tableID.getSelectionModel().getSelectedItem();
        t.setRPlace(edittedCell.getNewValue().toString());
    }

    static String testName = "";
    @FXML
    public void action(ActionEvent event){

        if (name.getText().equals("")||day.getText().equals("")||time.getText().equals("")||place.getText().equals("")){
            JOptionPane.showMessageDialog(null,"โปรดใส่ข้อมูลให้ครบ","คำเตือน",JOptionPane.WARNING_MESSAGE);
        }
        else{
            Table t = new Table(number,name.getText(),day.getText(),place.getText(),time.getText());
            testName = name.getText();
            System.out.println(test());
            number++;
            data.add(t);
            clearForm();

        }
    }
    public void clearForm(){
        name.clear();
        day.clear();
        place.clear();
        time.clear();
    }
    @FXML
    public void onDeleteItem(ActionEvent event){
        int i = index.get();
        if (i>-1){
            data.remove(i);
            tableID.getSelectionModel().clearSelection();
        }

    }
    public static String getTestName(){
        return testName;
    }
    public   static String test(){
        return testName;
    }

}

