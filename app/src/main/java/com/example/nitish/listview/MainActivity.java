package com.example.nitish.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    String people = "Abhishek \n Akhil \n Akshay \n";
    EditText input;
    MyDBHandler dbHandler;
    ListAdapter listAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.input);
        dbHandler = new MyDBHandler(this,null,null,1);
        listView = (ListView) findViewById(R.id.listView);
//        listAdapter = new CustomAdapter(this, people);
//        listView.setAdapter(listAdapter);

        printDB();
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String men = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this,men, LENGTH_SHORT).show();
                    }
                }
        );

    }

    public void add(View view){
        People people = new People(input.getText().toString());
        dbHandler.addName(people);
        printDB();
    }

    public void delete(View view){
        dbHandler.deleteName(input.getText().toString());
        printDB();
    }

    public void printDB(){
        String array = people + dbHandler.dbtoString();
        String[] dbString = array.split("\n");
        listAdapter = new CustomAdapter(this, dbString);
        listView.setAdapter(listAdapter);
        input.setText("");
    }

}
