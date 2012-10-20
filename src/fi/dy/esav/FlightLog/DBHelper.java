/**
 * 
 */
package fi.dy.esav.FlightLog;

import java.util.logging.Logger;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.CancellationSignal;
import android.util.Log;

/**
 * @author Oppilas
 *
 */
public class DBHelper extends SQLiteOpenHelper {
	
	 final static String DB_NAME = "FlightLogDB";
	 final static int DB_VERSION = 1;
	 
	 Context context;
	 
	 SQLiteDatabase rw_db;
	 SQLiteDatabase ro_db;
	
	public DBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		this.context = context;
		
		rw_db = this.getWritableDatabase();
		ro_db = this.getReadableDatabase();
		
		Log.d("FL", "Initialized db");
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
	
	public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
		return ro_db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
	}
	
	public long insert(String table, String nullColumnHack, ContentValues values) {
		return rw_db.insert(table, nullColumnHack, values);
	}
	
}
