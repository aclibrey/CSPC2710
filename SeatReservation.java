
import java.time.LocalDate;

public class SeatReservation {

  private String flightDesignator;
  private java.time.LocalDate flightDate;
  private String firstName;
  private String lastName;

  public String getFlightDesignator(){
    return flightDesignator;  
  }

<<<<<<< Updated upstream
  public void setFlightDesignator(String fd) {
    if (fd == null) {
      throw new IllegalArgumentException("FlgihtDesignator cannot be null");
    }
    if(fd.length() < 4 || fd.length() > 6) {
      throw new IllegalArgumentException("Invalid FlightDesignator Length");
    }
    this.flightDesignator = fd;
  }
=======
<<<<<<< HEAD
  public void setFlightDesignator(String flightDesignator) {
    if (flightDesignator == null)
       throw new IllegalArgumentException("flight designator cannot be null");
    this.flightDesignator = flightDesignator;
 }

=======
  public void setFlightDesignator(String fd) {
    this.flightDesignator = fd;
    if(fd.length() < 4 || fd.length() >6) }
      throw new IllegalArgumentException ("Invalid FlightDesignator Length");
    }
  }
>>>>>>> fce596c729c806eb9bdee4666697dca32ad443c7
>>>>>>> Stashed changes

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
    "flightDesignator=" + (flightDesignator == null ? "null" : flightDesignator) + "," +
    "flightDate=" + (flightDate == null ? "null" : flightDate) + "," +
    "firstName=" + (firstName == null ? "null" : firstName) + "," +
    "lastName=" + (lastName == null ? "null" : lastName) + 
    '}';
  }
  
}
