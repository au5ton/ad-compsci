import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapePanel extends JPanel
{
	public ShapePanel()
	{
		setBackground(Color.WHITE);
		setVisible(true);
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		window.setColor(Color.WHITE);
		window.fillRect(0,0,getWidth(), getHeight());
		window.setColor(Color.BLUE);
		window.drawRect(20,20,getWidth()-40,getHeight()-40);
		window.setFont(new Font("TAHOMA",Font.BOLD,18));
		window.drawString("CREATE YOUR OWN SHAPE!",40,40);


		//instantiate a Shape
		Shape bob = new Shape(50,50,200,200,Color.PINK);
		bob.draw(window);

		Shape sally = new Shape(175,175,150,150,Color.YELLOW);
		sally.draw(window);

		Shape andrew = new Shape(250,250,100,100,new Color(192,255,0));
		andrew.draw(window);

		Shape bruh = new Shape(310,310,75,75,new Color(255,0,255));
		bruh.draw(window);


	}
}
