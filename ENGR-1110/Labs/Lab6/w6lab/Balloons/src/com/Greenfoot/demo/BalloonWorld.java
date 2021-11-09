package com.Greenfoot.demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.MotionEvent;
import android.widget.TextView;

public class BalloonWorld extends World{
	

	public BalloonWorld(Context context, int width2, int height2) {
		super(context, width2, height2);
		// TODO Auto-generated constructor stub
		setBackground(R.drawable.bricks2);
		width = width2;
		height = height2;
		addObject(new Balloon(R.drawable.balloon1),200,height2);
	}
	@Override
	public boolean onTouchEvent(MotionEvent e)
	{
		if(running)
			for(int i=0;i<people.size();i++)
			{
				if(people.get(i).x>e.getX()-100 &&people.get(i).x<e.getX()&&people.get(i).y>e.getY()-100&&people.get(i).y<e.getY()+0){
					score += 20;
					people.remove(i);
				}
			}
		else
			reset();
		return false;
	}
	
	@Override
	public void act()
	{
		if(Math.random()*30<1)
			addObject(new Balloon(R.drawable.balloon1),(int)(Math.random()*getWidth()),getHeight());
		
	}
    public void addObject(Balloon balloon, int x,int y)
    {
    	balloon.x = x;
    	balloon.y = y;
    	balloon.shade = Color.BLUE;
    	balloon.world = this;
    	people.add(balloon);
    }
	public class Actor {
		int x = 0;
		int y = 0;
		int rotation = 0;
		int shade;
		World world;
		int id;
		int imageScaleX;
		int imageScaleY;
		boolean up = false;
		MotionEvent dude;
		boolean remove =false;
		public void setRotation(int rotation2)
		{
			rotation = rotation2;
		}
		public int getRotation()
		{
			return rotation;
		}
		public void setImage(int id2, int scaleX,int scaleY)
		{
			id = id2;
			imageScaleY = scaleY;
			imageScaleX = scaleX;
		}
		public void act()
		{}
		public void setLocation(int x2,int y2)
		{
			x = x2;
			y = y2;
		}
		public void move(int move)
		{
			x += move*Math.sin(Math.toRadians(rotation));
			y += move*Math.cos(Math.toRadians(rotation));
		}
		public int getX()
		{return x;}
		public int getY()
		{return y;}
	}
	public class Balloon extends Actor {

    	public Balloon(int id3) {
    		// TODO Auto-generated constructor stub
    		setImage(id3,120,120);
    	}

    	@Override
    	public void act()
    	{
    		setLocation(getX(),getY()-5);
    		if(getY()<0)
    			running = false;
    	}
    	
    }

}
