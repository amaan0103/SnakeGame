import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.Timer;
public class GamePanel extends Panel implements ActionListener,KeyListener{
	static final int WIDTH=600;
	static final int HEIGHT=600;
	static final int UNIT_LENGTH=20;
	static final int GAME_LENGTH=(WIDTH*HEIGHT)/UNIT_LENGTH;
	static final int DELAY=125;
	static int count=1;
	//Color c1,c2;
	Timer timer;
	Random random;
	Font f;
	int score;
	int snakeLength=6;
	int foodX,foodY;
	char direction='R';
	boolean running=false;
	final int []x = new int[GAME_LENGTH];
	final int []y = new int[GAME_LENGTH];
	GamePanel(){
	/*GamePanel(Color c1, Color c2){
		this.c1=c1;
		this.c2=c2;*/
		random = new Random();
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		addKeyListener(this);
		f = new Font("INK FREE",Font.BOLD,20);
		startGame();
	}
	public void paint(Graphics g){
		if(!running){
			gameOver(g);
		}
		else{
			if(count%6!=0){
				g.setColor(Color.red);
				g.fillOval(foodX,foodY,UNIT_LENGTH,UNIT_LENGTH);
			}
			else{
				g.setColor(Color.white);
				g.fillRect(foodX,foodY,UNIT_LENGTH,UNIT_LENGTH);
				g.setColor(Color.black);
				g.fillRect(foodX+3,foodY+3,UNIT_LENGTH-6,UNIT_LENGTH-6);
			}
			for(int i=0;i<snakeLength;i++){
				if(i == 0) {
						g.setColor(Color.green);
						//g.setColor(c1);
						g.fillRect(x[i], y[i], UNIT_LENGTH, UNIT_LENGTH);
					}
				else {
					g.setColor(new Color(45,180,0));
					//g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
					g.fillRect(x[i], y[i], UNIT_LENGTH, UNIT_LENGTH);
					g.setColor(Color.black);
					g.fillRect(x[i]+3,y[i]+3, UNIT_LENGTH-6, UNIT_LENGTH-6);
					/*g.setColor(c2);
					g.fillRect(x[i], y[i], UNIT_LENGTH, UNIT_LENGTH);*/
				}
			}
			g.setColor(Color.white);
			g.setFont(f);
			g.drawString("SCORE: "+score,3*WIDTH/4,30);
		}
	}
	public void startGame(){
		newFood();
		running = true;
		timer = new Timer(DELAY,this);
		timer.start();
	}
	public void newFood(){
		foodX=random.nextInt((int)(WIDTH/UNIT_LENGTH-1))*UNIT_LENGTH;
		foodY=random.nextInt((int)(HEIGHT/UNIT_LENGTH-1))*UNIT_LENGTH;
		
	}
	public void move(){
		for(int i=snakeLength;i>0;i--){
			x[i]=x[i-1];
			y[i]=y[i-1];
		}
		switch(direction){
			case 'U':
				y[0]=y[0]-UNIT_LENGTH;
				break;
			case 'D':
				y[0]=y[0]+UNIT_LENGTH;
				break;
			case 'L':
				x[0]=x[0]-UNIT_LENGTH;
				break;
			case 'R':
				x[0]=x[0]+UNIT_LENGTH;
				break;
		}
		if(x[0] < 0) {
			x[0]=WIDTH;
		}
		if(x[0] > WIDTH) {
			x[0]=0;
		}
		if(y[0] < 0) {
			y[0]=HEIGHT;
		}
		if(y[0] > HEIGHT) {
			y[0]=0;
		}
	}
	public void checkCollision(){
		for(int i = snakeLength;i>0;i--) {
			if((x[0] == x[i])&& (y[0] == y[i])) {
				running = false;
			}
		}
		/*if(x[0] < 0) {
			running = false;
		}
		if(x[0] > WIDTH) {
			running = false;
		}
		if(y[0] < 0) {
			running = false;
		}
		if(y[0] > HEIGHT) {
			running = false;
		}*/
		
		
		if(!running) {
			timer.stop();
		}
	}
	public void checkFood(){
		if(x[0]==foodX && y[0]==foodY){
			snakeLength++;
			if(count%6!=0)	score++;
			else	score+=5;
			count++;
			newFood();
		}
	}
	public void gameOver(Graphics g){
		f = new Font("INK FREE",Font.ITALIC,40);
		g.setColor(Color.red);
		g.setFont(f);
		g.drawString("GAME OVER",WIDTH/2-40*3,HEIGHT/2);
		g.drawString("SCORE: "+score,WIDTH/2-50*2,HEIGHT/2-50);
	}
	public void actionPerformed(ActionEvent e){
		if(running){
			move();
			checkFood();
			checkCollision();
		}
		repaint();
	}
	public void keyPressed(KeyEvent evt){
		switch(evt.getKeyCode()){
			case KeyEvent.VK_UP:
				if(direction!='D')	direction='U';
				break;
			case KeyEvent.VK_DOWN:
				if(direction!='U')	direction='D';
				break;
			case KeyEvent.VK_LEFT:
				if(direction!='R')	direction='L';
				break;
			case KeyEvent.VK_RIGHT:
				if(direction!='L')	direction='R';
				break;
		}
	}
	public void keyTyped(KeyEvent evt) { }
   public void keyReleased(KeyEvent evt) { }
}