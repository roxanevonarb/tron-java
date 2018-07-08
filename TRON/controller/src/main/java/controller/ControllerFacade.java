package controller;

import model.ITronModel;
import view.IView;

public class GameControler implements IController {
	
	IView view ;
	ITronModel model;
	
	public GameControler(ITronModel model , IView view) {
		this.model=model;
		this.view=view;
		
		
		
	}
	
	
	
	
	public void play(){
		
		while(model.getGrid().getRider1().isAlive() && model.getGrid().getRider2().isAlive()) {
			model.getGrid().getRider1().move();
			if(model.getGrid().getRider1().isAlive() == false)
				this.view.displayMessage("Rider 2 Win (Blue)");
			
			
			
			
			model.getGrid().getRider2().move();
			if(model.getGrid().getRider2().isAlive() == false)
				this.view.displayMessage("Rider 1 Win (Red) ");
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
