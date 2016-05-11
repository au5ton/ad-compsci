import java.awt.Color;
import java.awt.Graphics;

public abstract class MovingThing implements Moveable
{
	//add instance variables
   private int x, y, width, height;

   public MovingThing()
   {
      this(10,10,10,10);
   }

   public MovingThing(int x, int y)
   {
   	//add code here
      this(x,y,10,10);
   }

   public MovingThing(int x, int y, int w, int h)
   {
   	//add code here
      this.x = x;
      this.y = y;
      this.width = w;
      this.height = h;
   }

	//add necessary implementations
   
   public void setPos( int x, int y) {
      this.x = x;
      this.y = y;
   }
   public void setX( int x ) {
      this.x = x;
   }
   public void setY( int y ) {
      this.y = y;
   }
   public int getX() {
      return this.x;
   }
   public int getY() {
      return this.y;
   }
   public int getWidth() {
      return this.width;
   }
   public int getHeight() {
      return this.height;
   }
   public void setWidth( int w ) {
      this.width = w;
   }
   public void setHeight( int h ) {
      this.height = h;
   }
   
   
   public abstract void move(String direction);
   public abstract void draw(Graphics window);

   public String toString()
   {
      return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
   }
}