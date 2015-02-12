//strange lane only

public class Lane {
	
	private int lineOnex;//first line's x poistion
	private int lineOneEndx;//where the line is ending
	
	private int lineTwoy;// same logic
	private int lineTwoEndx;//same logic
	
	
	//contractor for giving the valiables for values
	public Lane(int lineOnex, int lineOneEndx, int lineTwoy, int lineTwoEndx) {
		super();
		this.lineOnex = lineOnex;
		this.lineOneEndx = lineOneEndx;
		this.lineTwoy = lineTwoy;
		this.lineTwoEndx = lineTwoEndx;
	}
	
	//from here on are setters getters i will write the correct comments in the near future
	
	public int getLineOnex() {
		return lineOnex;
	}
	
	public void setLineOnex(int lineOnex) {
		this.lineOnex = lineOnex;
	}
	
	public int getLineOneEndx() {
		return lineOneEndx;
	}
	
	public void setLineOneEndx(int lineOneEndx) {
		this.lineOneEndx = lineOneEndx;
	}
	
	public int getLineTwoy() {
		return lineTwoy;
	}
	
	public void setLineTwoy(int lineTwoy) {
		this.lineTwoy = lineTwoy;
	}
	
	public int getLineTwoEndx() {
		return lineTwoEndx;
	}
	
	public void setLineTwoEndx(int lineTwoEndx) {
		this.lineTwoEndx = lineTwoEndx;
	}
	
	
}