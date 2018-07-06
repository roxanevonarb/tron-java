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
