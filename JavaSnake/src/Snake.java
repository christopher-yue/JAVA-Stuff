import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake {
	private ArrayList<Rectangle> body;
	private int width = Game.getWidth();
	private int height = Game.getHeight();
	private int dimension = Game.getDimension();
	
	private String move; //NOTHING, UP, DOWN, LEFT, RIGHT
	
	public Snake() {
		body = new ArrayList<>();
		
		Rectangle temp = new Rectangle(dimension, dimension);
		temp.setLocation(width / 2 * dimension, height / 2 * dimension);
		body.add(temp);
		
		temp = new Rectangle(dimension, dimension);
		temp.setLocation((width / 2 - 1) * dimension, (height / 2) * dimension);
		body.add(temp);
		
		temp = new Rectangle(dimension, dimension);
		temp.setLocation((width / 2 - 2) * dimension, (height / 2) * dimension);
		body.add(temp);
		
		move = "NOTHING";
	}
	
	public void move() {
		if(move != "NOTHING") {
			Rectangle first = body.get(0);
			
			Rectangle temp = new Rectangle(dimension, dimension);
			
			if(move == "UP") 
				temp.setLocation(first.x, first.y - dimension);
			else if(move == "DOWN")
				temp.setLocation(first.x, first.y + dimension);
			else if(move == "LEFT")
				temp.setLocation(first.x - dimension, first.y);
			else
				temp.setLocation(first.x + dimension, first.y);
			
			body.add(0, temp);
			body.remove(body.size()-1);
		}
	}
	
	public void grow() {
		Rectangle first = body.get(0);
		
		Rectangle temp = new Rectangle(dimension, dimension);
		
		if(move == "UP") 
			temp.setLocation(first.x, first.y - dimension);
		else if(move == "DOWN") 
			temp.setLocation(first.x, first.y + dimension);
		else if(move == "LEFT") 
			temp.setLocation(first.x - dimension, first.y);
		else
			temp.setLocation(first.x + dimension, first.y);
		
		body.add(0, temp);
	}

	public ArrayList<Rectangle> getBody() {
		return body;
	}
	

	public void setBody(ArrayList<Rectangle> b) {
		body = b;
	}
	
	public int getX() {
		return body.get(0).x;
	}
	
	public int getY() {
		return body.get(0).y ;
	}
	
	public String getMove() {
		return move;
	}
	
	public void up() {
        if(move != "DOWN")
		    move = "UP";
	}
	public void down() {
		if(move != "UP")
            move = "DOWN";
	}
	public void left() {
        if(move != "LEFT")
		    move = "LEFT";
	}
	public void right() {
		if(move != "LEFT")
            move = "RIGHT";
	}
}