import java.awt.Rectangle;

public class Food {
	private int x;
	private int y;
	
    private int width = Game.getWidth();
    private int height = Game.getHeight();

	public Food(Snake player) {
		randSpawn(player);
	}
	
	public void randSpawn(Snake player) {
		boolean onSnake = true;
		while(onSnake) {
			onSnake = false;
			
			x = (int)(Math.random() * width - 1);
			y = (int)(Math.random() * height - 1);
			
			for(Rectangle r : player.getBody()){
				if(r.x == x && r.y == y)
					onSnake = true;
			}
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}