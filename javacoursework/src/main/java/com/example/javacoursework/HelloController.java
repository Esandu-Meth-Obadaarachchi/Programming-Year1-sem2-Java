package com.example.javacoursework;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.io.*;
import java.util.*;

public class HelloController{

    @FXML
    private Button uddDeleteButton;

    @FXML
    private Button loadingRaceButton;

    @FXML
    private Button startButton;

    @FXML
    private Button addSaveForUdd;

    @FXML
    private Button vctExitButton;

    @FXML
    private Button loadDriverVctButton;

    @FXML
    private Button loadTableUdd;

    @FXML
    private Button loadTableDdd;
    @FXML
    private Label savedLabel;


    @FXML
    private Label availabilityLabel;
    @FXML
    private Label idVarifyLabel;
    @FXML
    private Label nameVarifyLabel;

    @FXML
    private Label pointsVarifyLabel;
    @FXML
    private Label ageVarifyLabel;
    @FXML
    private Label teamVarifyLabel;
    @FXML
    private Label carVarifyLabel;

    @FXML
    private TextField driverIdInput;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField pointsInput;

    @FXML
    private TextField ageInput;

    @FXML
    private TextField teamInput;

    @FXML
    private TextField carInput;

    @FXML
    private TextField idDeleteInput;

    @FXML
    private Label dateOutputLabel;

    @FXML
    private Label firstOutputLabel;

    @FXML
    private Label locationOutputLabel;

    @FXML
    private Label secondOutputLabel;

    @FXML
    private Button srrExitButton;

    @FXML
    private Label thirdOutputLabel;

    @FXML
    private Button loadRaceVrlButton;

    @FXML
    private TableColumn<Driver, Integer> driverIDCol;

    @FXML
    private TableColumn<Driver, String> nameCol;

    @FXML
    private TableColumn<Driver, Integer> pointsCol;
    @FXML
    private TableColumn<Driver, Integer> ageCol;

    @FXML
    private TableColumn<Driver, String> carCol;
    @FXML
    private TableColumn<Driver, String> teamCol;

    @FXML
    private TableView<Driver> standingTable;



    @FXML
    private TableColumn<Race, String> colOne;

    @FXML
    private TableColumn<Race, String> colThree;

    @FXML
    private TableColumn<Race, String> colTwo;

    @FXML
    private TableColumn<Race, String> dateCol;


    @FXML
    private TableColumn<Race, String> locationCol;

    @FXML
    private TableView<Race> raceTable;




    Integer idToDelete;
    int driverID;
    String name;
    int points;
    int age;
    String team;
    String car;

    String date;
    String location;
    String firstPlace;
    String secondPlace;
    String thirdPlace;

    String otherDrivers;

    String [] driverInfo;

    String [] raceInfo;

    Boolean driverFound;

    String messageToDisplay;

    public ArrayList<Driver> drivers = new ArrayList<>();
    public ArrayList<Race> races = new ArrayList<>();
    public ArrayList<String> driverList = new ArrayList<>();

    List<String> assignedDrivers = new ArrayList<>();


    public void addingToDriverList() {  //each driver object is selected and added to driverList list separated by "/"
        for (Driver d : drivers) {
            driverList.add(d.getDriverID() + "/" +d.getName() + "/" + d.getAge() +"/"+ d.getPoints() +"/" + d.getCar() + "/" + d.getTeam());
        }
    }

