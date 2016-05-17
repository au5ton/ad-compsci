import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
	private List<Alien> aliens;

   public AlienHorde(int size)
	{
      this(size,1);
	}

	public AlienHorde(int size, int speed)
	{
      //initalize ArrayList
      aliens = new ArrayList<Alien>();
      //and fill with size amount of aliens (75 pixels apart)
      int c = 25, r = 50;
      for(int i = 0; i < size; i++) {
         aliens.add(new Alien(r,c,speed));
         r += 75;
         if(r + aliens.get(i).getWidth() >= StarFighter.WIDTH) {
            r = 50;
            c += 75;
         }
      }
      //if your row is full (out of bounds of screen)
      //move down a row (75 pixels)
      //starting point is 25, 50
      //first add aliens with speed of 0
	}

	public void add(Alien al)
	{
      //add an al to the list
      aliens.add(al);
	}

	public void drawEmAll( Graphics window )
	{
      //make sure you draw all aliens in the list 
      for(Alien item : aliens) {
         item.draw(window);
      }
	}

	public void moveEmAll()
	{
      //make sure you move all aliens in the list 
      for(Alien item : aliens) {
         item.move("DOWN");
      }
	}
   public void removeDeadOnes(List<Ammo> shots)
	{
      //Part 3
      //for every shot in the list
      //check if you've hit any alien in the list
      //(do the coordinates of the shot fall between the boundarises of the alien)
      //if they do then remove the alien and the shot
      //make sure you break out of the loop if this happens
	   
      for(int i = 0; i < shots.size(); i++) {
         for(int j = 0; j < aliens.size(); j++) {
            if(shots.get(i).getX() >= aliens.get(j).getX() && shots.get(i).getX() <= aliens.get(j).getX()+aliens.get(j).getWidth())
               if(shots.get(i).getY() >= aliens.get(j).getY() && shots.get(i).getY() <= aliens.get(j).getY()+aliens.get(j).getHeight()) {
                  shots.remove(i);
                  aliens.remove(j);
               }
         }
      }
      
   }
   
   public boolean aliensVanquished() {
      return (aliens.size() == 0);
   }
   
	public String toString()
	{
		return "" + aliens;
	}
}
