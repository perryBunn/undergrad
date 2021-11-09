import greenfoot.*;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.List;

/**
 * Plotter is an actor that plots a graph of the population of two Greenfoot actor
 * classes. You would usually only create one single actor of this class.
 * 
 * @author M Kölling
 * @version 1.0
 */
public class Plotter extends Actor
{
    private static final Color LIGHT_GRAY = new Color(0, 0, 0, 40);

    private static JFrame frame;
    private static GraphPanel graph;
    private static JLabel stepLabel;
    private static JLabel count1Label;
    private static JLabel count2Label;
    
    private World world;
    private int step;
    private Class class1;
    private Class class2;
    
    /**
     * Constructor.
     * 
     * @param width The width of the plotter window (in pixles).
     * @param height The height of the plotter window (in pixles).
     * @param startMax The initial maximum value for the y axis.
     * @param world The world object.
     * @param class1 The first class to be plotted.
     * @param width The second class to be plotted.
     */
    public Plotter(int width, int height, int startMax, World world, Class class1, Class class2)
    {
        this.world = world;
        this.class1 = class1;
        this.class2 = class2;
        if (frame == null) {
            frame = makeFrame(width, height, startMax);
        }
        else {
            graph.newRun();
        }
        step = 0;
        updateGraph();
        setImage(new GreenfootImage(1,1));
    }
    
    /**
     * Update the plotter graph.
     */
    public void act() 
    {
        step++;
        updateGraph();
    }
    
    /**
     * Update the graph component in our window with the current object
     * counts for the two monitored classes.
     * Stop the simulation if any one of them drops to zero.
     */
    private void updateGraph()
    {
        List class1Objects = world.getObjects(class1);
        List class2Objects = world.getObjects(class2);
        graph.update(step, class1Objects.size(), class2Objects.size());
        if (class1Objects.size()==0 || class2Objects.size()==0) {
            Greenfoot.stop();
        }
    }
    
    /**
     * Prepare the frame for the graph display.
     */
    private JFrame makeFrame(int width, int height, int startMax)
    {
        JFrame frame = new JFrame("Greenfoot actor graph");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        Container contentPane = frame.getContentPane();

        graph = new GraphPanel(width, height, startMax);
        contentPane.add(graph, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
            bottom.add(new JLabel(" Step:"));
            stepLabel = new JLabel("");
            bottom.add(stepLabel);
            bottom.add(new JLabel("  " + class1.getName() + ":"));
            count1Label = new JLabel("");
            bottom.add(count1Label);
            bottom.add(new JLabel("  " + class2.getName() + ":"));
            count2Label = new JLabel("");
            bottom.add(count2Label);
        contentPane.add(bottom, BorderLayout.SOUTH);
        
        frame.pack();
        frame.setVisible(true);
        
        return frame;
    }
    
    // ============================================================================
    /**
     * Nested class: a component to display the graph.
     */
    class GraphPanel extends JComponent
    {
        private static final double SCALE_FACTOR = 0.8;
        
        // An internal image buffer that is used for painting. For
        // actual display, this image buffer is then copied to screen.
        private BufferedImage graphImage;
        private int lastVal1, lastVal2;
        private int yMax;
        
        /**
         * Create a new, empty GraphPanel.
         */
        public GraphPanel(int width, int height, int startMax)
        {
            graphImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            clearImage();
            lastVal1 = height;
            lastVal2 = height;
            yMax = startMax;
        }

        /**
         * Indicate a new simulation run on this panel.
         */
        public void newRun()
        {
            int height = graphImage.getHeight();
            int width = graphImage.getWidth();
            
            Graphics g = graphImage.getGraphics();
            g.copyArea(4, 0, width-4, height, -4, 0);            
            g.setColor(Color.BLACK);
            g.drawLine(width-4, 0, width-4, height);
            g.drawLine(width-2, 0, width-2, height);
            lastVal1 = height;
            lastVal2 = height;
            repaint();
        }
        
        /**
         * Dispay a new point of data.
         */
        public void update(int step, int count1, int count2)
        {
            Graphics g = graphImage.getGraphics();

            int height = graphImage.getHeight();
            int width = graphImage.getWidth();
            
            g.copyArea(1, 0, width - 1, height, -1, 0);
            
            int y = height - ((height * count1) / yMax) - 1;
            if (y<0) {
                scaleDown();
                y = height - ((height * count1) / yMax) - 1;
            }
            g.setColor(LIGHT_GRAY);
            g.drawLine(width-2, y, width-2, height);
            g.setColor(Color.RED);
            g.drawLine(width-3, lastVal1, width-2, y);
            lastVal1 = y;
            
            y = height - ((height * count2) / yMax) - 1;
            if (y<0) {
                scaleDown();
                y = height - ((height * count1) / yMax) - 1;
            }
            g.setColor(LIGHT_GRAY);
            g.drawLine(width-2, y, width-2, height);
            g.setColor(Color.BLACK);
            g.drawLine(width-3, lastVal2, width-2, y);
            lastVal2 = y;
            
            repaint();
            
            stepLabel.setText("" + step);
            count1Label.setText("" + count1);
            count2Label.setText("" + count2);
        }
        
        /**
         * Scale the current graph down vertically to make more room at the top.
         */
        public void scaleDown()
        {
            Graphics g = graphImage.getGraphics();
            int height = graphImage.getHeight();
            int width = graphImage.getWidth();

            BufferedImage tmpImage = new BufferedImage(width, (int)(height*SCALE_FACTOR), BufferedImage.TYPE_INT_RGB);
            Graphics2D gtmp = (Graphics2D) tmpImage.getGraphics();
            
            gtmp.scale(1.0, SCALE_FACTOR);
            gtmp.drawImage(graphImage, 0, 0, null);
            
            int oldTop = (int) (height * (1.0-SCALE_FACTOR));
            
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, oldTop);
            g.drawImage(tmpImage, 0, oldTop, null);
            
            yMax = (int) (yMax / SCALE_FACTOR);
            lastVal1 = oldTop + (int) (lastVal1 * SCALE_FACTOR);
            lastVal2 = oldTop + (int) (lastVal2 * SCALE_FACTOR);
            
            repaint();
        }
        
        /**
         * Clear the image on this panel.
         */
        public void clearImage()
        {
            Graphics g = graphImage.getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, graphImage.getWidth(), graphImage.getHeight());
            repaint();
        }
        
        // The following methods are redefinitions of methods
        // inherited from superclasses.
        
        /**
         * Tell the layout manager how big we would like to be.
         * (This method gets called by layout managers for placing
         * the components.)
         * 
         * @return The preferred dimension for this component.
         */
        public Dimension getPreferredSize()
        {
            return new Dimension(graphImage.getWidth(), graphImage.getHeight());
        }
        
        /**
         * This component is opaque.
         */
        public boolean isOpaque()
        {
            return true;
        }
        
        /**
         * This component needs to be redisplayed. Copy the internal image 
         * to screen. (This method gets called by the Swing screen painter 
         * every time it wants this component displayed.)
         * 
         * @param g The graphics context that can be used to draw on this component.
         */
        public void paintComponent(Graphics g)
        {
            Dimension size = getSize();

            if(graphImage != null) {
                g.drawImage(graphImage, 0, 0, null);
            }
        }
    }
}
