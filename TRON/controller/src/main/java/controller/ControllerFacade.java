package controller;

import java.sql.SQLException;
import java.util.List;
import model.Example;
import model.IModel;
import view.IView;
package controller;
import java.sql.SQLException;
import java.util.List;
import model.Example;
import model.IModel;
import view.IView;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Biker {

    public enum Direction {
        NORD,
        SUD,
        EST,
        OUEST
    }

    private int x = 0;
    private int y = 0;

    private int player;

    public String name;

    private Direction direction;

    public Biker(int player, String name) {
        this.player = player;
        this.name = name;
        reset();
    }

    public void reset() {
        if(player == 1) direction = Direction.EST;
        if(player == 2) direction = Direction.OUEST;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController {

    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
    }

   
    
    
    
    
    public void start() throws SQLException {
        this.getView().displayMessage(this.getModel().getExampleById(1).toString());

        this.getView().displayMessage(this.getModel().getExampleByName("Example 2").toString());

        final List<Example> examples = this.getModel().getAllExamples();
        final StringBuilder message = new StringBuilder();
        for (final Example example : examples) {
            message.append(example);
            message.append('\n');
        }
        this.getView().displayMessage(message.toString());
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }
}
