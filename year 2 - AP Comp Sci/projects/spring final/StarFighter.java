//This is done
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StarFighter extends JFrame
{
	public static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public StarFighter()
	{
		super("STARFIGHTER");
		setSize(297,528);

		JPanel panel = new JPanel();
		add(panel);

		JLabel title = new JLabel(new ImageIcon("starfighter.png"));
		panel.add(title);

		JButton button = new JButton("Easy");
		panel.add(button);
		button.addActionListener(new Action1());

		JButton button2 = new JButton("Medium");
		panel.add(button2);
		button2.addActionListener(new Action2());

		JButton button3 = new JButton("Hard");
		panel.add(button3);
		button3.addActionListener(new Action3());

		JButton button4 = new JButton("?");
		panel.add(button4);
		button4.addActionListener(new Action4());
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
      
	}

	public static void main( String args[] )
	{
		StarFighter run = new StarFighter();
	}
   
   static class Action1 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			JFrame frame1 = new JFrame("STARFIGHTER -- Easy Game");
			frame1.setVisible(true);
			frame1.setSize(WIDTH,HEIGHT);

         OuterSpace theGame = new OuterSpace(5,20,1);
		   ((Component)theGame).setFocusable(true);

			frame1.getContentPane().add(theGame);

			frame1.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    System.exit(0);//cierra aplicacion
                }
            });

		}
	}
	static class Action2 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			JFrame frame2 = new JFrame("STARFIGHTER -- Medium Game");
			frame2.setVisible(true);
			frame2.setSize(WIDTH,HEIGHT);

         OuterSpace theGame = new OuterSpace(4,30,2);
		   ((Component)theGame).setFocusable(true);

			frame2.getContentPane().add(theGame);

			frame2.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    System.exit(0);//cierra aplicacion
                }
            });


		}
	}
	static class Action3 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			JFrame frame3 = new JFrame("STARFIGHTER -- Hard Game");
			frame3.setVisible(true);
			frame3.setSize(WIDTH,HEIGHT);

         OuterSpace theGame = new OuterSpace(3,40,3);
		   ((Component)theGame).setFocusable(true);

			frame3.getContentPane().add(theGame);

			frame3.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    System.exit(0);//cierra aplicacion
                }
            });


		}
	}

	static class Action4 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			JOptionPane.showMessageDialog(null,
			"Evil space kittens are attacking Mrs.Rendon's pugs\n"+
         "It\'s your reponsibility to save them!\n"+
         "Easy difficulty gives you a fast ship with 20 slow aliens\n"+
			"Medium difficulty gives you a slower ship with 30 faster aliens\n"+
			"Hard difficulty gives you a slowest ship with 40 fastest aliens\n"
			, "How to Play MineSweeper", JOptionPane.QUESTION_MESSAGE);

		}
	}
   
}