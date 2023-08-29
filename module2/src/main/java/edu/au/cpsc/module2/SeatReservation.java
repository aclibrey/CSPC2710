package edu.au.cpsc.module2;

import java.time.LocalDate;

public class SeatReservation {

  private String flightDesignator;
  private java.time.LocalDate flightDate;
  private String firstName;
  private String lastName;
  private int numberOfBags;
  private boolean flyingWithInfant;

  public String getFlightDesignator(){
    return flightDesignator;  
  }

  public void setFlightDesignator(String fd) {
    if (fd == null) {
      throw new IllegalArgumentException("FlgihtDesignator cannot be null");
    }
    if(fd.length() < 4 || fd.length() > 6) {
      throw new IllegalArgumentException("Invalid FlightDesignator Length");
    }
    this.flightDesignator = fd;
  }

  public LocalDate getFlightDate() {
    return flightDate;
  }

  public void setFlightDate(LocalDate date) {
    this.flightDate = date;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String fn) {
    this.firstName = fn;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String ln) {
    this.lastName = ln;
  }

  public int getNumberOfBags(){
    return numberOfBags;
  }

  public void setNumberOfBags(int numberOfBags){
    this.numberOfBags = numberOfBags;
  }

  public boolean isFlyingWithInfant(){
    return flyingWithInfant;
  }

  public void makeFlyingWithInfant(){
    this.flyingWithInfant = true;
  }

  public void makeNotFlyingWithInfant(){
    this.flyingWithInfant = false;
  }

  @Override
  public String toString() {
    return "SeatReservation{" + 
    "flightDesignator=" + (flightDesignator == null ? "null" : flightDesignator) + "," +
    "flightDate=" + (flightDate == null ? "null" : flightDate) + "," +
    "firstName=" + (firstName == null ? "null" : firstName) + "," +
    "lastName=" + (lastName == null ? "null" : lastName) + "," +
    "numberOfBags=" + numberOfBags + "," +
    "flyingWithInfant=" + flyingWithInfant +
    '}';
  }
  
}
