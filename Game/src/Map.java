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
import java.awt.*;
import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Map {

	private int xOffset;
	private int yOffset;
	private int tileSize;
	private int[][] map;
	private int mapHeight; // ROW: 0 <= Y <= mapHEIGHT not in pixels
	private int mapWidth; // COL: 0 <= X <= mapWIDTH not in pixels
	private String file;
	private MyMap testMap;

	public Map(String file,int mapHeight,int mapWidth, int tileSize) throws IOException {

		this.tileSize = tileSize;
		this.file = file;
		this.mapHeight = mapHeight/tileSize; 
		this.mapWidth = mapWidth/tileSize; 
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
			map = new int[mapHeight][mapWidth];

			for (int row = 0; row < mapHeight; row++) {
				for (int col = 0; col < mapWidth; col++) {
					map[row][col] = 0;
				}
			}
	
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("such error,  " + e.getMessage());
		}
	
	}


	/**
	 * Returns a lane - chosen at random.
	 * @return
	 */
	public Lane getRandomLane(){
		return testMap.getRandomLane(); 
	}
	
	public void update() {
		
	}
	
	//////////////////////////////////////////////////////////////////
	//					 Draw Methods  								//
	//////////////////////////////////////////////////////////////////
	
	/**
	 * Draws the map my drawing the components of the map. Inside the 
	 * method are private method calls to each component of the map.
	 * 
	 * @param g
	 */
	public void draw(Graphics2D g) {

		drawBoard(g);
		drawLanes(g);
		drawDashedLane(g);
		drawLights(g);
		// drawLaneBoarders(g);
		// drawIntersection(g);
	}

	/**
	 * This method draws the background of the game board
	 * @param g
	 */
	private void drawBoard(Graphics2D g) {

		for (int row = 0; row < mapHeight; row++) {
			for (int col = 0; col < mapWidth; col++) {
				g.fillRect(xOffset + col * tileSize, yOffset + row * tileSize,
						tileSize, tileSize);
				g.setColor(Color.DARK_GRAY);
			}
		}
	}

	/**
	 * This method is used to draw the lanes to the map. The lanes are held
	 * within a JSON file.
	 * 
	 * The Json file changed, as a result the drawLanes method is not working
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

			//Needed to add this here because of the JSON configuration of the 
			//start/end positions 
			if(xEnd < xStart){
				int temp = xEnd; 
				xEnd = xStart;
				xStart=temp; 
			}else if(yEnd < yStart){
				int temp = yEnd; 
				yEnd = yStart; 
				yStart = temp; 
			}
				
			for (int col=xStart; col <= xEnd; col++) {
				for (int row = yStart; row <= yEnd; row++) {
					g.setColor(Color.BLACK);
					g.fillRect(xOffset + col * tileSize, yOffset + row
							* tileSize, tileSize, tileSize);
				}
			}
		
		
		}
	}

	/**
	 * This method draws the Lights on the road
	 * 
	 * @param g
	 */
	private void drawLights(Graphics2D g) {

		List<TrafficLight> lights = testMap.getLights();
		Iterator<TrafficLight> itter = lights.iterator();
		while (itter.hasNext()) {
			TrafficLight l = itter.next();
			int x = l.getPosition().getCol();
			int y = l.getPosition().getRow();
			g.setColor(Color.RED);
			//g.fillRect(y * tileSize, x * tileSize, tileSize, tileSize);
			g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
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
		float dash1[] = { 5.0f }; // This is for the lanes
		BasicStroke dashed1 = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);

		while (itter.hasNext()) {
			Lane l = itter.next();
			// Get the start and end positions of each lane
			int xStart = l.getStart().getCol();
			int yStart = l.getStart().getRow();
			int xEnd = l.getEnd().getCol();
			int yEnd = l.getEnd().getRow();

			if (count == 1 || count % 2 == 0) {
				g.drawLine(xStart * tileSize, yStart * tileSize, xEnd
						* tileSize, yEnd * tileSize);
				g.setStroke(dashed1);
				g.setColor(Color.LIGHT_GRAY);
			}
			count++;
		} // end while
	}

	@SuppressWarnings("unused")
	private void drawIntersection(Graphics2D g) {

		
	}

	
	
}
