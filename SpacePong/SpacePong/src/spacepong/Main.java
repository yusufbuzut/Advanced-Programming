package spacepong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.w3c.dom.css.Counter;

public class Main {
	private static JTextField score;
	private static JTextField live ;
	private static JTextField time ;
	private static JTextField level ;
	private static GamePlay gamePlay;
	private static JButton startButton;
	public static void main(String[] args) {
		JFrame object = new JFrame();
		
		gamePlay = new GamePlay();
		//top and bottom panels
		JPanel panelTop = new JPanel();
		JPanel panelBot = new JPanel();
		
		//start/pause button
		 startButton = new JButton("Start Game");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gamePlay.isStartGame()) {
					gamePlay.setStartGame(false);
					startButton.setText("Start Game");
				}
				else if(!gamePlay.isStartGame()){
					gamePlay.setStartGame(true);
					startButton.setText("Pause Game");
				}
				
			}
			
		});
		score = new JTextField("Score:"+gamePlay.getScore() ,15);
		 live = new JTextField("Remaining Lives:"+gamePlay.getLives(),15 );
		 time = new JTextField("Remaining Time:"+ gamePlay.getCountDown() ,15);
		 level = new JTextField("Level:"+gamePlay.getLevel() ,15);
		
		score.setFocusable(false);
		time.setFocusable(false);
		level.setFocusable(false);
		live.setFocusable(false);
		panelTop.add(level);
		panelTop.add(live);
		panelTop.add(time);
		panelTop.add(score);
		gamePlay.setTop(panelTop);
		gamePlay.setBot(panelBot);
		startButton.setFocusable(false);
		panelTop.setBackground(Color.orange);
		
		
		panelBot.setBackground(Color.orange);
		panelBot.add(startButton);
		panelBot.setFocusable(false);
		panelTop.setFocusable(false);
		
		object.add(panelBot, BorderLayout.SOUTH);
		object.add(panelTop, BorderLayout.NORTH);
		
		object.setBounds(0, 0, 1024, 768);
		object.setTitle("Spacepong Game");
		object.setResizable(false);
		object.setVisible(true);
		object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		object.add(gamePlay, BorderLayout.CENTER);
	}
	public static void recreateFields() {
		score.setText("Score:"+gamePlay.getScore() );
		live.setText("Remaining Lives:"+gamePlay.getLives() );
		time.setText("Remaining Time:"+ gamePlay.getCountDown() );
		level.setText("Level:"+gamePlay.getLevel() );
		
	}
	public static void botCheck() {
		if(gamePlay.isStartGame() == true) {
			startButton.setText("Pause Game");
		}
		if(gamePlay.isStartGame()== false) {
			startButton.setText("Start Game");
		}
	}
}
