package spacepong;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePlay extends JPanel implements KeyListener , ActionListener{
	private boolean startGame = false;
	private int score = 0;
	private Timer time;
	private int delay = 20;
	private int lives = 3;
	private int playerX = 452;
	private int ballX = 10;
	private int ballY = 10;
	private int level = 1;
	private double ballXdir = 4.0*Math.pow(1.25, level-1);
	private double ballYdir = 1.0*Math.pow(1.25, level-1);
	
	
	public int getLevel() {
		return level;
	}
	private int countDown = 60;
	private int countDown2;
	
	Random random = new Random();
	private String[] gameObjects = {"meteorite", "star", "ufo"};
	
	
	private int[] imageTimes;
	private GameObject object1;
	private GameObject object2;
	private GameObject object3;
	private GameObject object4;
	private GameObject object5;
	private GameObject object6;
	private boolean object11;
	private boolean object22;
	private boolean object33;
	private boolean object44;
	private boolean object55;
	private boolean object66;
	private JPanel top;
	private JPanel bot;
	public JPanel getTop() {
		return top;
	}
	public void setTop(JPanel top) {
		this.top = top;
	}
	public JPanel getBot() {
		return bot;
	}
	public void setBot(JPanel bot) {
		this.bot = bot;
	}
	
	public GamePlay() {
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		time = new Timer(delay ,this);
		time.start();
		
		
	}
	public void paint(Graphics g) {
		//background and middle panel
		g.setColor(Color.white);
		g.fillRect(0,0,1024,768);
		
		
		// players paddle
		g.setColor(Color.black);
		g.fillRect(playerX, 600, 120, 10);
		
		//ball
		g.setColor(Color.red);
		g.fillOval(ballX, ballY, 20, 20);
		
		
		if(object11) {
			if(object1.isVisibility()) {
		
			g.drawImage(object1.imageReader(), object1.getX(), object1.getY(), 
					object1.getWidth(), object1.getHeight(), this);
			}
		}
		if(object22) {
			if(object2.isVisibility()) {
			g.drawImage(object2.imageReader(), object2.getX(), object2.getY(), 
					object2.getWidth(), object2.getHeight(), this);
			}
		}
		if(object33) {
			if(object3.isVisibility()) {
			g.drawImage(object3.imageReader(), object3.getX(), object3.getY(), 
					object3.getWidth(), object3.getHeight(), this);
			}
		}
		if(object44) {
			if(object4.isVisibility()) {
			g.drawImage(object4.imageReader(), object4.getX(), object4.getY(), 
					object4.getWidth(), object4.getHeight(), this);
		}}
		if(object55) {
			if(object5.isVisibility()) {
			g.drawImage(object5.imageReader(), object5.getX(), object5.getY(), 
					object5.getWidth(), object5.getHeight(), this);
		}}
		if(object66) {
			if(object6.isVisibility()) {
			g.drawImage(object6.imageReader(), object6.getX(), object6.getY(), 
					object6.getWidth(), object6.getHeight(), this);
		}}
		if(countDown ==0) {
			startGame = false;
		}
		
		
		g.dispose();
		
	}
	public void resetGame() {
		startGame = false;
		score = 0;
		
		
		lives = 3;
		playerX = 452;
		ballX = 10;
		ballY = 10;
		level = 1;
		ballXdir = 4.0*Math.pow(1.25, level-1);
		ballYdir = 1.0*Math.pow(1.25, level-1);

		countDown = 60;
		countDown2=0;
	

		object11 = false;
		object22 = false;
		object33 = false;
		object44 = false;
		object55 = false;
		object66 = false;
		
		
	}
	public void nextLive() {
		lives -=1;
		startGame = false;
		playerX = 452;
		ballX = 10;
		ballY = 10;
		ballXdir = 4.0*Math.pow(1.25, level-1);
		ballYdir = 1.0*Math.pow(1.25, level-1);
		

		object11 = false;
		object22 = false;
		object33 = false;
		object44 = false;
		object55 = false;
		object66 = false;
	}
	public void nextLevel() {
		startGame = false;
		playerX = 452;
		ballX = 10;
		ballY = 10;
		level += 1;
		ballXdir = 4.0*Math.pow(1.25, level-1);
		ballYdir = 1.0*Math.pow(1.25, level-1);
		
		countDown = 60;
		countDown2=0;
	

		object11 = false;
		object22 = false;
		object33 = false;
		object44 = false;
		object55 = false;
		object66 = false;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (bot !=null){
			Main.botCheck();
		}
		if (top !=null){
			Main.recreateFields();
		}
		imageTimes = imageTimer();
		time.start();
		
		if(countDown ==0) {
			nextLevel();
		}
		if(lives ==0) {
			resetGame();
			
		}
		if(startGame) {
			calculateTime();
			imageRegulator();
			
			if(object11){
				checkIntersection(object1);
			}
			if(object22){
				checkIntersection(object2);
			}
			if(object33) {
				checkIntersection(object3);
			}
			if(object44) {
				checkIntersection(object4);
			}
			if(object55) {
				checkIntersection(object5);
			}
			if(object66) {
				checkIntersection(object6);
			}
			if(new Rectangle(ballX,ballY,20,20).intersects(new Rectangle(playerX,600,120,10))) {
				ballYdir = -ballYdir;
				score+=10;
			}
			
			ballX += ballXdir;
			ballYdir+= 9.8* time.getDelay()/2000;
			ballY += ballYdir;
			if (ballX < 0 ) {
				ballXdir = -ballXdir;
			}
			if (ballX > 1004 ) {
				ballXdir = -ballXdir;
			}
			if (ballY < 0 ) {
				ballYdir = -ballYdir;
			}
			if(ballY > 600 ) {
				
				nextLive();
			}
			
		}
		repaint();
		
		
	}
	
	
	public int getCountDown() {
		return countDown;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX >= 865) {
				playerX = 895;
			}
			else {
				moveRight();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(playerX <= 2) {
				playerX = 2;
			}
			else {
				moveLeft();
			}
		}
		
	}
	public void moveRight() {
		if(startGame == true) {
			playerX +=30;
		}
		
		
	}
	public void moveLeft() {
		if(startGame == true) {
			playerX -=30;
		}
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	private void calculateTime() {
		this.countDown2++;
		if (countDown2%(1000/time.getDelay()) == 0) {
			this.countDown -=1;
		}
	}
	private int[] imageTimer() {
		int[] timers = {random.nextInt(10),
				random.nextInt(10)+10,
				random.nextInt(10)+20,
				random.nextInt(10)+30,
				random.nextInt(10)+40,
				random.nextInt(10)+50};  
		return timers;
	}
	private void imageRegulator() {
		if(countDown == imageTimes[0] && object11 != true) {
			object1 = new GameObject(gameObjects[random.nextInt(3)],2);
			object1.setVisibility(true);
			object11 = true;
			
		}
		if(countDown == imageTimes[1] && object22 != true) {
			object2 = new GameObject(gameObjects[random.nextInt(3)],1);
			object2.setVisibility(true);
			object22 = true;
		}
		if(countDown == imageTimes[2] && object33 != true) {
			 object3 = new GameObject(gameObjects[random.nextInt(3)],3);
			 object3.setVisibility(true);
			 object33 = true;
		}
		if(countDown == imageTimes[3] && object44 != true) {
			 object4 = new GameObject(gameObjects[random.nextInt(3)],5);
			 object4.setVisibility(true);
			 object44 = true;
		}
		if(countDown == imageTimes[4] && object55 != true) {
			 object5 = new GameObject(gameObjects[random.nextInt(3)],4);
			 object5.setVisibility(true);
			 object55 = true;
		}
		if(countDown == imageTimes[5] && object66 != true) {
			 object6 = new GameObject(gameObjects[random.nextInt(3)],0);
			 object6.setVisibility(true);
			 object66 = true;
		}
	}
	private void checkIntersection(GameObject x) {
		if(new Rectangle(x.getX(),x.getY(),x.getWidth(),x.getHeight()).intersects(new Rectangle(ballX,ballY,20,20))
				&& x.getName().equals("meteorite") && x.isVisibility() == true ) {
			ballXdir *=1.25;
			ballYdir *=1.25;
			x.setVisibility(false);
		}
		if(new Rectangle(x.getX(),x.getY(),x.getWidth(),x.getHeight()).intersects(new Rectangle(ballX,ballY,20,20))
				&& x.getName().equals("ufo")&& x.isVisibility() == true) {
			x.setVisibility(false);
			lives -=1;
		}
		if(new Rectangle(x.getX(),x.getY(),x.getWidth(),x.getHeight()).intersects(new Rectangle(ballX,ballY,20,20))
				&& x.getName().equals("star")&& x.isVisibility() == true) {
			score +=100;
			x.setVisibility(false);
		}
	}
	public int getLives() {
		return lives;
	}
	public boolean isStartGame() {
		return startGame;
	}
	public void setStartGame(boolean startGame) {
		this.startGame = startGame;
	}
}
  