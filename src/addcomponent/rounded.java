/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addcomponent;

import java.awt.AWTEvent;
import java.awt.AWTEventMulticaster;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */

    
public class rounded extends JPanel {

    ActionListener actionListener;     // Post action events to listeners
    String label;                      // The Button's text
    protected boolean pressed = false; // true if the button is detented.
private JComponent component;
    /**
     * Constructs a RoundedButton with no label.
     */
    public rounded() {
        this("");
    }

    /**
     * Constructs a RoundedButton with the specified label.
     *
     * @param label the label of the button
     */
    public rounded(String label) {
        this.label = label;
           
	
		
	
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    }

    /**
     * gets the label
     *
     * @see setLabel
     */
    public String getLabel() {
        return label;
    }

    /**
     * sets the label
     *
     * @see getLabel
     */
    public void setLabel(String label) {
        this.label = label;
      
        invalidate();
        repaint();
    }

    /**
     * paints the RoundedButton
     */
    @Override
    public void paint(Graphics g) {
        setOpaque( false );
        // paint the interior of the button
        if (pressed) {
            g.setColor(getBackground());
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - (getHeight()/5)+10,100,100);

        // draw the perimeter of the button
        g.setColor(getBackground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - (getHeight()/5)+10, 100, 100);

        // draw the label centered in the button
        Font f = getFont();
        if (f != null) {
            FontMetrics fm = getFontMetrics(getFont());
            g.setColor(getForeground());
            g.drawString(label, getWidth() / 2 - fm.stringWidth(label) / 2 ,getHeight() / 2 + fm.getMaxDescent());
        }
       
    }

    /**
     * The preferred size of the button.
     */
    @Override
    public Dimension getPreferredSize() {
        Font f = getFont();
        
        if (f != null) {
            FontMetrics fm = getFontMetrics(getFont());
            int max = Math.max(fm.stringWidth(label) + 40, fm.getHeight() + 40);
            return new Dimension(max, max);
        } else {
            return new Dimension(100, 100);
        }
    }

    /**
     * The minimum size of the button.
     */
    @Override
    public Dimension getMinimumSize() {
        return new Dimension(100, 100);
    }

    /**
     * Adds the specified action listener to receive action events from this
     * button.
     *
     * @param listener the action listener
     */
    public void addActionListener(ActionListener listener) {
        actionListener = AWTEventMulticaster.add(actionListener, listener);
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    }

    /**
     * Removes the specified action listener so it no longer receives action
     * events from this button.
     *
     * @param listener the action listener
     */
    public void removeActionListener(ActionListener listener) {
        actionListener = AWTEventMulticaster.remove(actionListener, listener);
    }

    /**
     * Determine if click was inside round button.
     */
    @Override
    public boolean contains(int x, int y) {
        int mx = getSize().width / 2;
        int my = getSize().height / 2;
        return (((mx - x) * (mx - x) + (my - y) * (my - y)) <= mx * mx);
    }

    /**
     * Paints the button and distribute an action event to all listeners.
     */
    @Override
    public void processMouseEvent(MouseEvent e) {
        Graphics g;
        switch (e.getID()) {
            case MouseEvent.MOUSE_PRESSED:
                // render myself inverted....
                pressed = true;

                // Repaint might flicker a bit. To avoid this, you can use
                // double buffering (see the Gauge example).
                //this is the problem, that cause 25/12/2020    
                //repaint();
                break;
            case MouseEvent.MOUSE_RELEASED:
                if (actionListener != null) {
                    actionListener.actionPerformed(new ActionEvent(
                            this, ActionEvent.ACTION_PERFORMED, label));
                }
                // render myself normal again
                if (pressed == true) {
                    pressed = false;

                    // Repaint might flicker a bit. To avoid this, you can use
                    // double buffering (see the Gauge example).
//this is the problem, that cause 25/12/2020                  
//  repaint();
                }
                break;
            case MouseEvent.MOUSE_ENTERED:

                break;
            case MouseEvent.MOUSE_EXITED:
                if (pressed == true) {
                    // Cancel! Don't send action event.
                    pressed = false;

                    // Repaint might flicker a bit. To avoid this, you can use
                    // double buffering (see the Gauge example).
                    //this is the problem, that cause 25/12/2020    
                    //repaint();

                    // Note: for a more complete button implementation,
                    // you wouldn't want to cancel at this point, but
                    // rather detect when the mouse re-entered, and
                    // re-highlight the button. There are a few state
                    // issues that that you need to handle, which we leave
                    // this an an excercise for the reader (I always
                    // wanted to say that!)
                }
                break;
        }
        super.processMouseEvent(e);
    }
}


