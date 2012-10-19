/**
 * 
 */
package fi.dy.esav.FlightLog;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Oppilas
 *
 */
public class DBHelper extends SQLiteOpenHelper {
	
	 final static String DB_NAME = "FlightLogDB";
	 final static int DB_VERSION = 1;
	 
	 Context context;
	
	public DBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		this.context = context;
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE models (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
				"name TEXT NOT NULL);");
		db.execSQL("CREATE TABLE flights (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
				"time INTEGER NOT NULL," +
				"model INTEGER NOT NULL," +
				"FOREIGN KEY (model) REFERENCES models(_id));");
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
