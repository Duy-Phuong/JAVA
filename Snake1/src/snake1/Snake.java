/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake1;


import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author admin1
 */
public class Snake implements ActionListener{

   public static Snake snake;

    public JFrame jframe;
    public Dimension dim;
    public RenderPanel renderPanel;

	public Timer timer = new Timer(20, this);

	public Snake()
	{
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		jframe = new JFrame("Snake");
		jframe.setVisible(true);
		jframe.setSize(805, 700);
		jframe.setResizable(false);
                // lấy 1 nửa màn hình trừ cho 1 nửa của jframe để xác địhn vi trí bên trái

		jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2, dim.height / 2 - jframe.getHeight() / 2);
		jframe.add(renderPanel = new RenderPanel());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
		
	}
        
        @Override
	public void actionPerformed(ActionEvent arg0)
	{
		renderPanel.repaint();
//		ticks++;
//
//		if (ticks % 2 == 0 && head != null && !over && !paused)
//		{
//			time++;
//
//			snakeParts.add(new Point(head.x, head.y));
//
//			if (direction == UP)
//			{
//				if (head.y - 1 >= 0 && noTailAt(head.x, head.y - 1))
//				{
//					head = new Point(head.x, head.y - 1);
//				}
//				else
//				{
//					over = true;
//
//				}
//			}
//
//			if (direction == DOWN)
//			{
//				if (head.y + 1 < 67 && noTailAt(head.x, head.y + 1))
//				{
//					head = new Point(head.x, head.y + 1);
//				}
//				else
//				{
//					over = true;
//				}
//			}
//
//			if (direction == LEFT)
//			{
//				if (head.x - 1 >= 0 && noTailAt(head.x - 1, head.y))
//				{
//					head = new Point(head.x - 1, head.y);
//				}
//				else
//				{
//					over = true;
//				}
//			}
//
//			if (direction == RIGHT)
//			{
//				if (head.x + 1 < 80 && noTailAt(head.x + 1, head.y))
//				{
//					head = new Point(head.x + 1, head.y);
//				}
//				else
//				{
//					over = true;
//				}
//			}
//
//			if (snakeParts.size() > tailLength)
//			{
//				snakeParts.remove(0);
//
//			}
//
//			if (cherry != null)
//			{
//				if (head.equals(cherry))
//				{
//					score += 10;
//					tailLength++;
//					cherry.setLocation(random.nextInt(79), random.nextInt(66));
//				}
//			}
//		}
	}
    public static void main(String[] args) {
        snake = new Snake();

    }

   
    
}

