package fi.dy.esav.FlightLog;

import java.util.ArrayList;
import java.util.HashMap;

import android.R.layout;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

public class ModelManagerActivity extends Activity {

	DBHelper db;
	
	ListView list;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_manager);
        
        db = new DBHelper(this);
        
        list = (ListView) findViewById(R.id.list);
        
        ArrayList<String> choices = new ArrayList<String>();
        ArrayList<HashMap<String, String>> models = db.getModels();
        
        choices.add("Add a new model");
        
        for(HashMap<String,String> map : models) {
        	choices.add(map.get("name"));
        }
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,layout.simple_list_item_1, choices);
        list.getCount();
        list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_model_manager, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public void onDestroy() {
    	super.onDestroy();
    	db.close();
    }

}
