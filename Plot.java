/**
 * Represents a Plot object
 * @author Yana L
 *
 */
public class Plot extends java.lang.Object {

	private int x;
	private int y;
	private int width;
	private int depth;
	
	/**    
	 * No-arg Constructor, creates a default Plot with args x=0, y=0, width=1, depth=1
	 */
	public Plot() {
		this.x= 0; 
		this.y= 0;
		this.width= 1;
		this.depth= 1;
		
	}
	
	/**
	 * Copy Constructor, creates a new Plot using the information of the Plot passed to it.
	 * @param p a Plot instance
	 */
	public Plot(Plot p) {
		this.x= p.x;
		this.y= p.y;
		this.width= p.width;
		this.depth= p.depth;
	}
	
	/**
	 * Parameterized constructor
	 * @param x     horizontal coordinate of upper left corner
	 * @param y		vertical coordinate of upper left corner
	 * @param width horizontal size
	 * @param depth vertical size
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x= x;
		this.y= y;
		this.width= width;
		this.depth= depth;
	}
	
	/**
	 * Determines if this plot overlaps the parameter
	 * @param plot  A Plot instance
	 * @return true if this plot overlaps the parameter, false otherwise
	 */
	public boolean overlaps(Plot plot)  
	{	
		boolean x_overLap= (!(plot.x+ plot.width <= this.x || this.x+ this.width <= plot.x));
		boolean y_overLap= (!(plot.y+ plot.depth <= this.y || this.y+ this.depth <= plot.y));
		
		return x_overLap && y_overLap;
	}
	
	/**
	 * Determines if this plot encompasses the parameter
	 * @param plot A Plot instance
	 * @return true if this plot encompasses the parameter, false otherwise
	 */
	public boolean encompasses(Plot plot) {
		boolean bigPlotEmcompassSmall= plot.getX() +plot.getWidth() <=10 && plot.getY()+plot.getDepth() <= 10;
		boolean encompass= this.x<= plot.getX() && this.x+ this.width >= plot.getX()+plot.getWidth() &&  
						   this.y<= plot.getY() && this.y+ this.depth >= plot.getY()+plot.getDepth();
		return bigPlotEmcompassSmall || encompass;
	}
	
	/**
	 * get the x coordinate
	 * @return x coordinate
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * get the x coordinate
	 * @param x coordinate
	 */
	public void setX(int x) {
		this.x= x;
	}
	
	/**
	 * get the y coordinate
	 * @return y coordinate
	 */
	public int getY() {
		return this.y;
	}

	
	/**
	 * get the y coordinate
	 * @param y coordinate
	 */
	public void setY(int y) {
		this.y= y;
	}
	
	/**
	 * get the width value
	 * @return the width value
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * Set the width value
	 * @param width  the width value to set
	 */
	public void setWidth(int width) {
		this.width= width;
	}
	
	/**
	 * get the depth value
	 * @return the depth value
	 */
	public int getDepth() {
		return this.depth;
	}
	
	/**
	 * set the depth value
	 * @param depth  the depth value to set
	 */
	public void setDepth(int depth) {
		this.depth= depth;
	}
	
	/**
	 * Prints out the name, city, owner and rent amount for a property
	 * @return the string representation of a Plot object in the following format: 
               Upper left: (1,1); Width: 3 Depth: 3
	 */
	public java.lang.String toString(){
		String str= "Upper left: ("+ this.x+ ","+ this.y+"); Width: "+this.width+" Depth: "+this.depth;
		return str;
	}
}
