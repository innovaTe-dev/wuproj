package FinalProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.collections.ObservableList;

public class Car {

    private String VIN = "";
    private String firstName = "";
    private String lastName = "";
    private String make = "";
    private String model = "";
    private int year = 0;

    public Car() {
    }

    public Car(String VIN, String firstName, String lastName, String make, String model, int year) {
        setVIN(VIN);
        setFName(firstName);
        setLName(lastName);
        setMake(make);
        setModel(model);
        setYear(year);
    }

    public String toString() {
        return "vin=" + getVIN() + ",firstName=" + getFName()
                + ",lastName=" + getLName() + ",make=" + getMake()
                + ",model=" + getModel() + ",year=" + getYear();
    }

    public void load(ObservableList<Car> data) {
        try {
            Scanner in = new Scanner(new File("carData.txt"));
            while (in.hasNext()) {
                String temp = in.nextLine();
                String[] fields = temp.split(",");
                Car c = new Car(fields[0], fields[1], fields[2], fields[3], fields[4], Integer.parseInt(fields[5]));
                System.out.println(c.toString());

                data.add(c);
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Unable to load data.");
        }
    }

    public void setVIN(String vin) {
        int check = 0;
        char[] errorchar = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int k = 0; k < vin.length(); k++) {
            check = vin.indexOf(errorchar[k]);
            if (check == -1) {
                VIN = vin;
            } else {
                throw new IllegalArgumentException("VIN numbers do not have lowercase letters");
            }
        }
    }

    public String getVIN() {
        return VIN;
    }

    public void setFName(String fName) {
        firstName = fName;
    }

    public String getFName() {
        return firstName;
    }

    public void setLName(String lName) {
        lastName = lName;
    }

    public String getLName() {
        return lastName;
    }

    public void setMake(String Make) {
        make = Make;
    }

    public String getMake() {
        return make;
    }

    public void setModel(String Model) {
        model = Model;
    }

    public String getModel() {
        return model;
    }

    public void setYear(int Year) {
        year = Year;
    }

    public  String getYearAsString() {
        return year+"";
    }
    public  int getYear() {
        return year;
    }
}
