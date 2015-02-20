//strange lane only

public class Lane {
	
	private int lineOnex;//first line's x poistion
	private int lineOney;

	private int lineOneEndx;//where the line is ending
	private int lineOneEndy;//where the line is ending

	private int lineTwox;// same logic
	private int lineTwoy;// same logic

	private int lineTwoEndx;//same logic
	private int lineTwoEndy;//same logic

	
   
	
	public Lane(int lineOnex, int lineOney, int lineOneEndx, int lineOneEndy,
			int lineTwox, int lineTwoy, int lineTwoEndx, int lineTwoEndy) {
		super();
		this.lineOnex = lineOnex;
		this.lineOney = lineOney;
		this.lineOneEndx = lineOneEndx;
		this.lineOneEndy = lineOneEndy;
		this.lineTwox = lineTwox;
		this.lineTwoy = lineTwoy;
		this.lineTwoEndx = lineTwoEndx;
		this.lineTwoEndy = lineTwoEndy;
	}

	//from here on are setters getters i will write the correct comments in the near future

	
	public int getLineOnex() {
		return lineOnex;
	}
	
	public int getLineOney() {
		return lineOney;
	}

	public void setLineOney(int lineOney) {
		this.lineOney = lineOney;
	}

	public int getLineOneEndy() {
		return lineOneEndy;
	}

	public void setLineOneEndy(int lineOneEndy) {
		this.lineOneEndy = lineOneEndy;
	}

	public int getLineTwoy() {
		return lineTwoy;
	}

	public void setLineTwoy(int lineTwoy) {
		this.lineTwoy = lineTwoy;
	}

	public int getLineTwoEndy() {
		return lineTwoEndy;
	}

	public void setLineTwoEndy(int lineTwoEndy) {
		this.lineTwoEndy = lineTwoEndy;
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
	
	public int getLineTwox() {
		return lineTwox;
	}
	
	public void setLineTwox(int lineTwoy) {
		this.lineTwox = lineTwoy;
	}
	
	public int getLineTwoEndx() {
		return lineTwoEndx;
	}
	
	public void setLineTwoEndx(int lineTwoEndx) {
		this.lineTwoEndx = lineTwoEndx;
	}
	
	
}