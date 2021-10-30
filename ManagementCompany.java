import javafx.scene.layout.Region;

public class ManagementCompany extends java.lang.Object {

	private java.lang.String name;
	private java.lang.String taxID;
	private Property[] properties;
	private double mgmFeePer;
	private final int MAX_PROPERTY=5;
	private final int MGMT_WIDTH=10;
	private final int MGMT_DEPTH=10;
	private Plot plot;
	
	
	
	/**
	 * No-Arg Constructor that creates a ManagementCompany object using empty strings and
	 * a default Plot. "properties" array is initialized here as well.
	 */
	public ManagementCompany() {
		this.name="";
		this.taxID="";
		this.mgmFeePer=0;
		
		this.properties= new Property [MAX_PROPERTY] ;
		plot= new Plot (0,0,MGMT_WIDTH,MGMT_DEPTH);
	}
	
	
	/**
	 * Constructor Creates a ManagementCompany object using the passed information. 
	 * Mgmt Co plot is initialized to default Plot. "properties" array is initialized here as well.
	 * @param name   management company name
	 * @param taxID  management company tax id
	 * @param mgmFee management fee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		this.name= name;
		this.taxID= taxID;
		this.mgmFeePer= mgmFee;
		this.properties= new Property [MAX_PROPERTY];
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);  //// overall plot
	}

	
	
	/**
	 * Constructor Creates a ManagementCompany object using the passed information. 
	 * "properties" array is initialized here as well.
	 * @param name    management company name
	 * @param taxID   management company tax id
	 * @param mgmFee  management fee
	 * @param x       X coordinate value
	 * @param y		  Y coordinate value
	 * @param width	  width value
	 * @param depth   depth value
	 */
	public ManagementCompany(String name, String taxID, double mgmFee,  
							int x,  int y, int width, int depth)
	{
		this.name= name;
		this.taxID= taxID;
		this.mgmFeePer= mgmFee;
		this.plot= new Plot(x,y, width, depth); 
		properties= new Property[MAX_PROPERTY];
	}

	
	
	/**
	 * Copy Constructor creates a ManagementCompany object using another ManagementCompany object. 
	 * "properties" array is initialized here as well.
	 * @param otherCompany another management company
	 */
	public ManagementCompany(ManagementCompany otherCompany)
	{
		this.name= otherCompany.name;
		this.taxID= otherCompany.taxID;
		this.mgmFeePer= otherCompany.mgmFeePer;
		this.plot= otherCompany.plot;
		this.properties= otherCompany.properties;
	}

	
	/**
	 *  Get the MAX_PROPERTY constant that represent the size of the "properties" array
	 * @return the MAX_PROPERTY a constant attribute for this class that is set 5
	 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

	
	/**
	 * Adds the property object to the "properties" array.
	 * @param property  a property object
	 * @return  either -1 if the array is full, -2 if property is null, 
	 *           -3 if the plot is not contained by the MgmtCo plot,
	 *  		 -4 of the plot overlaps any other property, 
	 *  		 or the index in the array where the property was added successfully.
	 */
	public int addProperty(Property property) {
		
		int r=-1;
		
		if (property==null)
			r= -2;
		else if ( plot.encompasses(property.getPlot()) ==false)
			r= -3;
		else 
		{	for (int i= 0; i< properties.length; i++)
			{
				if (properties[i]==null)
				{	Property copy= new Property (property);
					properties[i]= copy;
					r= i;
					break;		
				}
				
				else if (properties[i].getPlot().overlaps(property.getPlot()))
				{r=-4;
					break;
				}
			}
		}
		return r;
	}

	
	
	/**
	 * Creates a property object and adds it to the "properties" array, in a default plot.
	 * @param name   property name
	 * @param city   location of the property
	 * @param rent   monthly rent
	 * @param owner  owner of the property
	 * @return either -1 if the array is full, -2 if property is null, 
	 * 				-3 if the plot is not contained by the MgmtCo plot, 
					-4 of the plot overlaps any other property, 
					or the index in the array where the property was added successfully.
	*/
	public int addProperty(String name,String city,double rent,String owner) {
		int r=-1;
		Property property= new Property (name, city, rent, owner);
		if (property==null)
			r= -2;
		else if ( plot.encompasses(property.getPlot()) ==false)
			r= -3;
		else 
		{
			for (int i= 0; i< properties.length; i++)
			{
				if (properties[i]==null)
				{
					Property copy= new Property (property);
					properties[i]= copy;
					r= i;
					break;		
				}
				
				else if (properties[i].getPlot().overlaps(property.getPlot()))
				{
					r=-4;
					break;
				}
			}
		}	
		return r;
	}
	
