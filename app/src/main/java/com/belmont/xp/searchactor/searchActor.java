package com.belmont.xp.searchactor;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class searchActor extends Activity {
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, list);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.list_item);
        textView.setAdapter(adapter);
    }

    public static final ArrayList<String> list = new ArrayList<String>() {{
        add("A");
        add("B");
        add("C");
        add("D");
        add("E");
    }};
}