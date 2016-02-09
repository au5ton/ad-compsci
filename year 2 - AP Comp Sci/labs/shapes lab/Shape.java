import java.awt.Color;
import java.awt.Graphics;

public class Shape
{
	//instance variables
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;

	public Shape(){
		//
	}

	public Shape(int x, int y, int wid, int ht, Color col)
	{
		xPos = x;
		yPos = y;
		width = wid;
		height = ht;
		color = col;
	}


	public void draw(Graphics window)
	{
		//draw whatever you want

		Color orangeColor = new Color(255,128,0);
		Color whiteColor = new Color(255,255,255);

		window.setColor(color);
		window.fillOval(xPos,yPos,width,height);
		window.setColor(orangeColor);
		window.fillOval(xPos+(width/2),yPos+(height/2),(int)(width*0.30),(int)(height*0.30));
		window.setColor(whiteColor);
		window.fillOval(xPos+(width/2),yPos+(height/2),(int)(width*0.20),(int)(height*0.20));
		window.setColor(orangeColor);
		window.fillOval(xPos+(width/2),yPos+(height/2),(int)(width*0.10),(int)(height*0.10));
		window.setColor(orangeColor);
		window.fillOval(xPos+(width/4),yPos+(height/4),(int)(width*0.30),(int)(height*0.30));
		window.setColor(whiteColor);
		window.fillOval(xPos+(width/4),yPos+(height/4),(int)(width*0.20),(int)(height*0.20));
		window.setColor(orangeColor);
		window.fillOval(xPos+(width/4),yPos+(height/4),(int)(width*0.10),(int)(height*0.10));

		// window.setColor(Color.BLACK); //top left corner
		//       window.drawLine(xPos+20,yPos+20,xPos+(width/10),yPos+(height/10));
		//
		//       window.setColor(Color.BLACK); //bottom right corner
		//       window.drawLine(xPos+width-20,yPos+height-20,xPos+width+(width/10),yPos+height+(height/10));

		//window.setColor(Color.BLACK);
		//window.drawArc(xPos,yPos,width-30,height-30,180,360);

	}

	//BONUS
	//add in set and get methods for all instance variables

	public String toString()
	{
		return xPos+" "+yPos+" "+width+" "+height+" "+color;
	}
}
