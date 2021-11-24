package SnakeGamePack;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.*;

public class SnakeGame {
	final static int map[][] = new int[][] { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
//19*17
	static JFrame f = new JFrame("SnakeGame");
	static int MapX = 30, MapY = 30;
	static JLabel labels[][] = new JLabel[17][19];
	static int HeadX = 5;
	static int HeadY = 8;
	static String Head_Direction = "Right";
	static String Last_Direction = "Right";
	static int Apples = 5;
	static Queue<Integer> XBodyQueue = new LinkedList<>();
	static Queue<Integer> YBodyQueue = new LinkedList<>();
	static int BodyCount = 0;
	static Boolean GameOver = false;
	static int BodyPaintingX = 6;
	static int BodyPaintingY = 8;
	static Color HeadColor = new Color(120,148,111);	//머리색상
	static Color BodyColor = new Color(137,169,127);	//몸색상

	public static class Snake {
		public static void SnakeMove(int HeadX, int HeadY, String Direction) {
			Head_Direction = Direction;
			if (Head_Direction == "Left") {
				labels[HeadY][HeadX].setBackground(HeadColor);
			} else if (Head_Direction == "Right") {
				labels[HeadY][HeadX].setBackground(HeadColor);
			} else if (Head_Direction == "Up") {
				labels[HeadY][HeadX].setBackground(HeadColor);
			} else if (Head_Direction == "Down") {
				labels[HeadY][HeadX].setBackground(HeadColor);
			}
		}

		public static void SnakeMove(int HeadX, int HeadY) {
			if (Head_Direction == "Left") {
				labels[HeadY][HeadX--].setBackground(Color.GREEN);
				System.out.println(HeadY + " " + HeadX);
			} else if (Head_Direction == "Right") {
				labels[HeadY][HeadX++].setBackground(Color.GREEN);
				System.out.println(HeadY + " " + HeadX);
			} else if (Head_Direction == "Up") {
				labels[HeadY--][HeadX].setBackground(Color.GREEN);
				System.out.println(HeadY + " " + HeadX);
			} else if (Head_Direction == "Down") {
				labels[HeadY++][HeadX].setBackground(Color.GREEN);
				System.out.println(HeadY + " " + HeadX);
			}
		}
	}

	static class key implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == 37) { // 왼쪽
				if (Last_Direction != "Right")
					Head_Direction = "Left";
			} else if (e.getKeyCode() == 38) { // 위
				if (Last_Direction != "Down")
					Head_Direction = "Up";
			} else if (e.getKeyCode() == 39) { // 오른쪽
				if (Last_Direction != "Left")
					Head_Direction = "Right";
			} else if (e.getKeyCode() == 40) { // 아래
				if (Last_Direction != "Up")
					Head_Direction = "Down";
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

	}

	public static void main(String[] args) {
		f.setLocation(500, 500);
		f.setSize(586, 549);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);

//		boolean Sw = true;
//		JButton StartButton = new JButton("게임 시작"); 
//		StartButton.setBounds(440,400,200,50);
//		f.getContentPane().add(StartButton); //프레임 컨텐츠에 버튼 추가
//		StartButton.addActionListener(event -> { //버튼이 눌린다면
//			
//        });

		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 19; j++) {
				if (map[i][j] == 1) {
					labels[i][j] = new JLabel();
					labels[i][j].setOpaque(true);
					labels[i][j].setBackground(Color.black);
					labels[i][j].setBounds(MapX * j, MapY * i, 30, 30);
					f.getContentPane().add(labels[i][j]);
				} else if (map[i][j] == 0) {
					labels[i][j] = new JLabel();
					labels[i][j].setOpaque(true);
					if ((i + j) % 2 == 1)
						labels[i][j].setBackground(Color.white);
					else
						labels[i][j].setBackground(Color.LIGHT_GRAY);
					labels[i][j].setBounds(MapX * j, MapY * i, 29, 29);
					f.getContentPane().add(labels[i][j]);
				} else if (map[i][j] == 3) {
					labels[i][j] = new JLabel();
					labels[i][j].setOpaque(true);
					labels[i][j].setBackground(Color.red);
					labels[i][j].setBounds(MapX * j, MapY * i, 29, 29);
					f.getContentPane().add(labels[i][j]);
				}
			}
		}
		f.setVisible(true);
		f.addKeyListener(new key());
		while (GameOver == false) {
			if (Head_Direction == "Left") { // 왼쪽
				Last_Direction = "Left";
				Snake.SnakeMove(--HeadX, HeadY, "Left");
			} else if (Head_Direction == "Up") { // 위
				Last_Direction = "Up";
				Snake.SnakeMove(HeadX, --HeadY, "Up");
			} else if (Head_Direction == "Right") { // 오른쪽
				Last_Direction = "Right";
				Snake.SnakeMove(++HeadX, HeadY, "Right");
			} else if (Head_Direction == "Down") { // 아래
				Last_Direction = "Down";
				Snake.SnakeMove(HeadX, ++HeadY, "Down");
			}
			labels[BodyPaintingY][BodyPaintingX].setBackground(BodyColor);
			try {

				Thread.sleep(100); // 0.1초 대기

			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			if (map[HeadY][HeadX] == 1) {
				GameOver = true;
			} else if (map[HeadY][HeadX] == 2) {
				GameOver = true;
			} else if (map[HeadY][HeadX] == 3) {
				Apples++;
				map[HeadY][HeadX] = 0;
				Random rand = new Random();
				while (true) {
					int apX = rand.nextInt(17) + 1; // 1~17
					int apY = rand.nextInt(15) + 1; // 1~15
					if (map[apY][apX] != 2 && (apY != HeadY || apX != HeadX)) {
						map[apY][apX] = 3;
						labels[apY][apX].setBackground(Color.red);
						break;
					}
				}
			}

			if (BodyCount == Apples) {
				XBodyQueue.add(HeadX);
				YBodyQueue.add(HeadY);
				map[HeadY][HeadX] = 2;
				if ((YBodyQueue.peek() + XBodyQueue.peek()) % 2 == 1)
					labels[YBodyQueue.peek()][XBodyQueue.peek()].setBackground(Color.white);
				else
					labels[YBodyQueue.peek()][XBodyQueue.peek()].setBackground(Color.LIGHT_GRAY);
				map[YBodyQueue.poll()][XBodyQueue.poll()] = 0;
			} else {
				BodyCount++;
				XBodyQueue.add(HeadX);
				YBodyQueue.add(HeadY);
				map[HeadY][HeadX] = 2;
			}
			
			BodyPaintingX = HeadX;
			BodyPaintingY = HeadY;
		}
	}
}