   public void mainPageTable(){

        driverIDCol.setCellValueFactory(new PropertyValueFactory<Driver,Integer>("driverID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Driver,String>("name"));
        pointsCol.setCellValueFactory(new PropertyValueFactory<Driver,Integer>("points"));
        ageCol.setCellValueFactory(new PropertyValueFactory<Driver,Integer>("age"));
        carCol.setCellValueFactory(new PropertyValueFactory<Driver,String>("car"));
        teamCol.setCellValueFactory(new PropertyValueFactory<Driver,String>("team"));
        ObservableList<Driver> data = FXCollections.observableArrayList();
        data.addAll(drivers);
        standingTable.setItems(data);
    }

    public void onStartButtonClick(ActionEvent event){
        RFF();
        mainPageTable();
        startButton.setDisable(true);
    }
    //================================================================================================================================
    public boolean isNameValid(String name){

        //we check if the name empty or null
        if (name.equals("")){
            return false;
        }
        return true;
    }

    public boolean isAgeValid(String age){
        //we check if the age empty or null
        if (age == null || age.equals("")){
            messageToDisplay = "age can not be empty,pls enter";
            return false;
        }else{
            //for each character in age string
            for (int i = 0; i < age.length(); i++) {
                //if a character is not a digit
                if (!Character.isDigit(age.charAt(i))) {
                    messageToDisplay = "INVALID AGE, please enter a valid integer";
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPointsValid(String points){
        //we check if the points empty or null
        if (points == null || points.equals("")){
            messageToDisplay = "Points can not be empty,pls enter";
            return false;
        }else{
            //for each character in points string
            for (int i = 0; i < points.length(); i++) {
                //if a character is not a digit
                if (!Character.isDigit(points.charAt(i))) {
                    messageToDisplay = "INVALID POINTS, please enter a valid integer";
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isCarValid(String car){
        //we check if the car empty null
        if (car == null || car.equals("")){
            return false;
        }
        return true;
    }

    public boolean isTeamValid(String team){
        //we check if the team empty and null
        if (team == null || team.equals("")){
            return false;
        }
        return true;
    }
    public boolean isDriverIDValid(String id){
        if(id == null || id.equals("")){
            messageToDisplay = "driverID cant be empty";
            return false;
        }

        for (int i = 0; i < id.length(); i++) {
            //if a character is not a digit
            if (!Character.isDigit(id.charAt(i))) {
                messageToDisplay = "INVALID ID, please enter a valid integer";
                return false;
            }
        }

        for (String driver : driverList) {  //checking from all the previous drivers whether the driverID exits
            if (driver.split("/")[0].equals(id)) {
                messageToDisplay = "That Driver ID is already taken";//if ID is present a message is shown
                return false;
            }
        }

        return true;
    }

    public void addingDrivers() {
        drivers.clear();
        RFF();
        addingToDriverList(); //adds all the driver objects as string to the list
        System.out.println(driverList);
        boolean inputsCorrect = true;

        //getting ID
        if(!isDriverIDValid(driverIdInput.getText())){
            idVarifyLabel.setText(messageToDisplay);
            inputsCorrect = false;
        }
        else {
            driverID = Integer.parseInt(driverIdInput.getText());//getting the points input to the variable
        }

        //getting name and checking
        String name = nameInput.getText();
        if (!isNameValid(name)){
            nameVarifyLabel.setText("Name cannot be empty,pls enter");
            inputsCorrect = false;
        }

        //getting points and checking
        if(!isPointsValid(pointsInput.getText())){
            pointsVarifyLabel.setText(messageToDisplay);
            inputsCorrect = false;
        }
        else {
            points = Integer.parseInt(pointsInput.getText());//getting the points input to the variable
        }

        //getting age and checking
        if (!isAgeValid(ageInput.getText())) { // check if age is valid
            ageVarifyLabel.setText(messageToDisplay);
            inputsCorrect = false;
        } else {
            age = Integer.parseInt(ageInput.getText());//getting the age input to the variable
        }

        //getting car and checking
        String car = carInput.getText();
        if (!isCarValid(carInput.getText())) { // check if car is valid
            carVarifyLabel.setText("Car cannot be empty,pls enter");
            inputsCorrect = false;
        }

        //getting team and checking
        String team = teamInput.getText();
        if (!isTeamValid(team)) { // check if team is valid
            teamVarifyLabel.setText("team cannot be empty,pls enter");
            inputsCorrect = false;
        }


        if (inputsCorrect) { //if all the inputs are correct then only the inputsCorrect will be true
            driverIdInput.clear();
            nameInput.clear();
            pointsInput.clear();
            ageInput.clear();
            carInput.clear();
            teamInput.clear();
            idVarifyLabel.setText("");
            nameVarifyLabel.setText("");
            pointsVarifyLabel.setText("");
            ageVarifyLabel.setText("");
            teamVarifyLabel.setText("");
            carVarifyLabel.setText("");
            Driver newDriver = new Driver(driverID, name, age, points, car, team);//if correct only the driver object will be created
            drivers.add(newDriver); //adding to the driver object arraylist
            savedLabel.setText("Driver saved");
            driverList.clear();
        }
    }
//=================================================================================================================================================
    public boolean isIdToDeleteValid(String idToDelete){
        if (idToDelete == null || idToDelete.equals("")){
            return false;
        }else{
            //for each character in idToDelete string
            for (int i = 0; i < idToDelete.length(); i++) {
                //checking whether all are digits, no letters
                if (!Character.isDigit(idToDelete.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void deletingDrivers() throws IOException {
        driverFound = false; //this is used when the driver is being updated, not needed when deleted
        drivers.clear();    //the driver object list is cleared as all will be added again while deleting a driver
        boolean inputIsValid = true;

        if(!isIdToDeleteValid(idDeleteInput.getText())){
            availabilityLabel.setText("Invalid input for the ID to delete.");
            inputIsValid = false;
        }
        if(inputIsValid){
            idToDelete = Integer.parseInt(idDeleteInput.getText()); //getting the user input for the id to delete
            File file = new File("playerData.txt");
            if (file.exists()) {
                FileReader fr = new FileReader(file); //gets all the data in the file
                BufferedReader br = new BufferedReader(fr); //reading each line
                String driverRecord;
                boolean found = false;
                while ((driverRecord = br.readLine()) != null) { //each driver record is assigned to line variable and checked
                    driverInfo = driverRecord.split("/"); //splitting by slash to get each component
                    driverID = Integer.parseInt(driverInfo[0]);
                    name = driverInfo[1];
                    age = Integer.parseInt(driverInfo[2]);
                    points = Integer.parseInt(driverInfo[3]);
                    car = driverInfo[4];
                    team = driverInfo[5];

                    if (driverID == idToDelete) { //if the driver id of that driver = to id to delete
                        found = true;       //the driver is not added if the driver is found
                        driverFound=true;

                    } else {    // if not found then the object is created and put back
                        Driver driver = new Driver(driverID, name, age, points, team, car);
                        drivers.add(driver);
                    }

                }
                fr.close();
                br.close();
                if (found) { //giving message whether driver found to delete or not
                    availabilityLabel.setText("The driver was found");

                } else {
                    availabilityLabel.setText("The driver was not found");
                }

                //all the drivers are then written back to the text file after removing that driver.
                //existing data is overwritten
                FileWriter fw = new FileWriter("playerData.txt",false);
                for (Driver driver : drivers) {
                    fw.write(driver.getDriverID() + "/" + driver.getName() + "/" + driver.getAge() + "/" + driver.getPoints() + "/" + driver.getCar() + "/" + driver.getTeam() + "\n");
                }
                fw.close();
            }
        }

    }
    //================================================================================================================================================
    public void STF() {
        try {
            FileWriter fw = new FileWriter("playerData.txt", false); //the file is opened to write when data is appended.
            for (Driver driver : drivers) { // each driver in the driver objects arraylist is selected using the loop.
                fw.write(driver.getDriverID() + "/" + driver.getName() + "/" + driver.getAge() + "/" + driver.getPoints() + "/" + driver.getCar() + "/" + driver.getTeam() + "\n");
            }
            fw.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void STFRaces(){
        try {
            FileWriter fw = new FileWriter("races.txt" ,false);
            for (Race race : races) {
                fw.write(race.getDate() + "*" + race.getLocation() + "*" + race.getFirstPlace() + "//" + race.getSecondPlace() + "//" + race.getThirdPlace() + "//" + race.getOtherDrivers()+"\n");
            }
            fw.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    //==============================================================================================================================================
    public void RFF() {
        try {
            File file = new File("playerData.txt");
            if (file.exists()) {
                FileReader fr = new FileReader(file);   //file reader gets the whole text from text file
                BufferedReader br = new BufferedReader(fr);  //that s why buffered reader is used to select each line
                String aDriver;

                while ((aDriver = br.readLine()) != null) {       //continuing until the next line is not there, empty
                    driverInfo = aDriver.split("/");       // putting the driver details to an array by splitting
                    driverID = Integer.parseInt(driverInfo[0]);
                    name = driverInfo[1];
                    age = Integer.parseInt(driverInfo[2]);
                    points = Integer.parseInt(driverInfo[3]);
                    car = driverInfo[4];
                    team = driverInfo[5];
                    Driver driver = new Driver(driverID, name, age, points, car, team); //creating the object
                    drivers.add(driver);        //adding the new driver to the driver class objects array
                }
                br.close();
                fr.close();
                System.out.println("rff works");

            } else {
                System.out.println("File does not exist.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void RFFRaces() {
        try {
            File file = new File("races.txt");
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String aRace;

                while ((aRace = br.readLine()) != null) {
                    raceInfo = aRace.split("\\*");
                    date = raceInfo[0];
                    location = raceInfo[1];
                    firstPlace = raceInfo[2].split("//")[0];
                    secondPlace = raceInfo[2].split("//")[1];
                    thirdPlace = raceInfo[2].split("//")[2];
                    otherDrivers = raceInfo[2].split("//")[3];
                    Race race = new Race(date, location, firstPlace, secondPlace, thirdPlace,otherDrivers);
                    races.add(race);
                }

                br.close();
                fr.close();

            } else {
                System.out.println("File does not exist.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//=============================================================================================================
    public void SRR() {
        //loading all the drivers and races and adding the drivers to the driverList
        RFFRaces();
        RFF();
        addingToDriverList();
        Random randomNumber = new Random();

        //getting the location randomly
        String[] locations = {"Nyirad", "Holjes", "Montalegre", "Barcelona", "Riga", "Norway"};
        int n = randomNumber.nextInt(locations.length);
        location = locations[n];

        //getting the date randomly and checking whether the date is repeated
        boolean found;
        do {
            int day = randomNumber.nextInt(30) + 1;
            date = "2022-12-" + day;

            found = false;
            for (Race raceData : races) {
                if (raceData.getDate().equals(date)) {
                    found = true;
                    break;
                }
            }
        } while (found);

        for (int i = 1; i <= driverList.size(); i++) {
            // selecting a driver
            found = true;
            while (found) {
                int index = randomNumber.nextInt(driverList.size());
                String driver = driverList.get(index);

                // check if driver is already assigned to a position
                boolean alreadyAssigned = false;
                for (String d : assignedDrivers) {
                    if (d.split("/")[0].equals(driver.split("/")[0])) {
                        alreadyAssigned = true;
                        break;
                    }
                }
                // if driver is not already assigned, add to assignedDrivers list and updating points
                if (!alreadyAssigned) {
                    assignedDrivers.add(driver);
                    found = false;

                    // Update driver's points and assign to position in the race class
                    String[] driverParts = driver.split("/");
                    int updatedPoints;
                    if (i == 1) {
                        updatedPoints = Integer.parseInt(driverParts[3]) + 10;
                        driverParts[3] = String.valueOf(updatedPoints);
                        String updatedDriver = String.join("/", driverParts);
                        driverList.set(index, updatedDriver);
                        firstPlace = updatedDriver;

                    } else if (i == 2) {
                        updatedPoints = Integer.parseInt(driverParts[3]) + 7;
                        driverParts[3] = String.valueOf(updatedPoints);
                        String updatedDriver = String.join("/", driverParts);
                        driverList.set(index, updatedDriver);
                        secondPlace = updatedDriver;
                    } else if (i == 3) {
                        updatedPoints = Integer.parseInt(driverParts[3]) + 5;
                        driverParts[3] = String.valueOf(updatedPoints);
                        String updatedDriver = String.join("/", driverParts);
                        driverList.set(index, updatedDriver);
                        thirdPlace = updatedDriver;

                    }
                    break;
                }
                //is all the drivers have been given positions then we break out of loop
                if (assignedDrivers.size() == driverList.size()) {
                    break;
                }
            }

        }
        StringBuilder others = new StringBuilder();
        //adding the other drivers to the race class.
        for (int h = 3; h < assignedDrivers.size(); h++) {
            others.append(assignedDrivers.get(h));
            if (h < assignedDrivers.size() - 1) {
                others.append(",");
            }
        }

        otherDrivers = String.valueOf(others);
        //clearing driver class objects as we are putting back the drivers with updated points
        drivers.clear();
        for (String d : driverList) {   //iterating through each driver and creating an object
            driverID = Integer.parseInt(d.split("/")[0]);
            name = d.split("/")[1];
            age = Integer.parseInt(d.split("/")[2]);
            points = Integer.parseInt(d.split("/")[3]);
            car = d.split("/")[4];
            team = d.split("/")[5];
            Driver driver = new Driver(driverID, name, age, points, car, team);
            drivers.add(driver);
        }
        //writing to the text file with the updated points, data overwritten
        try {
            FileWriter fw = new FileWriter("playerData.txt", false);
            for (Driver driver : drivers) {
                fw.write(driver.getDriverID() + "/" + driver.getName() + "/" + driver.getAge() + "/" + driver.getPoints() + "/" + driver.getCar() + "/" + driver.getTeam() + "\n");
            }
            fw.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        //race object created for the new race
        Race randomRace = new Race(date, location, firstPlace, secondPlace, thirdPlace, otherDrivers);
        races.add(randomRace);

        //showing the new race to the user in the GUI
        dateOutputLabel.setText(date);
        locationOutputLabel.setText(location);
        firstOutputLabel.setText(firstPlace);
        secondOutputLabel.setText(secondPlace);
        thirdOutputLabel.setText(thirdPlace);

        STFRaces();
        races.clear();
        driverList.clear();
    }

//====================================================================================================================
    public void navigateToAdd() throws IOException {
        Stage Stage2 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("addWindow-View.fxml"));
        Stage2.setScene(new Scene(root));
        Stage2.show();
    }

    public void navigateToUdd() throws IOException { //opens the new stage with the scene for UDD
        Stage Stage3 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("uddWindow-View.fxml")); //linking fxml file
        Stage3.setScene(new Scene(root));
        Stage3.show();
    }

    public void navigateToAddForUDD() throws IOException {
        Stage Stage8 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("addForUddWindow-View.fxml"));
        Stage8.setScene(new Scene(root));
        Stage8.show();
    }

    public void navigateToDdd() throws Exception {
        Stage Stage4 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("dddWindow-View.fxml"));
        Stage4.setScene(new Scene(root));
        Stage4.show();

    }

    public void navigateToVct() throws Exception {
        Stage Stage5 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("vctWindow-View.fxml"));
        Stage5.setScene(new Scene(root));
        Stage5.show();
    }

    public void navigateToVrl() throws Exception {
        Stage Stage6 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("vrlWindow-view.fxml"));
        Stage6.setScene(new Scene(root));
        Stage6.show();
    }

    public void navigateToSrr() throws Exception {

        Stage Stage7 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("srrWindow-View.fxml"));
        Stage7.setScene(new Scene(root));
        Stage7.show();
    }

    //===========================================================================================================================

//**********************************************************************************************************************
            //ADD stuff
    public void onAddClick(ActionEvent event) throws Exception {
        navigateToAdd();

    }
    public void onAddToListClick(ActionEvent event){
        addingDrivers();
        STF();
    }

    //*********************************************************************************************************
            //UDD STUFF

    public void onUddClick(ActionEvent event) throws Exception {
        navigateToUdd(); //once the update button is clicked this method is called and opens the stage.
    }
    public void onUddDeleteButtonClick(ActionEvent event) throws Exception { //once delete button is pressed
        deletingDrivers();   //the driver is deleted if present
        if(driverFound){     //if the driver was found then only the adding the driver stage is opened.
            Stage stage3 = (Stage) uddDeleteButton.getScene().getWindow();  //the deleting stage closed
            stage3.close();
            navigateToAddForUDD();   //adding stage for the UDD is called.
        }

    }
    public void onLoadTableUddClick(ActionEvent event){
        RFF(); //loads the drivers to put to table

        driverIDCol.setCellValueFactory(new PropertyValueFactory<Driver,Integer>("driverID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Driver,String>("name"));
        ObservableList<Driver> data = FXCollections.observableArrayList();
        data.addAll(drivers);
        standingTable.setItems(data);
        loadTableUdd.setDisable(true);
    }
    public void onAddSaveForUddClick(ActionEvent event) {
        savedLabel.setText("Driver saved Successfully");
        addingDrivers();
        STF();
    }
    //***************************************************************************************
            //DDD STUFF

    public void onDddClick(ActionEvent event) throws Exception { //TO OPEN DDD STAGE
        navigateToDdd();
    }
    public void onDddDeleteButtonClick(ActionEvent event) throws Exception {
        deletingDrivers(); //CALLS THE METHOD TO DELETE

    }
    public void onLoadTableDddClick(ActionEvent event) throws Exception{
        RFF();    //LOADING THE DRIVERS TO PUT TO TABLE

        driverIDCol.setCellValueFactory(new PropertyValueFactory<Driver,Integer>("driverID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Driver,String>("name"));
        ObservableList<Driver> data = FXCollections.observableArrayList();
        data.addAll(drivers);
        standingTable.setItems(data);
        loadTableDdd.setDisable(true); //ONLY NEED TO LOAD ONCE
    }
    //***************************************************************************************
        //vrl STUFF
    public void onVrlClick(ActionEvent event) throws Exception {
        navigateToVrl();
    }
    public void onLoadRaceVrlButton(ActionEvent event) throws Exception{
        RFFRaces();

        //using insertion sort to sort the races according to the date
        for (int i = 1; i < races.size(); i++) {
            Race currentRace = races.get(i);
            int j = i - 1;
            while (j >= 0 && races.get(j).getDate().compareTo(currentRace.getDate()) > 0) {
                races.set(j + 1, races.get(j));
                j--;
            }
            races.set(j + 1, currentRace);
        }

        //-------------------------------------------------------------------------------

        dateCol.setCellValueFactory(new PropertyValueFactory<Race,String>("date"));
        locationCol.setCellValueFactory(new PropertyValueFactory<Race,String>("location"));
        colOne.setCellValueFactory(new PropertyValueFactory<Race,String>("firstPlace"));
        colTwo.setCellValueFactory(new PropertyValueFactory<Race,String>("secondPlace"));
        colThree.setCellValueFactory(new PropertyValueFactory<Race,String>("thirdPlace"));
        ObservableList<Race> raceData = FXCollections.observableArrayList();
        raceData.addAll(races);
        raceTable.setItems(raceData);
        loadRaceVrlButton.setDisable(true);

    }

    //===============================SRR stuff======================================================
    public void onSrrClick(ActionEvent event) throws Exception {
       navigateToSrr();

    }
    public void onLoadingRaceButton(ActionEvent event) throws Exception{
        SRR();
        loadingRaceButton.setDisable(true);
    }
    public void onSrrExitButton(ActionEvent event) throws Exception{
        Stage stage7 = (Stage) srrExitButton.getScene().getWindow();
        stage7.close();
    }
    //=========================================================================================================
                //VCT STUFF
    public void onVctClick(ActionEvent event) throws Exception {
        navigateToVct();    //loading the new stage for VCT table

    }
    public void onLoadDriverVctButton(ActionEvent event){
        RFF();

        for (int i = 1; i < drivers.size(); i++) {
            Driver currentDriver = drivers.get(i);
            int pointer = i - 1;
            while (pointer >= 0 && drivers.get(pointer).getPoints() < currentDriver.getPoints()) {
                drivers.set(pointer + 1, drivers.get(pointer));
                pointer--;
            }

            drivers.set(pointer + 1, currentDriver);
        }

        //--------------------------------------------------------------------------------------
        //putting the data to the table
        driverIDCol.setCellValueFactory(new PropertyValueFactory<Driver,Integer>("driverID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Driver,String>("name"));
        pointsCol.setCellValueFactory(new PropertyValueFactory<Driver,Integer>("points"));
        ageCol.setCellValueFactory(new PropertyValueFactory<Driver,Integer>("age"));
        carCol.setCellValueFactory(new PropertyValueFactory<Driver,String>("car"));
        teamCol.setCellValueFactory(new PropertyValueFactory<Driver,String>("team"));
        ObservableList<Driver> data = FXCollections.observableArrayList();
        data.addAll(drivers);
        standingTable.setItems(data);
        loadDriverVctButton.setDisable(true);
    }
    //if user clicks exit it closes the stage
    public void onVctExitButton(ActionEvent event){
        Stage stage5 = (Stage) vctExitButton.getScene().getWindow();
        stage5.close();
    }

}


