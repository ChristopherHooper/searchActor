package com.belmont.xp.searchactor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Christopher on 4/1/15.
 */
public class DBAdapter extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "movies";

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    public void onUpgrade(SQLiteDatabase db, int two, int three) {

    }


    /*
        private final Connection connection = DriverManager.getConnection("jdbc:mysql://172.16.64.249:3306/", "garlandpreader", "csc4610mysql");
        private final Statement statement   = connection.createStatement();

        private ResultSet searchPartialActors(String PartialActor){
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            ResultSet result = statement.executeQuery("SELECT * FROM name where name like %" +  PartialActor +"%");
            return result;
        }

        private ArrayList<String> printResultSet(ResultSet results){
            ArrayList<String> mylist = new ArrayList<String>();
            int i = 0;
            while (results.next()) {
                String mExample = results.getRow(i);
                i++;
                mylist.add(mExample); //this adds an element to the list.
            }
            return mylist;
        }

        private ResultSet searchMoviesOfActors(String Actor){
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            ResultSet result = statement.executeQuery("select distrinct title.title from cast.info inner join title on cast_info.movie_id=title.id inner join name on cast_info.person.id=name.id where title.kind_id=1 and cast_info.role=1 and name.name like "+  Actor);
            return result;
        }
    */
    public static ArrayList<String> PrettyPrintActors(String PartialActor) {
        return searchActor.list;
        //return printResultSet(searchPartialActors(PartialActor));
    }

    public static ArrayList<String> PrettyPrintActorMovies(String Actor) {
        return searchActor.list;
        //return printResultSet(searchMoviesOfActors(Actor));
    }
}
