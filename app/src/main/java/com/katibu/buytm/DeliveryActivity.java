package com.katibu.buytm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class DeliveryActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView deliveryRecyclerview;
    private Button changeOrAddNewAddress;
    public static final int SELECT_ADDRESS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Delivery");


        deliveryRecyclerview = findViewById(R.id.delivery_recyclerview);
        changeOrAddNewAddress = findViewById(R.id.change_address_btn);



        LinearLayoutManager layoutManager =  new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deliveryRecyclerview.setLayoutManager(layoutManager);

        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0, R.drawable.image2,"iPhone 5 Black",2,"NGN32000","NGN100000",1,0,0));
        cartItemModelList.add(new CartItemModel(0, R.drawable.image3,"iPhone 5 Black",2,"NGN32000","NGN100000",1,0,0));
        cartItemModelList.add(new CartItemModel(0, R.drawable.image4,"iPhone 5 Black",2,"NGN32000","NGN100000",1,0,0));
        cartItemModelList.add(new CartItemModel(1,"Price (3 items)","NGN 5000","Free","NGN 2000","5999"));

        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
        deliveryRecyclerview.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        changeOrAddNewAddress.setVisibility(View.VISIBLE);
        changeOrAddNewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myAddressIntent = new Intent(DeliveryActivity.this,MyAddressesActivity.class);
                myAddressIntent.putExtra("MODE", SELECT_ADDRESS);
                startActivity(myAddressIntent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
