import java.awt.Dimension;
import java.awt.SplashScreen;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class SplashTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static void init() throws NullPointerException, IllegalStateException, MalformedURLException, IOException {
		
		SplashScreen screen = SplashScreen.getSplashScreen();
		Dimension dim = screen.getSize();
		screen.setImageURL(new URL("res/5jOFiSD.jpg"));
		
		
	}
	

}
