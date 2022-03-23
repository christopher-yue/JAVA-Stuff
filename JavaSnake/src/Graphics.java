import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Graphics extends JPanel implements ActionListener{
	private Timer t = new Timer(100, this);
	public String state;
	
	private Snake s;
	private Food f;
	private Game game;

    private int width = Game.getWidth();
	private int height = Game.getHeight();
	private int dimension = Game.getDimension();
	
	public Graphics(Game g) {
		t.start();
		state = "START";
		
		game = g;
		s = g.getPlayer();
		f = g.getFood();
		
		this.addKeyListener(g);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, width * dimension + 5, height * dimension + 5);
		
		if(state == "START") {
			g2d.setColor(Color.white);
			g2d.drawString("Press Any Key, ", width/2 * dimension - 40, height / 2 * dimension - 20);
			g2d.drawString("Use W A S D to move", width/2 * dimension - 15, height / 2 * dimension - 5);
		}
		else if(state == "RUNNING") {
			g2d.setColor(Color.red);
			g2d.fillRect(f.getX() * dimension, f.getY() * dimension, dimension, dimension);
		
			g2d.setColor(Color.green);
			for(Rectangle r : s.getBody())
				g2d.fill(r);
		}
		else {
			g2d.setColor(Color.white);
			g2d.drawString("Your Score: " + (s.getBody().size() - 3), width/2 * dimension - 40, height / 2 * dimension - 20);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		game.update();
	}
	
}