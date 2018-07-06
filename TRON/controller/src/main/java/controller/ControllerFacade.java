package Game;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

	private String name;
	private int direction, points, intvisibleStepCount;
	private LengthNode head;
	private Color color;
	private boolean canFire;
	private boolean isVisible, flicker;


	public static int UP = 1, DOWN = 2, LEFT = 3, RIGHT = 4;


	public static int PIX_PER_STEP = 5, THIKNES = 5;

	public Player(String name, int direction, Color color, int x, int y, int point)
	{
		this.name = name;
		this.direction = direction;
		this.color = color;
		head = new LengthNode(x, y, null);
		canFire = true;
		points = point;
		isVisible = true;
		flicker = false;
		intvisibleStepCount = 0;
	}



	public boolean isCanFire() {
		return canFire;
	}

	public void setIsVisible(boolean bol)
	{
		isVisible = bol;
	}

	public void setCanFire(boolean canFire) {
		this.canFire = canFire;
	}

	public boolean getCanFire() {
		return canFire;
	}



	public int getPoints() {
		return points;
	}

	public void addPoints() {
		this.points++;
	}

	public String getName() {
		return name;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}



	public int getDirection() {
		return direction;
	}



	public LengthNode getHead() {
		return head;
	}

	public void step()
	{
		switch(direction)
		{
		case 1: 		//haut
			head = new LengthNode(head.getX(), head.getY() - PIX_PER_STEP, head);
			break;
		case 2: 		//bas
			head = new LengthNode(head.getX(), head.getY() + PIX_PER_STEP, head);
			break;
		case 3: 		//gauche
			head = new LengthNode(head.getX() - PIX_PER_STEP, head.getY(), head);
			break;
		case 4: 		//droite
			head = new LengthNode(head.getX() + PIX_PER_STEP, head.getY(), head);
			break;
		}

		if(!isVisible)
			intvisibleStepCount++;
		if(intvisibleStepCount == 300)
			isVisible = true;
	}



	public boolean loosed(Player other, int maxWidth, int maxHeight)
	{
		//joueur se touche lui-même
		for(LengthNode p = head.getNext(); p.getNext() != null ; p = p.getNext())
			if(head.sameValues(p))
				return true;
		//il touche un autre joueur
		for(LengthNode p = other.getHead(); p.getNext() != null ; p = p.getNext())
			if(head.sameValues(p))
				return true;
		//il touche les bordures
		if(head.getX() < 0 || head.getY() < 0 || head.getX() > maxWidth + THIKNES || head.getY() > maxHeight + THIKNES)
			return true;

		return false;
	}


	public void draw(Graphics g)
	{
		g.setColor(color);
		LengthNode p = head;
		if(isVisible)
			for(;p != null; p=p.getNext())
				g.fillRect(p.getX(), p.getY(), THIKNES, THIKNES);	//tous les joueurs
		else 
			if(flicker){
				for(;p != null; p=p.getNext())
					g.fillRect(p.getX(), p.getY(), THIKNES, THIKNES);
				flicker = false;
			}else{
				g.fillRect(p.getX(), p.getY(), THIKNES, THIKNES);
				int flickerOdds = (int)(Math.random() * 10);
				if(flickerOdds < 1)
					flicker = true;
			}
	}

}
