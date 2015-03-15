// TODO: Auto-generated Javadoc
/**
 * The Class Lane.
 */
public class Lane {
	
	private int lineOnex; //first line's x poistion
	private int lineOney;
	private int lineOneEndx;//where the line is ending
	private int lineOneEndy;//where the line is ending
	private int lineTwox;// same logic
	private int lineTwoy;// same logic
	private int lineTwoEndx;//same logic
	private int lineTwoEndy;//same logic
	private Light light; 
    
	
	//just give first values to variables
	/**
	 * Instantiates a new lane.
	 *
	 * @param lineOnex the line onex
	 * @param lineOney the line oney
	 * @param lineOneEndx the line one endx
	 * @param lineOneEndy the line one endy
	 * @param lineTwox the line twox
	 * @param lineTwoy the line twoy
	 * @param lineTwoEndx the line two endx
	 * @param lineTwoEndy the line two endy
	 * @param light the light
	 */
	public Lane(int lineOnex, int lineOney, int lineOneEndx, int lineOneEndy,
			int lineTwox, int lineTwoy, int lineTwoEndx, int lineTwoEndy, Light light) {
		super();
		this.lineOnex = lineOnex;
		this.lineOney = lineOney;
		this.lineOneEndx = lineOneEndx;
		this.lineOneEndy = lineOneEndy;
		this.lineTwox = lineTwox;
		this.lineTwoy = lineTwoy;
		this.lineTwoEndx = lineTwoEndx;
		this.lineTwoEndy = lineTwoEndy;
		this.light=light; 
		
	}
	
	
	
	/**
	 * Gets the light.
	 *
	 * @return the ligth of the lane
	 */
	public Light getLight() {
		return light;
	}


	/**
	 * Sets the ligts of the lane.
	 *
	 * @param light  the new lane object
	 */
	public void setLight(Light light) {
		this.light = light;
	}


	/**
	 * Gets the line oney.
	 *
	 * @return the line oney
	 */
	public int getLineOney() {
		return lineOney;
	}

	
	/**
	 * Sets the line oney.
	 *
	 * @param lineOney the new line oney
	 */
	public void setLineOney(int lineOney) {
		this.lineOney = lineOney;
	}

	/**
	 * Gets the line one endy.
	 *
	 * @return the line one endy
	 */
	public int getLineOneEndy() {
		return lineOneEndy;
	}

	/**
	 * Sets the line one endy.
	 *
	 * @param lineOneEndy the new line one endy
	 */
	public void setLineOneEndy(int lineOneEndy) {
		this.lineOneEndy = lineOneEndy;
	}

	/**
	 * Gets the line twoy.
	 *
	 * @return the line twoy
	 */
	public int getLineTwoy() {
		return lineTwoy;
	}

	/**
	 * Sets the line twoy.
	 *
	 * @param lineTwoy the new line twoy
	 */
	public void setLineTwoy(int lineTwoy) {
		this.lineTwoy = lineTwoy;
	}

	
	/**
	 * Gets the line two endy.
	 *
	 * @return the line two endy
	 */
	public int getLineTwoEndy() {
		return lineTwoEndy;
	}

	/**
	 * Sets the line two endy.
	 *
	 * @param lineTwoEndy the new line two endy
	 */
	public void setLineTwoEndy(int lineTwoEndy) {
		this.lineTwoEndy = lineTwoEndy;
	}

	/**
	 * Sets the line onex.
	 *
	 * @param lineOnex the new line onex
	 */
	public void setLineOnex(int lineOnex) {
		this.lineOnex = lineOnex;
	}
	
	/**
	 * Gets the line one endx.
	 *
	 * @return the end x point of the first line of the lane
	 */
	public int getLineOneEndx() {
		return lineOneEndx;
	}
	
	/**
	 * Gets the line onex.
	 *
	 * @return the start x point of the first line of the lane
	 */
	public int getLineOnex() {
		return lineOnex;
	}
	
	/**
	 * Sets the line one endx.
	 *
	 * @param lineOneEndx the new line one endx
	 */
	public void setLineOneEndx(int lineOneEndx) {
		this.lineOneEndx = lineOneEndx;
	}
	
	/**
	 * Gets the line twox.
	 *
	 * @return the first x point of the second line of the lane
	 */
	public int getLineTwox() {
		return lineTwox;
	}
	
	/**
	 * Sets the line twox.
	 *
	 * @param lineTwoy the new line twox
	 */
	public void setLineTwox(int lineTwoy) {
		this.lineTwox = lineTwoy;
	}
	
	/**
	 * Gets the line two endx.
	 *
	 * @return the end x point of the second line of the lane
	 */
	public int getLineTwoEndx() {
		return lineTwoEndx;
	}
	
	/**
	 * Sets the line two endx.
	 *
	 * @param lineTwoEndx the new line two endx
	 */
	public void setLineTwoEndx(int lineTwoEndx) {
		this.lineTwoEndx = lineTwoEndx;
	}
	
	
}