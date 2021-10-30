/**
 * Represents a Property object
 * @author Yana L
 *
 */
public class Property extends java.lang.Object {
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	
	/**
	 * No-arg Constructor, creates a new object with default values of empty strings, 
	 * 0 for rent amount, and default Plot
	 */
	public Property() {
		propertyName="";
		city= "";
		rentAmount= 0;
		plot= new Plot (0,0,1,1);
		
	}
	
	
	/**
	 * Copy Constructor, creates a new object using the information of the object passed to it.
	 * @param p  a Property object
	 */
	public Property(Property p) {
		this.propertyName= p.propertyName;
		this.city= p.city;
		this.rentAmount= p.rentAmount;
		this.owner= p.owner;
		this.plot= p.plot;
		
	}
	

	/**
	 * Constructor, Parameterized constructor with no Plot information
	 *  (uses default Plot where x,y are set to 0, width and depth set to 1)
	 * @param propertyName property name
	 * @param city         city where the property is located
	 * @param rentAmount   rent amount
	 * @param owner        the owner's name
	 */
	public Property(String propertyName, 
					String city, 
					double rentAmount, 
					String owner) 
	{
		this.propertyName= propertyName;
		this.city= city;
		this.rentAmount= rentAmount;
		this.owner =owner;
		plot= new Plot ();
		
	}
	
	
	/** Parameterized constructor
	 * 
	 * @param propertyName property name
	 * @param city         city where the property is located
	 * @param rentAmount   rent amount
	 * @param owner        the owner's name
	 * @param x			   the x-value of the property's plot
	 * @param y			   the y-value of the property's plot
	 * @param width		   the horizontal size of the property's plot
	 * @param depth		   the vertical size of the property's plot
	 */
	public Property(String propertyName, 
					String city, 
					double rentAmount,
					String owner, 
					int x, int y, int width, int depth) {
		this.propertyName= propertyName;
		this.city= city;
		this.rentAmount= rentAmount;
		this.owner= owner;
		plot= new Plot(x,y,width,depth);
		
	}
	
	
	/**
	 * get the property Name
	 * @return the property Name
	 */
	public String getPropertyName(){
		return this.propertyName;
	}
	
	/**
	 * set the property Name
	 * @param propertyName
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName= propertyName;
	}
	
	/**
	 * get the city
	 * @return the city
	 */
	public String getCity(){
		return this.city;
	}
	
	/**
	 * set the city
	 * @param city
	 */
	public void setCity(String city) {
		this.city= city;
	}
	
	
	public Plot getPlot()
	{
		return this.plot;
	}
	
	/**
	 * set the Plot values
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public void setPlot(int x, int y, int width, int depth)
	{
		this.plot= new Plot(x,y,width,depth);
	}
	
	
	
	/**
	 * get the rent amount
	 * @return the rent amount
	 */
	public double getRentAmount() {
		return this.rentAmount;
	}
	
	/**
	 * set the rentAmount
	 * @param rentAmount
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount= rentAmount;
	}
	
	/**
	 * get the owner name
	 * @return the owner name
	 */
	public String getOwner(){
		return this.owner;
	}
	
	/**
	 * set the owner name
	 * @param owner
	 */
	public void setOwner(String owner) {
		this.owner= owner;
	}
	
	/**
	 * Prints out the name, city, owner and rent amount for a property
	 * 
	 */
	@ Override
	public String toString(){
		
		return "Property Name: " + this.propertyName + "\nLocated in: "+ this.city +
				"\nBelonging to: " + this.owner + "\nRent Amount: "+ this.getRentAmount()+" ";
	}
	
}
