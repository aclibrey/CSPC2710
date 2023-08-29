package edu.au.cpsc.module2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class SeatReservationApplication extends Application {

    private SeatReservation seatReservation;
    private TextField flightDesignatorField = new TextField();
    private TextField firstNameField = new TextField();
    private TextField lastNameField = new TextField();
    private DatePicker flightDatePicker = new DatePicker();
    private CheckBox flyingWithInfantCheckBox = new CheckBox();
    private TextField numberOfPassengersField = new TextField("1");
    private TextField numberOfBagsField = new TextField();


    @Override
    public void start(Stage stage) throws IOException {
        seatReservation = new SeatReservation();
        seatReservation.setFlightDesignator("AU123");
        seatReservation.setFirstName("Adam");
        seatReservation.setLastName("Clibrey");
        seatReservation.setNumberOfBags(1);
        seatReservation.makeNotFlyingWithInfant();

        BorderPane root = new BorderPane();
        GridPane grid = new GridPane();
        root.setCenter(grid);

        grid.add(new Label("Flight Designator:"), 0, 0);
        grid.add(flightDesignatorField, 1, 0);

        grid.add(new Label("First Name:"), 0, 1);
        grid.add(firstNameField, 1, 1);

        grid.add(new Label("Last Name:"), 0, 2);
        grid.add(lastNameField, 1, 2);

        grid.add(new Label("Flight Date:"), 0, 3);
        grid.add(flightDatePicker, 1, 3);

        grid.add(new Label("Number of Bags:"), 0, 4);
        grid.add(numberOfBagsField, 1, 4);

        grid.add(new Label("Flying with Infant:"), 0, 5);
        grid.add(flyingWithInfantCheckBox, 1, 5);

        grid.add(new Label("Number of Passengers:"), 0, 6);
        numberOfPassengersField.setEditable(false);
        grid.add(numberOfPassengersField, 1, 6);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.TOP_RIGHT);
        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");
        hBox.getChildren().addAll(saveButton, cancelButton);
        root.setBottom(hBox);

        flyingWithInfantCheckBox.setOnAction(e -> {
            if (flyingWithInfantCheckBox.isSelected()) {
                numberOfPassengersField.setText("2");
            } else {
                numberOfPassengersField.setText("1");
            }
        });

        saveButton.setOnAction(e -> {
            try {
                seatReservation.setFlightDesignator(flightDesignatorField.getText());
                seatReservation.setFirstName(firstNameField.getText());
                seatReservation.setLastName(lastNameField.getText());
                seatReservation.setNumberOfBags(Integer.parseInt(numberOfBagsField.getText()));
                if (flyingWithInfantCheckBox.isSelected()) {
                    seatReservation.makeFlyingWithInfant();
                } else {
                    seatReservation.makeNotFlyingWithInfant();
                }
                System.out.println(seatReservation.toString());
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid input: " + ex.getMessage());
            }
            Platform.exit();
        });

        cancelButton.setOnAction(e -> {
            System.out.println("Cancel clicked");
            Platform.exit();
        });

        updateUI();
        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Seat Reservation");
        stage.setScene(scene);
        stage.show();

    }

    private void updateUI() {
        flightDesignatorField.setText(seatReservation.getFlightDesignator());
        firstNameField.setText(seatReservation.getFirstName());
        lastNameField.setText(seatReservation.getLastName());
        numberOfBagsField.setText(String.valueOf(seatReservation.getNumberOfBags()));
        flyingWithInfantCheckBox.setSelected(seatReservation.isFlyingWithInfant());
    }

    public static void main(String[] args) {
        launch();
    }

}
