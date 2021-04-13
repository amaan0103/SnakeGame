import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*public class GameFrame extends Frame implements WindowListener{
	GameFrame(){
		//this.setLayout(new BorderLayout());
		//this.setSize(600,600);
		this.add(new GamePanel());
		this.pack();
		this.setTitle("Snake");
		this.setResizable(false);
		this.addWindowListener(this);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void windowClosing(WindowEvent evt) {
      System.exit(0);
   }
   public void windowOpened(WindowEvent evt) { }
   public void windowClosed(WindowEvent evt) { }
   public void windowIconified(WindowEvent evt) { }
   public void windowDeiconified(WindowEvent evt) { }
   public void windowActivated(WindowEvent evt) { }
   public void windowDeactivated(WindowEvent evt) { } 
}*/
public class GameFrame extends JFrame{

	GameFrame(){
		/*Color c1 = JColorChooser.showDialog(this,"Choose Head Color",Color.CYAN);  
		Color c2 = JColorChooser.showDialog(this,"Choose Body Color",Color.CYAN);  
		this.add(new GamePanel(c1,c2));*/
		this.add(new GamePanel());
		//this.add(new StartPanel(this));
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
}