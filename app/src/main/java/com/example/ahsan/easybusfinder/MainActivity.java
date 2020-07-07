package com.example.ahsan.easybusfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<BusData> lstBusData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstBusData =new ArrayList<>();
        lstBusData.add(new BusData("Current Location","Category book","Description book",R.drawable.ic_place));
        lstBusData.add(new BusData("01 No bus","Category book","Description book",R.drawable.bus3));
        lstBusData.add(new BusData("02 No bus","Category book","Description book",R.drawable.bus3));
        lstBusData.add(new BusData("03 No bus","Category book","Description book",R.drawable.bus3));
        lstBusData.add(new BusData("04 No bus","Category book","Description book",R.drawable.bus3));
        lstBusData.add(new BusData("05 No bus","Category book","Description book",R.drawable.bus3));
        lstBusData.add(new BusData("06 No bus","Category book","Description book",R.drawable.bus3));
        lstBusData.add(new BusData("07 No bus","Category book","Description book",R.drawable.bus3));
        lstBusData.add(new BusData("08 No bus","Category book","Description book",R.drawable.bus3));
        lstBusData.add(new BusData("09 No bus","Category book","Description book",R.drawable.bus3));
        lstBusData.add(new BusData("10 No bus","Category book","Description book",R.drawable.bus3));
        lstBusData.add(new BusData("11 No bus","Category book","Description book",R.drawable.bus3));
        lstBusData.add(new BusData("12 No bus","Category book","Description book",R.drawable.bus3));

        RecyclerView  myrv=findViewById(R.id.recycler_view_id);
        RecyclerViewAdapter mAdapter=new RecyclerViewAdapter(this, lstBusData);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(mAdapter);

    }
}
