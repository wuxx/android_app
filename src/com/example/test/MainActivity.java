package com.example.test;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private static final int PLAYING=1;
	private static final int N_PLAYING=0;
	
    private global_data gd;
    private TextView textview_si;
    private TextView textview_fi;
    private TextView textview_timer;        
    private int counter = 20;
    private Handler my_handler;
    private int right_ret = 0;
    private int wrong_ret = 0;
    private int status = 0;
    private MenuItem item_start;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        global_data gd = new global_data();
        this.gd = gd;
        
        gd.update();

        /*
        System.out.println("random num:");
        System.out.println(gd.string_index);
        System.out.println(gd.fret_index); */
        this.textview_timer = (TextView)findViewById(R.id.textview_timer);
        
        this.textview_si = (TextView)findViewById(R.id.textview_string_index);       
        this.textview_fi = (TextView)findViewById(R.id.textview_freq_index);
        this.textview_si.setText(gd.string_name[gd.string_index]);
  
        this.textview_fi.setText(Integer.toString(gd.fret_index));      
        this.item_start = (MenuItem)findViewById(R.id.action_start);
        
        my_handler = new Handler() {  
            public void handleMessage(Message msg) {                    
				switch (msg.what) {   
                      case PLAYING:   
                           System.out.println("status playing");             
                           textview_timer.setTextSize(40);
                		   textview_timer.setText(Integer.toString(counter));
                           break;
                      case N_PLAYING:
                    	   System.out.println("status not playing");
                    	   textview_timer.setTextSize(20);
                    	   textview_timer.setText("correct: " + Integer.toString(right_ret) + " fault: " + Integer.toString(wrong_ret));
                    	   
            			   break;
                 }   
                 super.handleMessage(msg);   
            }   
       };  

    }

    public void clickHandler(View v){
        
        int tone_set = this.gd.tone_set;
        int tone_get = 0;

        TextView textview_ret = (TextView)findViewById(R.id.textview_ret);         
    	switch (v.getId()) {
    	case R.id.btnC:
    		System.out.println("button C clicked");
    		tone_get = 0;
    		break;    	
       	case R.id.btnC_s:
    		System.out.println("button C_s clicked");
    		tone_get = 1;
    		break;        		
    	case R.id.btnD:
    		System.out.println("button D clicked");
    		tone_get = 2;
    		break;
    	case R.id.btnD_s:
    		System.out.println("button D_s clicked");
    		tone_get = 3;
    		break;    		
    	case R.id.btnE:
    		System.out.println("button E clicked");
    		tone_get = 4;
    		break;
    	case R.id.btnF:
    		System.out.println("button F clicked");
    		tone_get = 5;
    		break;
    	case R.id.btnF_s:
    		System.out.println("button F_s clicked");
    		tone_get = 6;
    		break;    		
    	case R.id.btnG:
    		System.out.println("button G clicked");
    		tone_get = 7;
    		break;
    	case R.id.btnG_s:
    		System.out.println("button G_s clicked");
    		tone_get = 8;
    		break;    		
    	case R.id.btnA:
    		System.out.println("button A clicked");
    		tone_get = 9;
    		break;
    	case R.id.btnA_s:
    		System.out.println("button A_s clicked");
    		tone_get = 10;
    		break;    		
    	case R.id.btnB:
    		System.out.println("button B clicked");
    		tone_get = 11;
    		break;
    	default:
    		Toast.makeText(this, "Unknown Button clicked!", Toast.LENGTH_SHORT).show();
    	}
    	
    	System.out.println("tone_set" + tone_set);
    	System.out.println("tone_get" + tone_get);
    	if (tone_get == tone_set) {
    		textview_ret.setText("ÕýÈ·");
    		this.right_ret++;
    	} else {
    		textview_ret.setText("´íÎó");
    		this.wrong_ret++;
    		Toast.makeText(this, "string " + this.gd.string_index + " freq "  + this.gd.fret_index + " correct answer is " + this.gd.tone_name[tone_set], 
    						Toast.LENGTH_SHORT).show();
    	}
    	System.out.println("string" + this.gd.string_index);
    	System.out.println("fret" + this.gd.fret_index);
    	System.out.println(this.gd.tone_set);
    	
    	this.gd.update();
    	
    	
    	this.textview_si.setText(gd.string_name[this.gd.string_index]);    	 
        this.textview_fi.setText(Integer.toString(this.gd.fret_index));      
  
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.    	
        //getMenuInflater().inflate(R.menu.main, menu);
    	menu.add(Menu.NONE, R.id.action_start, Menu.NONE, R.string.action_start);
    	menu.add(Menu.NONE, R.id.action_settings, Menu.NONE, R.string.action_settings);
    	menu.add(Menu.NONE, R.id.action_exit, Menu.NONE, R.string.action_exit);    	    	
    	return super.onCreateOptionsMenu(menu); 
    	//return true;
    }
    
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
    	
      //super.onPrepareOptionsMenu(menu);
      System.out.println("onPrepareOptionsMenu"); 
      MenuItem item = menu.findItem(R.id.action_start);
      if (status == N_PLAYING) {    	 
    	  item.setEnabled(true);    	  
      }
      return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {    
    	switch (item.getItemId()) { 
    	case R.id.action_start:
    		Toast.makeText(this, "start slected!", Toast.LENGTH_SHORT).show();
    		item.setEnabled(false);
    		this.right_ret = 0;
    		this.wrong_ret = 0;
    		this.status = PLAYING;	/* playing */
    		
    	       
            new Timer().schedule(new TimerTask() {
        	   public void run() {
        		   System.out.println("timer task run. ");
        		   Message msg=new Message();
        		   if(counter == 0) { /* game over */
        			   System.out.println("counter == 0 ");
        			           			   
        			   counter = 20;
        			   status = msg.what = N_PLAYING;
        			   System.out.println(right_ret);
        			   System.out.println(wrong_ret);
        			   my_handler.sendMessage(msg);
        			   this.cancel();
        		   } else {	        		     
	        		   status = msg.what=PLAYING;  	        		             		   
	        		   counter--;
	        		   my_handler.sendMessage(msg);
        		   }
        		   
        	   }   
        	}, 100, 1000);    		
    		break;
    	case R.id.action_settings:
    		Toast.makeText(this, "settings slected!", Toast.LENGTH_SHORT).show();
    		break;
    	case R.id.action_exit:
    		Toast.makeText(this, "exit slected!", Toast.LENGTH_SHORT).show();
    		System.exit(0);
    		break;
    		    		    		
    	}
        return true;
    }    
}
