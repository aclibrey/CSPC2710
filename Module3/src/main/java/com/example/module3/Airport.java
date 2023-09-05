package com.example.module3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Airport {
    private String ident;
    private String type;
    private String name;
    private int elevationFt;
    private String isoCountry;
    private String isoRegion;
    private String municipality;
    private String gpsCode;
    private String lataCode;
    private String localCode;
    private double coordinatesLongitude;
    private double coordinatesLatitude;

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getElevationFt() {
        return elevationFt;
    }

    public void setElevationFt(int elevationFt) {
        this.elevationFt = elevationFt;
    }

    public String getIsoCountry() {
        return isoCountry;
    }

    public void setIsoCountry(String isoCountry) {
        this.isoCountry = isoCountry;
    }

    public String getIsoRegion() {
        return isoRegion;
    }

    public void setIsoRegion(String isoRegion) {
        this.isoRegion = isoRegion;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getGpsCode() {
        return gpsCode;
    }

    public void setGpsCode(String gpsCode) {
        this.gpsCode = gpsCode;
    }

    public String getLataCode() {
        return lataCode;
    }

    public void setLataCode(String lataCode) {
        this.lataCode = lataCode;
    }

    public String getLocalCode() {
        return localCode;
    }

    public void setLocalCode(String localCode) {
        this.localCode = localCode;
    }

    public double getCoordinatesLongitude() {
        return coordinatesLongitude;
    }

    public void setCoordinatesLongitude(double coordinatesLongitude) {
        this.coordinatesLongitude = coordinatesLongitude;
    }

    public double getCoordinatesLatitude() {
        return coordinatesLatitude;
    }

    public void setCoordinatesLatitude(double coordinatesLatitude) {
        this.coordinatesLatitude = coordinatesLatitude;
    }

    public static List<Airport> readAll() throws IOException {

        List<Airport> airports = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/aclibrey/CPSC2710/Module3/src/main/java/com/example/module3/airport-codes_csv.csv"))) {
            String line;

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                Airport airport = new Airport();
                airport.setIdent(values[0]);
                airport.setType(values[1]);
                airport.setName(values[2]);
                airport.setElevationFt(Integer.parseInt(values[3]));
                airport.setIsoCountry(values[4]);
                airport.setIsoRegion(values[5]);
                airport.setMunicipality(values[6]);
                airport.setGpsCode(values[7]);
                airport.setLataCode(values[8]);
                airport.setLocalCode(values[9]);
                airport.setCoordinatesLongitude(Double.parseDouble(values[10]));
                airport.setCoordinatesLatitude(Double.parseDouble(values[11]));

                airports.add(airport);
            }
        }
        return airports;
    }
}

