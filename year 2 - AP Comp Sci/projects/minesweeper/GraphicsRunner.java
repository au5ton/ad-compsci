//import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicsRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public GraphicsRunner()
	{
		super("Minesweeper -- Main Menu");
		setSize(297,528);

		JPanel panel = new JPanel();
		add(panel);

		JLabel title = new JLabel(new ImageIcon("minesweeper3.png"));
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

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		GraphicsRunner run = new GraphicsRunner();
	}

	static class Action1 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			JFrame frame1 = new JFrame("Minesweeper -- Easy Game");
			frame1.setVisible(true);
			frame1.setSize(WIDTH,HEIGHT);

			frame1.getContentPane().add(new Minesweeper(10,10,10)); //10% of squares are bombs

			frame1.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    System.exit(0);//cierra aplicacion
                }
            });

		}
	}
	static class Action2 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			JFrame frame2 = new JFrame("Minesweeper -- Medium Game");
			frame2.setVisible(true);
			frame2.setSize(WIDTH,HEIGHT);

			frame2.getContentPane().add(new Minesweeper(60,20,20)); //15% of squares are bombs

			frame2.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    System.exit(0);//cierra aplicacion
                }
            });

		}
	}
	static class Action3 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			JFrame frame3 = new JFrame("Minesweeper -- Hard Game");
			frame3.setVisible(true);
			frame3.setSize(WIDTH,HEIGHT);

			frame3.getContentPane().add(new Minesweeper(125,25,25)); //20% of squares are bombs

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
			"Easy difficulty populates 10% of squares with bombs in a 10x10 grid\n"+
			"Medium difficulty populates 15% of squares with bombs in a 20x20 grid\n"+
			"Hard difficulty populates 20% of squares with bombs in a 25x25 grid\n"+
			"Randomly click and hope you don\'t hit red! The numbers mean something."
			, "How to Play MineSweeper", JOptionPane.QUESTION_MESSAGE);

		}
	}
}
