package com.katibu.buytm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyWishlistFragment extends Fragment {


    public MyWishlistFragment() {
        // Required empty public constructor
    }

    private RecyclerView wishlistRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_wishlist, container, false);

        wishlistRecyclerView = view.findViewById(R.id.my_wishlist_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        wishlistRecyclerView.setLayoutManager(linearLayoutManager);

        List<WishlistModel> wishlistModelList = new ArrayList<>();
        wishlistModelList.add(new WishlistModel(R.drawable.image2, "iPhone 5s 32GB",1,"5",14,"NGN 12000","NGN 150000","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.image2, "iPhone 5s 32GB",1,"5",14,"NGN 12000","NGN 150000","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.image2, "iPhone 5s 32GB",1,"5",14,"NGN 12000","NGN 150000","Cash on Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.image2, "iPhone 5s 32GB",1,"5",14,"NGN 12000","NGN 150000","Cash on Delivery"));

        WishlistAdapter wishlistAdapter = new WishlistAdapter(wishlistModelList, true);
        wishlistRecyclerView.setAdapter(wishlistAdapter);
        wishlistAdapter.notifyDataSetChanged();
        return view;
    }

}
