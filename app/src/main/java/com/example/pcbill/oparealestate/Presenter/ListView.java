package com.example.pcbill.oparealestate.Presenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.pcbill.oparealestate.Controler.SearchControler;
import com.example.pcbill.oparealestate.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class  ListView extends AppCompatActivity {
    private TextView ListViewTextView;
    private Button ListViewBackButton;
    private int i=2;
    public static android.widget.ListView ListViewListView;
    private  SearchControler searchControler= new SearchControler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        MakeItPretty();
        initializer();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,searchControler.getSelecedData());
        ListViewListView.setAdapter(arrayAdapter);


        /**Buck button function**/
        ListViewBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Search.class);
                startActivityForResult(intent,0);
            }
        });
    }

    private void initializer()
    {
        ListViewTextView=(TextView)findViewById(R.id.ListViewTextView);
        ListViewBackButton=(Button)findViewById(R.id.ListViewBackButton);
        ListViewListView=(android.widget.ListView)findViewById(R.id.listViewListView);
    }

    private void MakeItPretty()
    {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.opa));
    }



}
