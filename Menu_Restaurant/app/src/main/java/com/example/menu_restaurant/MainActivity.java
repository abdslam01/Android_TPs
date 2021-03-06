package com.example.menu_restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Grab All TextViews, And Assign A ClickListener To Eachone Of Them
        try{
            for(int i=1; ; i++){ // grab till you get an exception then exit
                int id = getResources().getIdentifier("textView"+i, "id", getPackageName());
                TextView iv = (TextView) findViewById(id);
                iv.setOnClickListener(this);
            }
        }catch(Exception e){}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.quit:
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), SecondActivity.class);
        intent.putExtra("products_to_show", ((TextView) v).getText().toString());
        startActivity(intent);
    }
}