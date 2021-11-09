package com.Greenfoot.demo;

//import com.example.android.snake.R;

//import com.Greenfoot.demo.RefreshHandler;

import java.util.ArrayList;
import java.util.List;

import com.Greenfoot.demo.BalloonWorld.Balloon;

//import com.example.android.snake.R;

//import com.example.android.snake.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class World extends View {
	int score = 0;
	int mMoveDelay = 13;
	double mLastMove;
	int height;
	int width;
	int id;
	boolean running = true;
	MotionEvent dude;
	boolean up; //equivalent of mouse clicked
	List<Balloon> people = new ArrayList<Balloon>();
	Bitmap bitmap2;
	Bitmap bitmap;

	public World(Context context,int height2, int width2) {
		super(context);
		// TODO Auto-generated constructor stub
		
        
		mLastMove = System.currentTimeMillis();

	}
	public void setBackground(int newId)
	{
		id = newId;
	}
	public void reset()
	{
		people.clear();
		score = 0;
		running = true;
		invalidate();
	}
	@Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        
        Resources r2 = this.getContext().getResources();//create and draw the background
        Drawable tile2 = r2.getDrawable(id);
        bitmap2 = Bitmap.createBitmap(getWorldWidth(), getWorldHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas3 = new Canvas(bitmap2);
        tile2.setBounds(0, 0, getWorldWidth(), getWorldHeight());
        tile2.draw(canvas3);
    	
        canvas.drawBitmap(bitmap2, 0,0,paint);//create a bitmap of the balloon image
        Resources r = this.getContext().getResources();
        Drawable tile = r.getDrawable(R.drawable.balloon1);
        bitmap = Bitmap.createBitmap(78, 100, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(bitmap);
        tile.setBounds(0, 0, 78, 100);
        tile.draw(canvas2);
        
        for(int i=0;i<people.size();i++)//draw balloons
    	{
        	canvas.drawBitmap(bitmap, people.get(i).x,people.get(i).y,paint);
    	}
        
        paint.setColor(Color.BLUE);//post score
        paint.setTextSize(50);
        canvas.drawText("Score: "+score,100,100,paint);
        
        if(!running)
        	canvas.drawText("Gameover",getWorldWidth()-200,getWorldHeight(),paint);
        update();
    }
    public void update()
    {
    	long now = System.currentTimeMillis();

        if (now - mLastMove > mMoveDelay&&running) {
        	act();
        	for(int i=0;i<people.size();i++)
        	{
        		
        		people.get(i).act();
        	}
        	up = false;
            //mScore++;
            //mStatusText.setText("Score: "+mScore+"  Highscore: "+highscore);
            mLastMove = now;
            invalidate();
        }
        //mRedrawHandler.sleep(mMoveDelay);
    }
    public int getWorldWidth(){return width;}
    public int getWorldHeight(){return height;}
    public void act(){}
    
}
