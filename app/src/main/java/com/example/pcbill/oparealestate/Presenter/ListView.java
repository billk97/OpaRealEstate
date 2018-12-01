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
import com.example.pcbill.oparealestate.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class  ListView extends AppCompatActivity {
    private TextView ListViewTextView;
    private Button ListViewBackButton;
    public static android.widget.ListView ListViewListView;
    public String [] data ={
            "Οικόπεδο - Αθήνα - Σμολικα - 2 - 10443 - 18/1/97 - 6",
            "Διαμέρισμα - Πατρα - Δυραχιου - 6 - 10543 - 18/1/95 - 7"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initializer();
        ListViewBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),Search.class);
                startActivityForResult(intent,0);
            }
        });
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        ListViewListView.setAdapter(arrayAdapter);
    }

    private void initializer()
    {
        ListViewTextView=(TextView)findViewById(R.id.ListViewTextView);
        ListViewBackButton=(Button)findViewById(R.id.ListViewBackButton);
        ListViewListView=(android.widget.ListView)findViewById(R.id.listViewListView);
    }

}
