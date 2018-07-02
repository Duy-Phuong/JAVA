package snake1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")

public class RenderPanel extends JPanel
{

	public static final Color GREEN = new Color(5034295);//hex 4cd137

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Snake snake = Snake.snake;

		g.setColor(GREEN);
		
		g.fillRect(0, 0, 800, 700);

		g.setColor(Color.BLUE);

		
	}
}
