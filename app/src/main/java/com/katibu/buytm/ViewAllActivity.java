package com.katibu.buytm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Deals of the Day");

        recyclerView = findViewById(R.id.recyclerView);
        gridView = findViewById(R.id.grid_view);

        int layout_code = getIntent().getIntExtra("layout_code", -1);
        if (layout_code == 0) {

            recyclerView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);

            List<WishlistModel> wishlistModelList = new ArrayList<>();
            wishlistModelList.add(new WishlistModel(R.drawable.image2, "iPhone 5s 32GB", 1, "5", 14, "NGN 12000", "NGN 150000", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.image2, "iPhone 5s 32GB", 1, "5", 14, "NGN 12000", "NGN 150000", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.image2, "iPhone 5s 32GB", 1, "5", 14, "NGN 12000", "NGN 150000", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.image2, "iPhone 5s 32GB", 1, "5", 14, "NGN 12000", "NGN 150000", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.image2, "iPhone 5s 32GB", 1, "5", 14, "NGN 12000", "NGN 150000", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.image2, "iPhone 5s 32GB", 1, "5", 14, "NGN 12000", "NGN 150000", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.image2, "iPhone 5s 32GB", 1, "5", 14, "NGN 12000", "NGN 150000", "Cash on Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.image2, "iPhone 5s 32GB", 1, "5", 14, "NGN 12000", "NGN 150000", "Cash on Delivery"));

            WishlistAdapter adapter = new WishlistAdapter(wishlistModelList, false);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }else if (layout_code == 1) {


            gridView.setVisibility(View.VISIBLE);

            List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();

            GridProductLayoutAdapter gridProductLayoutAdapter = new GridProductLayoutAdapter(horizontalProductScrollModelList);
            gridView.setAdapter(gridProductLayoutAdapter);
        }
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
