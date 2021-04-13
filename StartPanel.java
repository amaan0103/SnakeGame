import java.awt.*;
import java.awt.event.*;
public class StartPanel extends Panel implements ActionListener{
	GameFrame gf;
	Label gameName;
	Button start;
	public StartPanel(GameFrame gf){
		this.gf=gf;
		setLayout(new GridLayout(5,1));
		setBackground(Color.gray);
		gameName=new Label("VENOM");
		//gameName.setPreferredSize(new Dimension(100,100));
		this.setPreferredSize(new Dimension(600,600));
		add(gameName);
		start = new Button("Start");
		start.addActionListener(this);
		add(start);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource()==start){
			//gf.remove(this);
			System.out.print("LOL");
			gf.add(new GamePanel());
		}
	}
}