package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.btnC);

        
        btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				  Toast tst = Toast.makeText(MainActivity.this, "111111111", Toast.LENGTH_SHORT);
		          tst.show();
		     	
			}
		});
		
    }

    public void clickHandler(View v){
    	switch (v.getId()) {
    	case R.id.btnD:
    		Toast.makeText(this, "Button D clicked!", Toast.LENGTH_SHORT).show();
    		break;
    	case R.id.btnE:
    		Toast.makeText(this, "Button E clicked!", Toast.LENGTH_SHORT).show();
    		break;
    	default:
    		Toast.makeText(this, "Unknown Button clicked!", Toast.LENGTH_SHORT).show();
    	}

    

    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
