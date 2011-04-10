/**
* Created by: Muhammad Amiral
* Feb 23, 2011
*/

package com.amiral.tangerangmaps.db;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper{

	private static String DB_PATH="";
	private static String DB_NAME = "tangerangmapsdb.sqlite";
	private static final int DB_VERSION = 1;
	private SQLiteDatabase myDataBase;
	private final Context ctx;
	private static final String TAG = "SQLITE";
	private static DBHelper mDBConnection;
	
	public DBHelper(Context context) {
		super(context, DB_NAME,null, DB_VERSION);
		this.ctx = context;
		DB_PATH = "/data/data/"
			+ context.getApplicationContext().getPackageName()
			+ "/databases/";
		// TODO Auto-generated constructor stub
	}
	
	public synchronized DBHelper getDBAdapterInstance(Context context){
		if (mDBConnection == null){
			mDBConnection = new DBHelper(context);
		}
		return mDBConnection;
	}
	
	/**
	 * Creates a empty database on the system and rewrites it with your own
	 * database.
	 * */
	public void createDataBase() throws IOException {

		boolean dbExist = checkDataBase();
		SQLiteDatabase db_Read = null;

		if (dbExist) {
			// do nothing - database already exist
		} else {
			Log.v(TAG, "DB is not exist. Creating one...");
			// By calling this method and empty database will be created into
			// the default system path
			// of your application so we are gonna be able to overwrite that
			// database with our database.
			db_Read = this.getReadableDatabase();
			db_Read.close();

			try {
				Log.v(TAG, "Copying database");
				copyDataBase();
			} catch (IOException e) {
				throw new Error("Error copying database");
			}
		}

	}
	
	/**
	 * Check if the database already exist to avoid re-copying the file each
	 * time you open the application.
	 * 
	 * @return true if it exists, false if it doesn't
	 */
	private boolean checkDataBase() {

		SQLiteDatabase checkDB = null;

		try {
			String myPath = DB_PATH + DB_NAME;
			Log.v(TAG, "Check DB on " + myPath);
			checkDB = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READONLY);

		} catch (SQLiteException e) {

			// database does't exist yet.
		}

		if (checkDB != null) {

			checkDB.close();
		}

		return checkDB != null ? true : false;
	}

	/**
	 * Copies your database from your local assets-folder to the just created
	 * empty database in the system folder, from where it can be accessed and
	 * handled. This is done by transfering bytestream.
	 * */
	private void copyDataBase() throws IOException {

		// Open your local db as the input stream
		InputStream myInput = ctx.getAssets().open(DB_NAME);

		// Open the empty db as the output stream
		OutputStream myOutput = new FileOutputStream(DB_PATH + DB_NAME);

		// transfer bytes from the inputfile to the outputfile
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}

		// Close the streams
		myOutput.flush();
		myOutput.close();
		myInput.close();

	}

	public void openDataBase() throws SQLException {
		// Open the database
		String myPath = DB_PATH + DB_NAME;
		Log.v(TAG, "Opening DB on " + myPath);

		myDataBase = SQLiteDatabase.openDatabase(myPath, null,
				SQLiteDatabase.OPEN_READWRITE);

	}

	@Override
	public synchronized void close() {
		Log.v(TAG, "Closing DB");

		if (myDataBase != null)
			myDataBase.close();

		super.close();

	}
	
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	// Add your public helper methods to access and get content from the
	// database.
	// You could return cursors by doing "return myDataBase.query(....)" so it'd
	// be easy
	// to you to create adapters for your views.

	// ----------------------- CRUD Functions ------------------------------


	/**
	 * This function used to select the records from DB.
	 * 
	 * @param tableName
	 * @param tableColumns
	 * @param whereClase
	 * @param whereArgs
	 * @param groupBy
	 * @param having
	 * @param orderBy
	 * @return A Cursor object, which is positioned before the first entry.
	 */
	public Cursor selectRecordsFromDB(String tableName, 
			String[] tableColumns, String whereClase,
			String whereArgs[], String groupBy,
			String having, String orderBy){
		return myDataBase.query(tableName, tableColumns, 
				whereClase, whereArgs, groupBy, having, orderBy);
	}
	
	/**
	 * This function used to update the Record in DB.
	 * 
	 * @param tableName
	 * @param initialValues
	 * @param whereClause
	 * @param whereArgs
	 * @return 0 in case of failure otherwise return no of row(s) are updated
	 */
	
	public int updateRecordsInDB(String tableName, ContentValues initalValues,
			String whereClause, String whereArgs[]){
		return myDataBase.update(tableName, initalValues, whereClause, whereArgs);
	}
	
}
