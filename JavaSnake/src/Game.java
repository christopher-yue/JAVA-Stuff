import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game implements KeyListener{
	private Snake player;
	private Food food;
	private Graphics graphics;
	
	private JFrame window;
	
	private static final int WIDTH = 30;
	private static final int HEIGHT = 30;
	private static final int DIMENSION = 20;
	
	public Game() {
		window = new JFrame();
		
		player = new Snake();
		
		food = new Food(player);
		
		graphics = new Graphics(this);
		
		window.add(graphics);
		
		window.setTitle("Snake");
		window.setSize(WIDTH * DIMENSION + 2, HEIGHT * DIMENSION + DIMENSION + 4);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
    public static int getWidth(){
        return WIDTH;
    }

    public static int getHeight(){
        return HEIGHT;
    }

    public static int getDimension(){
        return DIMENSION;
    }

	public void start() {
		graphics.state = "RUNNING";
	}
	
	public void update() {
		if(graphics.state == "RUNNING") {
			if(checkFoodCollision()) {
				player.grow();
				food.randSpawn(player);
			}
			else if(checkWallCollision() || checkSelfCollision())
				graphics.state = "END";
			else
				player.move();
		}
	}
	
	private boolean checkWallCollision() {
		if(player.getX() < 0 || player.getX() >= WIDTH * DIMENSION || player.getY() < 0|| player.getY() >= HEIGHT * DIMENSION)
			return true;
		return false;
	}
	
	private boolean checkFoodCollision() {
		if(player.getX() == food.getX() * DIMENSION && player.getY() == food.getY() * DIMENSION) 
			return true;
		return false;
	}
	
	private boolean checkSelfCollision() {
		for(int i = 1; i < player.getBody().size(); i++) {
			if(player.getX() == player.getBody().get(i).x && player.getY() == player.getBody().get(i).y)
				return true;
		}
		return false;
	}

	@Override
	public void keyTyped(KeyEvent e) {	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		if(graphics.state == "RUNNING") {
			if(keyCode == KeyEvent.VK_W && player.getMove() != "DOWN")
				player.up();
	
			if(keyCode == KeyEvent.VK_S && player.getMove() != "UP")
				player.down();
		
			if(keyCode == KeyEvent.VK_A && player.getMove() != "RIGHT")
				player.left();
		
			if(keyCode == KeyEvent.VK_D && player.getMove() != "LEFT")
				player.right();
		}
		else
			start();
	}

	@Override
	public void keyReleased(KeyEvent e) {	}

	public Snake getPlayer() {
		return player;
	}

	public void setPlayer(Snake p) {
		player = p;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public JFrame getWindow() {
		return window;
	}

	public void setWindow(JFrame w) {
		window = w;
	}
	
}