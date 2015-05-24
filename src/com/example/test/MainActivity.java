package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private global_data gd;
    private TextView textview_si;
    private TextView textview_fi;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        global_data gd = new global_data();
        this.gd = gd;
        
        gd.update();
        System.out.println("random num:");
        System.out.println(gd.string_index);
        System.out.println(gd.fret_index);
        this.textview_si = (TextView)findViewById(R.id.textview_string_index);       
        this.textview_fi = (TextView)findViewById(R.id.textview_freq_index);
        this.textview_si.setText(gd.string_name[gd.string_index]);
  
        this.textview_fi.setText(Integer.toString(gd.fret_index));      
            
        
/*      Button btn = (Button)findViewById(R.id.btnC);  
        btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				  Toast tst = Toast.makeText(MainActivity.this, "111111111", Toast.LENGTH_SHORT);
		          tst.show();
		     	
			}
		});
*/		
		
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
    	} else {
    		textview_ret.setText("´íÎó");
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
