package com.example.anik.lovecalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anik.mylibrary.Love;

import static com.example.anik.mylibrary.Love.*;


public class MainActivity extends ActionBarActivity {
    EditText vEdtUserOne;
    EditText vEdtUserTwo;
    Button vBtnLove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vEdtUserOne = (EditText) findViewById(R.id.viewEditUserOne);
        vEdtUserTwo = (EditText) findViewById(R.id.viewEditUserTwo);
        vBtnLove = (Button) findViewById(R.id.viewBtnCalculateLove);
        vEdtUserOne.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {}

            @Override
            public void afterTextChanged(Editable editable) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if(charSequence.toString().trim().length() == 0){
                    vBtnLove.setEnabled(false);
                    return ;
                }
                vBtnLove.setEnabled(true);
            }
        });

        vBtnLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "";
                int duration = Toast.LENGTH_SHORT;
                String userOne = vEdtUserOne.getText().toString(),
                    userTwo = vEdtUserTwo.getText().toString();
                if(userOne.trim().length() == 0 || userTwo.trim().length() == 0){
                    message = "Forever alone suits you. ^_^";
                } else{
                    message = Love.calculate(userOne, userTwo);
                }
                Toast toast = Toast.makeText(getApplicationContext(), message, duration);
                toast.show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
