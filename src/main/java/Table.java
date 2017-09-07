import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Table {

    private   SimpleIntegerProperty rID;
    private SimpleStringProperty rName;
    private   SimpleStringProperty rDate;
    private   SimpleStringProperty rPlace;
    private   SimpleStringProperty rTime;


    public Table(int sID, String sName, String sDate, String sPlace, String sTime){

        this.rID = new SimpleIntegerProperty(sID);
        this.rName = new SimpleStringProperty(sName);
        this.rDate = new SimpleStringProperty(sDate);
        this.rPlace = new SimpleStringProperty(sPlace);
        this.rTime = new SimpleStringProperty(sTime);
    }




    public int getRID() {
        return rID.get();
    }

    public String getRName() {
        return rName.get();
    }

    public String getRDate() {
        return rDate.get();
    }

    public String getRPlace() {
        return rPlace.get();
    }

    public String getRTime(){
        return rTime.get();
    }


    public  void setrTime(String v){

        this.rTime = new SimpleStringProperty(v);
    }
    public void setRID(int v) {
        rID.set(v);
    }

    public void setRName(String v) {

        this.rName = new SimpleStringProperty(v);
    }

    public void setRDate(String v) {

        this.rDate = new SimpleStringProperty(v);
    }

    public void setRPlace(String v) {

        this.rPlace = new SimpleStringProperty(v);
    }
}
