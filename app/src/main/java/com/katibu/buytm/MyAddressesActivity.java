package com.katibu.buytm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import static com.katibu.buytm.DeliveryActivity.SELECT_ADDRESS;

public class MyAddressesActivity extends AppCompatActivity {

    private RecyclerView myAddressesrecyclerView;
    private Button deliverHereBtn;
    private static AddressesAdapter addressesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_addresses);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("My Addresses");

        myAddressesrecyclerView = findViewById(R.id.addresses_recyclerview);
        deliverHereBtn = findViewById(R.id.deliver_here_btn);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myAddressesrecyclerView.setLayoutManager(layoutManager);


        List<AddressesModel>addressesModelList = new ArrayList<>();
        addressesModelList.add(new AddressesModel("Umar Katibu","Tamsuguri Street Misau", "5050", true));
        addressesModelList.add(new AddressesModel("Ishaq Katibu","Tamsuguri Street Misau", "5050", false));
        addressesModelList.add(new AddressesModel("Sagir Haruna ","Tamsuguri Street Misau", "5050", true));
        addressesModelList.add(new AddressesModel("Sagir Haruna ","Tamsuguri Street Misau", "5050", false));
        addressesModelList.add(new AddressesModel("Sagir Haruna ","Tamsuguri Street Misau", "5050", false));
        addressesModelList.add(new AddressesModel("Sagir Haruna ","Tamsuguri Street Misau", "5050", false));


        int mode = getIntent().getIntExtra("MODE",-1);
        if (mode == SELECT_ADDRESS){
            deliverHereBtn.setVisibility(View.VISIBLE);
        }else{
            deliverHereBtn.setVisibility(View.GONE);
        }

        addressesAdapter = new AddressesAdapter(addressesModelList, mode);
        myAddressesrecyclerView.setAdapter(addressesAdapter);
        ((SimpleItemAnimator)myAddressesrecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        addressesAdapter.notifyDataSetChanged();

    }

    public static void refreshItem(int deselect, int select){
        addressesAdapter.notifyItemChanged(deselect);
        addressesAdapter.notifyItemChanged(select);
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