	/**
	 * Creates a property object and adds it to the "properties" array.
	 * @param name  property name
	 * @param city  location of the property
	 * @param rent   monthly rent
	 * @param owner  owner of the property
	 * @param x      x location of upper left corner of property's plot
	 * @param y      y location of upper left corner of property's plot
	 * @param width  width of the property's plot
	 * @param depth  depth of the property's plot
	 * @return  either -1 if the array is full, -2 if property is null, 
	 * 				-3 if the plot is not contained by the MgmtCo plot, 
	 * 				-4 of the plot overlaps any other property, 
	 * 				or the index in the array where the property was added successfully.
	 */
	public int addProperty(String name,String city,double rent,String owner,int x,int y,int width,int depth) {
		int r=-1;
		Property property= new Property (name, city, rent, owner,x,y,width,depth);
		if (property==null)
			r= -2;
		else if ( plot.encompasses(property.getPlot()) ==false)
			r= -3;
		else 
		{
			for (int i= 0; i< properties.length; i++)
			{
				if (properties[i]==null)
				{
					Property copy= new Property (property);
					properties[i]= copy;
					r= i;
					break;		
				}
				
				else if (properties[i].getPlot().overlaps(property.getPlot()))
				{
					r=-4;
					break;
				}
			}
		}	
		return r;
	}
	
	
	
	
	/**
	 * This method accesses each "Property" object within the array "properties" and
	 * sums up the property rent and returns the total amount.
	 * @return total rent
	 */
	public double totalRent() {
		double total=0;
		for(int i=0; i< properties.length; i++) {
			if (properties[i]==null)
				break;
			total += properties[i].getRentAmount();
		}
		return total;
	}
	
	
	/**
	 * This method finds the property with the maximum rent amount and returns its toString result. 
	 * NOTE: For simplicity assume that each "Property" object's rent amount is different.
	 * @return a String, the toString of the property with the maximum rent amount
	 */
	public String maxRentProp() {
		double maxRentAmount= 0;
		int maxRentIndex=0;
		for (int i=0; i< MAX_PROPERTY; i++) {
			if (properties[i]==null)
				break;
			else if (properties[i].getRentAmount()> maxRentAmount) {
				maxRentIndex= i;
				maxRentAmount= properties[i].getRentAmount(); 
			}
		}
		String str= "The property " + (maxRentIndex+1) + "has the maximum rent amount: " +maxRentAmount;
		return str;
	}
	
	
	
	/**
	 * This method finds the index of the property with the maximum rent amount.
	 * NOTE: For simplicity assume that each "Property" object's rent amount is different.
	 * @return int , the index of the property with the maximum rent amount
	 */
	public int maxRentPropertyIndex() {
		
		double maxRentAmount= 0;
		
		int maxRentIndex=0;
		for (int i=0; i< properties.length; i++) {
			if (properties[i].getRentAmount()> maxRentAmount) {
				maxRentAmount= properties[i].getRentAmount();
				maxRentIndex= i;
			}
		}
		return maxRentIndex;
	}
	
	
	
	/**
	 * Displays   the information of the property at index i
	 * @param i   The index of the property within the array "properties"
	 * @return    information of the property at index i
	 */
	public java.lang.String displayPropertyAtIndex(int i)
	{
		String str= "The properties Name: " + properties[i].getPropertyName() + 
					"\n  Located in "+ properties[i].getCity() +
				    "\n  Belonging to: " + properties[i].getOwner() +
				    "\n  Rent Amount: " + properties[i].getRentAmount();
		return str;
	}
	
	
	/* M9: 
	   Overrides: toString in class java.lang.Object
	   Returns: 
	
	The format is as following example:
    List of the properties for Alliance, taxID: 1235
  ______________________________________________________
    Property Name: Belmar
      Located in Silver Spring
      Belonging to: John Smith
      Rent Amount: 1200.0
    Property Name: Camden Lakeway
      Located in Rockville
      Belonging to: Ann Taylor
      Rent Amount: 2450.0
    Property Name: Hamptons
      Located in Rockville
      Belonging to: Rick Steves
      Rent Amount: 1250.0
  ______________________________________________________
  total management Fee: 294.0
	 */
	
	/**
	 * Displays the information of all the properties in the "properties" array.
	 * @return  information of ALL the properties within this management company by accessing the "Properties" array.
	 */
	public java.lang.String toString(){
		
		String str= " List of the properties for " + this.name + ", taxID: " + taxID +
				"\n----------------------------------------------------\n";
		for(int i=0; i< properties.length; i++)
		{	
			str +=	"\n Properties " + (i+1) +" Name: " + properties[i].getPropertyName() + 
					"\n  Located in "+ properties[i].getCity() +
					"\n  Belonging to: " + properties[i].getOwner() +
					"\n  Rent Amount: " + properties[i].getRentAmount() ;
		}
		str += "\n----------------------------------------------------\nTotal management Fee: "
				+ ( totalRent()* mgmFeePer/100);
		return str;
	}


	/**
	 * Get the default management company plot
	 * @return the default management company plot
	 */
	public Plot getPlot() {
		return plot;
	}

	/**
	 * Get the management company name
	 * @return the management company name
	 */
	public String getName() {
		return name;
	}
	
}
		
		
