public class Friend {

    public long ID;            // Item identification number
    public String lastName;    // Lastname
    public short streetNumber; // street #
    public int zipCode;        // zip code
    public boolean single;     // Single ?
    public boolean rich;       // Rich ?
    public boolean female;     // Female ?
    

  public Friend(long ID, String lastname, short streetnumber, 
		int zipcode, boolean single, boolean rich, boolean female)  {
      this.ID           = ID;
      this.lastName     = lastname;
      this.streetNumber = streetnumber;
      this.zipCode      = zipcode;
      this.single       = single;
      this.rich         = rich;
      this.female       = female;
  }

  public String toString() {
    final String EOLN = java.lang.System.getProperty("line.separator");
    String value = "Friend # = " + ID + EOLN +
                   "Lastname = " + lastName + EOLN +
                   "Street#  = " + streetNumber + EOLN +
                   "Zip Code = " + zipCode + EOLN;
    if (single)
	value += "Single" + EOLN;
    else
	value += "Married" + EOLN;

    if (rich)                                                            
	value += "Rich" + EOLN;
    else
	value += "Poor" + EOLN;     
    
    if (female)
	value += "Female" + EOLN;
    else
	value += "Male" + EOLN;
    return value;
  }
}
