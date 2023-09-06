package com.example.module3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.util.List;

public class AirportController {

    @FXML
    private TextField identField;
    @FXML
    private TextField iataCodeField;
    @FXML
    private TextField localCodeField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField elevationField;
    @FXML
    private TextField countryField;
    @FXML
    private TextField regionField;
    @FXML
    private TextField municipalityField;
    @FXML
    private Button searchButton;
    @FXML
    private WebView weatherWebView;

    private List<Airport> airports;

    @FXML
    public void initialize() {
        try {
            airports = Airport.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebEngine webEngine = weatherWebView.getEngine();

        searchButton.setOnAction(e -> performSearch());

        identField.setOnAction(e -> performSearch());
        iataCodeField.setOnAction(e -> performSearch());
        localCodeField.setOnAction(e -> performSearch());
    }

    private void performSearch() {
        String ident = identField.getText();
        String iata = iataCodeField.getText();
        String local = localCodeField.getText();

        Airport foundAirport = null;

        for (Airport airport : airports) {
            if (!ident.isEmpty() && ident.equalsIgnoreCase(airport.getIdent())) {
                foundAirport = airport;
                break;
            } else if (!iata.isEmpty() && iata.equalsIgnoreCase(airport.getLataCode())) {
                foundAirport = airport;
                break;
            } else if (!local.isEmpty() && local.equalsIgnoreCase(airport.getLocalCode())) {
                foundAirport = airport;
                break;
            }
        }

        if (foundAirport != null) {
            populateFields(foundAirport);
            updateWebView(foundAirport);
        }
    }

    private void populateFields(Airport airport) {
        typeField.setText(airport.getType());
        nameField.setText(airport.getName());
        elevationField.setText(String.valueOf(airport.getElevationFt()));
        countryField.setText(airport.getIsoCountry());
        regionField.setText(airport.getIsoRegion());
        municipalityField.setText(airport.getMunicipality());
    }

    private void updateWebView(Airport airport) {
        WebEngine webEngine = weatherWebView.getEngine();
        String url = "https://www.windy.com/?" + airport.getCoordinatesLatitude() + "," + airport.getCoordinatesLongitude() + ",12";
        webEngine.load(url);
    }
}