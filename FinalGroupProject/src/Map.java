/*Authors : Iordanis Paschalidis, 
 * 			Anthony Tsiopoulos 
 * 			
 * Class   : Map
 * 			This class is responsible for building the map. A map is created from a JSON text file.
 * 			The file is read in, initialising the lights and lanes. The constructor takes the file
 * 			(string) which is the location of the file we would like to instantiate the map with.
 * 			The tileSize gives the dimension of an individual square.  
 * 
 * 
 * Moded  : 
 * 
 */
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Map {

	private int xOffset;
	private int yOffset;
	private int tileSize;
	public Cell[][] map;
	private int mapHeight; // ROW: 0 <= Y <= mapHEIGHT not in pixels
	private int mapWidth; // COL: 0 <= X <= mapWIDTH not in pixels
	private String file;
	private MyMap testMap;
	private List<Lane> laneCells;

	public Map(String file, int mapWidth, int mapHeight, int tileSize)throws IOException {

		this.tileSize = tileSize;
		this.file = file;
		// this.mapHeight = mapHeight;
		// this.mapWidth = mapHeight;
		this.mapHeight = mapHeight / tileSize;
		this.mapWidth = mapWidth / tileSize;
		initMap();
	}

	/**
	 * This method is responsible for reading the contents of the JSON file and
	 * mapping it into the MyMap class. 
	 */
	private void initMap() {

		try {
			ObjectMapper mapper = new ObjectMapper();
			testMap = mapper.readValue(new FileReader(this.file), MyMap.class);
			map = new Cell[mapWidth][mapHeight];

			for (int col = 0; col < mapWidth; col++) {
				for (int row = 0; row < mapHeight; row++) {
					map[col][row] = new Cell(col, row, false);
				}
			}

			// TEST TEST TEST
			map[29][36].setOccupied(true);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error in initMap(): " + e.getMessage());
		}

	}

	/**
	 * This adds the occupied value as true if a car occupies the cell.
	 * 
	 * @param x
	 * @param y
	 */
	public void addPosition(double x, double y) {
		if (x < mapWidth && x > 0 && y < mapHeight && y > 0) {
			map[(int) x][(int) y].setOccupied(true);
		}
	}

	/**
	 * This changes the status of the cell
	 * 
	 * @param x
	 * @param y
	 */
	public void removePosition(double x, double y) {
		if (x < mapWidth && x > 0 && y < mapHeight && y > 0) {
			map[(int) x][(int) y].setOccupied(false);
		}
	}

	/**
	 * Returns a lane - chosen at random.
	 * 
	 * @return
	 */
	public Lane getRandomLane() {
		return testMap.getRandomLane();
	}

	// ////////////////////////////////////////////////////////////////
	// Paint Methods //
	// ////////////////////////////////////////////////////////////////

	/**
	 * Draws the map my drawing the components of the map. Inside the method are
	 * private method calls to each component of the map.
	 * 
	 * @param g
	 */
	public void paintMap(Graphics2D g) {

		drawBoard(g);
		drawLanes(g);
		drawDashedLane(g);
		//drawSideWalk(g);
		// drawLights(g);
		// drawLaneBoarders(g);
		// drawIntersection(g);
	}

	/**
	 * This method draws the background of the game board
	 * 
	 * @param g
	 */
	private void drawBoard(Graphics2D g) {

		g.setColor(Color.DARK_GRAY);
		for (int col = 0; col < mapWidth; col++) {
			for (int row = 0; row < mapHeight; row++) {
				g.fillRect(xOffset + col * tileSize, yOffset + row * tileSize,
						tileSize, tileSize);
			}
		}
	}

	/**
	 * This method is used to draw the lanes to the map. The lanes are held
	 * within a JSON file.
	 * 
	 * @param g
	 */
	private void drawLanes(Graphics2D g) {

		List<Lane> lanes = testMap.getLanes();
		Iterator<Lane> lit = lanes.iterator();
		while (lit.hasNext()) {
			Lane l = lit.next();

			int xStart = l.getStart().getCol();
			int yStart = l.getStart().getRow();
			int xEnd = l.getEnd().getCol();
			int yEnd = l.getEnd().getRow();

			if (xEnd < xStart) {
				int temp = xEnd;
				xEnd = xStart;
				xStart = temp;
			} else if (yEnd < yStart) {
				int temp = yEnd;
				yEnd = yStart;
				yStart = temp;
			}

			g.setColor(Color.BLACK);
			for (int col = xStart; col <= xEnd; col++) {
				for (int row = yStart; row <= yEnd; row++) {
					g.fillRect(xOffset + col * tileSize, yOffset + row
							* tileSize, tileSize * 2, tileSize * 2);
				}
			}
		}
	}

	/**
	 * Responsible for drawing the (solid/dashed lanes) in the map
	 * 
	 * @param g
	 */
	private void drawDashedLane(Graphics2D g) {

		List<Lane> lanes = testMap.getLanes();
		Iterator<Lane> itter = lanes.iterator();
		int count = 1;
		float[] dash1 = { 2f, 0f, 2f };

		while (itter.hasNext()) {
			Lane l = itter.next();
			// Get the start and end positions of each lane
			int xStart = l.getStart().getCol();
			int yStart = l.getStart().getRow();
			int xEnd = l.getEnd().getCol();
			int yEnd = l.getEnd().getRow();

			if (count == 1 || count % 2 == 0) {
				g.setColor(Color.LIGHT_GRAY);
				g.drawLine(xStart * tileSize, yStart * tileSize, xEnd
						* tileSize, yEnd * tileSize);
				BasicStroke dashed1 = new BasicStroke(1.0f,
						BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f,
						dash1, 0.0f);
			}

			count++;
		} // end while
	}

	/**
	 * This is for debugging purposes. Shows the Cells as we have defined them
	 * and can see where the items are being painted and if they are being
	 * painted to our liking.
	 * 
	 * @param g
	 */
	public void paintGrid(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.GRAY);

		// Draw the Rows
		for (int i = 0; i < mapHeight; i++) {
			g2d.drawLine(0, i * tileSize, tileSize * mapWidth, i * tileSize);
			g2d.setComposite(AlphaComposite.getInstance(
					AlphaComposite.SRC_OVER, 0.3f));
		}

		// draw the columns
		for (int i = 0; i < mapWidth; i++) {
			g2d.setComposite(AlphaComposite.getInstance(
					AlphaComposite.SRC_OVER, 0.3f));
			g2d.drawLine(i * tileSize, 0, i * tileSize, tileSize * mapHeight);
		}

	}

	/**
	 * For debugging purposes, set the occupied cells as (transparent) RED to
	 * test if the occupied cells are being changed.
	 * 
	 * @param g
	 */
	public void paintMapOccupiedValues(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				0.2f));

		for (int row = 0; row < mapHeight; row++) {
			for (int col = 0; col < mapWidth; col++) {
				if (!map[col][row].isOccupied()) {
					g2d.setColor(Color.GREEN);
					g2d.fillRect(xOffset + col * tileSize, yOffset + row
							* tileSize, tileSize, tileSize);
				} else {
					g2d.setColor(Color.RED);
					g2d.fillRect(xOffset + col * tileSize, yOffset + row
							* tileSize, tileSize, tileSize);
				}
			}
		}
	}

	/**
	 * This method returns a cell with indices x and y. 
	 * @param x
	 * @param y
	 * @return
	 */
	public Cell getCell(int x, int y) {
		return map[x][y];
	}

	/**
	 * This method checks if a car is near. There are four cases for each direction.
	 * @param x
	 * @param y
	 * @param direction
	 * @return
	 */
	public boolean isCarNear(int x, int y, int direction) {

		switch (direction) {
		case 0:
			if (map[x + 1][y].isOccupied())
				return true;
			break;

		case 1:
			if (map[x - 1][y].isOccupied())
				return true;
			break;
		case 2:
			if (map[x][y + 1].isOccupied())
				return true;
			break;

		case 3:
			if (map[x][y - 1].isOccupied())
				return true;
			break;
		}

		return true;
	}

	/**
	 * This method checks if an Agent is in the lane next to it. There are four cases for each direction.
	 * 
	 * Add Lane lane object as param after 
	 * 
	 * @param x
	 * @param y
	 * @param direction
	 * @return
	 */
	public boolean isAgentBeside(int x, int y, int direction) {

		switch (direction) {
		case 0:
			if (map[x][y+1].isOccupied())
				return true;
			break;

		}

		return true;
	}
	
	
	
	
	
}