import java.time.LocalDate;

public class SeatReservation {

  private String flightDesignator;
  private java.time.LocalDate flightDate;
  private String firstName;
  private String lastName;

  public String getFlightDesignator(){
    return flightDesignator;  
  }

  public void setFlightDesignator(String flightDesignator) {
    if (flightDesignator == null)
       throw new IllegalArgumentException("flight designator cannot be null");
    this.flightDesignator = flightDesignator;
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

  @Override
  public String toString() {
    return "SeatReservation{" + 
      "flightDesignator=" + (flightDesignator == null ? "null" : flightDesignator) + 
      ", flightDate=" + (flightDate == null ? "null" : flightDate) + 
      ", firstName=" + (firstName == null ? "null" : firstName) +
      ", lastName=" + (lastName == null ? "null" : lastName) +
      '}';
  }
  
}
