package com.example.pcbill.oparealestate.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.pcbill.oparealestate.Controler.SearchControler;
import com.example.pcbill.oparealestate.R;

public class  ListView extends AppCompatActivity {
    private TextView ListViewTextView;
    private Button ListViewBackButton;
    private int i=2;
    public static android.widget.ListView ListViewListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        MakeItPretty();
        initializer();
        SearchControler searchControler= new SearchControler();
        /**Creation of an array list type String that contains the result from the select
         * get the result from searchControler.getSelecedData() which allsow is an array list
         * from the object searchControler**/

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,searchControler.getSelecedData());
        System.out.println("array addapter: "+ arrayAdapter);
        System.out.println("out: ");
        for(int i=0; i < arrayAdapter.getCount() ;i++)
        {
            System.out.println("for: ");
            System.out.println("array addapter: "+ arrayAdapter.getItem(i));
        }
        ListViewListView.setAdapter(arrayAdapter);//just displays the array list created above in a listView
        /**Buck button function**/
        ListViewBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Search.class);
                startActivityForResult(intent,0);
                arrayAdapter.clear();
                finish();
            }
        });
    }
    /**This function connects the Xml file with thw java*/
    private void initializer()
    {
        ListViewTextView=(TextView)findViewById(R.id.ListViewTextView);
        ListViewBackButton=(Button)findViewById(R.id.ListViewBackButton);
        ListViewListView=(android.widget.ListView)findViewById(R.id.listViewListView);
    }
    /**its self explanatory :) **/
    private void MakeItPretty()
    {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.opa));
    }




}
