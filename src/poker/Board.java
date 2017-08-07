package poker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board implements ActionListener{
	
	public static final int WIDTH = 800, HEIGHT = 600;
	public static Board board;
	public Renderer renderer;
	public String card;
	public Image cardImg;
	public static Rectangle hand1, hand2,opHand1, opHand2;
	public static Rectangle deck, com1, com2, com3, com4, com5;
	public JButton check, raise, bet, fold;
	

	public static void createBoard(){
		
		board = new Board();

	}
	
	public Board(){
		
		Timer timer = new Timer(20, this);
		renderer = new Renderer();
		
		JFrame frame = new JFrame("Poker");
		
		frame.add(renderer);
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		setupCards();
		setupButtons();
		
		frame.add(panel);
		
		
		panel.add(check);
		panel.add(bet);
		panel.add(raise);
		panel.add(fold);
		
		timer.start();
	}
	
	public static void setupCards() {
		
		final int CARDWIDTH = 100, CARDHEIGHT = 150;
		
		hand1 = new Rectangle((WIDTH/2) - 300, (HEIGHT/2) + 100, CARDWIDTH, CARDHEIGHT);
		hand2 = new Rectangle((WIDTH/2) - 240, (HEIGHT/2) + 100, CARDWIDTH, CARDHEIGHT);
	
		opHand1 = new Rectangle((WIDTH/2) + 150, (HEIGHT/2) + 100, CARDWIDTH, CARDHEIGHT);
		opHand2 = new Rectangle((WIDTH/2) + 210, (HEIGHT/2) + 100, CARDWIDTH, CARDHEIGHT);
		
		deck = new Rectangle((WIDTH/2) - 380, (HEIGHT/2 - 160), CARDWIDTH, CARDHEIGHT);
		
		com1 = new Rectangle((WIDTH/2) - 270, (HEIGHT/2) - 130, CARDWIDTH, CARDHEIGHT);
		com2 = new Rectangle((WIDTH/2) - 160, (HEIGHT/2) - 130, CARDWIDTH, CARDHEIGHT);
		com3 = new Rectangle((WIDTH/2) - 50, (HEIGHT/2) - 130, CARDWIDTH, CARDHEIGHT);
		com4 = new Rectangle((WIDTH/2) + 60, (HEIGHT/2) - 130, CARDWIDTH, CARDHEIGHT);
		com5 = new Rectangle((WIDTH/2) + 170, (HEIGHT/2) - 130, CARDWIDTH, CARDHEIGHT);
	}
	
	public void setupButtons(){
		check = new JButton("Check");
			check.setBounds(0,	0,	WIDTH/4,	HEIGHT - 500);
			
		bet = new JButton("Bet");
			bet.setBounds(WIDTH/4,	0,	WIDTH/4,	HEIGHT-500);
			
		raise = new JButton("Raise");
			raise.setBounds(WIDTH/2,	0,	WIDTH/4, HEIGHT-500);
			
		fold = new JButton("Fold");
			fold.setBounds(WIDTH - (WIDTH/4),	0,	WIDTH/4,	HEIGHT-500);
	}

	public void repaint(Graphics g){
		
		System.out.println("hi");
		
		g.setColor(Color.GREEN.darker());
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.RED.darker());
		g.fillRect(0, 0, WIDTH, HEIGHT - 500);
		
		g.setColor(Color.BLACK);
		
		cardImg = new ImageIcon("src\\img\\cards\\back.png").getImage();
		g.drawImage(cardImg, hand1.x, hand1.y, hand1.width, hand1.height, renderer);
		g.drawRect(hand1.x, hand1.y, hand1.width, hand1.height);
		
		cardImg = new ImageIcon("src\\img\\cards\\back.png").getImage();
		g.drawImage(cardImg, hand2.x, hand2.y, hand2.width, hand2.height, renderer);
		g.drawRect(hand2.x, hand2.y, hand2.width, hand2.height);
		
		cardImg = new ImageIcon("src\\img\\cards\\back.png").getImage();
		g.drawImage(cardImg, opHand1.x, opHand1.y, opHand1.width, opHand1.height, renderer);
		g.drawRect(opHand1.x, opHand1.y, opHand1.width, opHand1.height);
		g.drawImage(cardImg, opHand2.x, opHand2.y, opHand2.width, opHand2.height, renderer);
		g.drawRect(opHand2.x, opHand2.y, opHand2.width, opHand2.height);
		
		cardImg = new ImageIcon("src\\img\\cards\\back.png").getImage();
		g.drawImage(cardImg, com1.x, com1.y, com1.width, com1.height, renderer);
		g.drawRect(com1.x, com1.y, com1.width, com1.height);

		cardImg = new ImageIcon("src\\img\\cards\\back.png").getImage();
		g.drawImage(cardImg, com2.x, com2.y, com2.width, com2.height, renderer);
		g.drawRect(com2.x, com2.y, com2.width, com2.height);
		
		cardImg = new ImageIcon("src\\img\\cards\\back.png").getImage();
		g.drawImage(cardImg, com3.x, com3.y, com3.width, com3.height, renderer);
		g.drawRect(com3.x, com3.y, com3.width, com3.height);

		cardImg = new ImageIcon("src\\img\\cards\\back.png").getImage();
		g.drawImage(cardImg, com4.x, com4.y, com4.width, com4.height, renderer);
		g.drawRect(com4.x, com4.y, com4.width, com4.height);
		
		cardImg = new ImageIcon("src\\img\\cards\\back.png").getImage();
		g.drawImage(cardImg, com5.x, com5.y, com5.width, com5.height, renderer);
		g.drawRect(com5.x, com5.y, com5.width, com5.height);

		g.setColor(Color.YELLOW);
		g.setFont(new Font("Arial", 1, 45));
		g.drawString("Pot", WIDTH/2 - 20, HEIGHT - 150);
		g.setFont(new Font("Arial", 1, 36));
		g.drawString("$" + "2000", WIDTH/2 - 30, HEIGHT - 100);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//System.out.println("hi");
		
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}
}
