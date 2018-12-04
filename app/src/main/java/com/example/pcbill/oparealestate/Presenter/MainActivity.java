package com.example.pcbill.oparealestate.Presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pcbill.oparealestate.DBmodel.DBHelper;
import com.example.pcbill.oparealestate.R;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button Search;
    Button Sale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeVariables();
        //Log.d("bill","ok");
        try {
            Toast toast =Toast.makeText(getApplicationContext(), "created1",Toast.LENGTH_LONG);
            toast.show();

        } catch (Exception e) {
            Toast toast =Toast.makeText(getApplicationContext(), (CharSequence) e,Toast.LENGTH_LONG);
            toast.show();
        }

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Search.class);
                startActivityForResult(myIntent,0);
            }
        });
        Sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(),Sale.class);
                startActivityForResult(myIntent,0);
            }
        });

    }
    private void initializeVariables()
    {
        textView=(TextView) findViewById(R.id.MainTextView);
        Search=(Button)findViewById(R.id.Searchbutton);
        Sale=(Button)findViewById(R.id.Salebutton);
    }
}
