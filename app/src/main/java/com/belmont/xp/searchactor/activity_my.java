package com.belmont.xp.searchactor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class activity_my extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";
    // List of all contacts
    private ArrayList<String> searchNames = new ArrayList<String>();
    // Filtered list of contacts after user begins typing in search field
    private ArrayList<String> partialNames = new ArrayList<String>();

    // List of names matching criteria are listed here
    private AutoCompleteTextView myList;

    // Field where user enters his search criteria
    private EditText nameCapture;

    // Adapter for myList
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_my);
        // Set list adapter
        myList = (AutoCompleteTextView) findViewById(R.id.autocomplete);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, partialNames);
        myList.setAdapter(adapter);

        nameCapture = (EditText) findViewById(R.id.edit_message);
        nameCapture.setText("Tom");
        AlterAdapter();

        nameCapture.addTextChangedListener(new TextWatcher() {

            // As the user types in the search field, the list is
            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                AlterAdapter();
            }

            // Not used for this program
            @Override
            public void afterTextChanged(Editable arg0) {
            }

            // Not uses for this program
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
        });
    }

    // Filters list of contacts based on user search criteria. If no information is filled in, contact list will be blank.
    private void AlterAdapter() {
        /*if (nameCapture.getText().toString().isEmpty()) {
            partialNames.clear();
            adapter.notifyDataSetChanged();
        } else {*/
            partialNames.clear();
            partialNames = searchActor.list;
            //partialNames = DBAdapter.PrettyPrintActors(nameCapture.getText().toString());
            adapter.notifyDataSetChanged();
        //}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when the user clicks the Send button
     */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
