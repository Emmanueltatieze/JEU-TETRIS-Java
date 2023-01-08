import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class MainTetris {

	public static void main(String[] args) throws SlickException {
	   JeuxTetris J =new JeuxTetris("Tetris");
	   AppGameContainer app = new AppGameContainer(J);
	   app.setDisplayMode(400+14*40, 800+4*40, false);
	   app.setShowFPS(false);
	   app.start();
	   
	}

}
