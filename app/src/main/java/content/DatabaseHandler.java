package content;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import java.util.Scanner;

public class DatabaseHandler {
    private static SQLiteDatabase db;
    private static Cursor cr;
    private static int count = 0; //primary key of database

    //Read database schema from raw resources and create the database
    public static void loadDatabase(Context context) {
        db = context.openOrCreateDatabase("database", MODE_PRIVATE, null);
        Scanner scan = new Scanner(context.getResources().openRawResource(R.raw.database));
        String query = "";
        while (scan.hasNextLine()) {
            query += scan.nextLine() + "\n";
            if (query.trim().endsWith(";")) {
                db.execSQL(query);
                query = "";
            }
        }

        count = (int) DatabaseUtils.queryNumEntries(db, "games");
    }

    //read everything there is in the database
    public static Cursor readDatabase() {
        String query1 = "SELECT * FROM games";
        cr = db.rawQuery(query1, null);
        return cr;
    }

    // add a new games's record to the database
    public static void addToDatabase(String name, String genre) {
        count++;
        String sql = "INSERT INTO games VALUES (" + count + ",'" + name + "','" + genre + "');";
        db.execSQL(sql);
    }

    // Search a games's record by name and delete it
    public static int deleteUsingName(String name) {
        String table = "games";
        String whereClause = "name=?";
        String[] whereArgs = new String[]{name};
        int deleted = db.delete(table, whereClause, whereArgs);
        return deleted;
    }

    // Search a games's record by name and updateit
    public static void updateUsingName(String oldName, String newName, String newGenre){
        String sql = "UPDATE games SET name = '"+newName+"', genre = '"+newGenre+"' WHERE name = '"+oldName+"';";
        db.execSQL(sql);
    }
}
