package view;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;

public class Jframe extends JFrame implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Jframe() {
		this.setTitle("TRON");
		this.setSize(400, 600);
	    this.setLocationRelativeTo(null);               
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setContentPane(new Jpanel());
	    this.setVisible(true);
	    addKeyListener(this);
	    requestFocusInWindow();

	}

	@Override
	public void keyPressed(KeyEvent key) {
		// TODO Auto-generated method stub
		int keycode = key.getKeyCode();
			
			switch(keycode)// Les valeurs sont contenue dans KeyEvent. Elles commencent par VK_ et finissent par le nom de la touche
			{
			case KeyEvent.VK_Q:
				fonction_gauche();
				break;
			case KeyEvent.VK_D:
				fonction_droite();
				break;
			}
	}

	private void fonction_gauche() {
		// TODO Auto-generated method stub
		
	}

	private void fonction_droite() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent key) {
		// TODO Auto-generated method stub
		//touche relachée
	}

	@Override
	public void keyTyped(KeyEvent key) {
		// TODO Auto-generated method stub
		//touche appuyée
	}
}
