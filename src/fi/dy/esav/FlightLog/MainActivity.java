package fi.dy.esav.FlightLog;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.button_create).setOnClickListener(buttonCreateListener);
        findViewById(R.id.button_list).setOnClickListener(buttonListListener);
        findViewById(R.id.button_models).setOnClickListener(buttonManageListener);
    }
    
    OnClickListener buttonCreateListener = new OnClickListener() {
		
		public void onClick(View v) {
			startActivity(new Intent(getApplicationContext(), CreateLogActivity.class));
		}
	};
	
    OnClickListener buttonListListener = new OnClickListener() {
		
		public void onClick(View v) {
			startActivity(new Intent(getApplicationContext(), ListLogsActivity.class));
		}
	};
	
    OnClickListener buttonManageListener = new OnClickListener() {
		
		public void onClick(View v) {
			startActivity(new Intent(getApplicationContext(), ModelManagerActivity.class));
		}
	};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
