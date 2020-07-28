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
public class MyRewardsFragment extends Fragment {



    public MyRewardsFragment() {
        // Required empty public constructor
    }

    private RecyclerView rewardRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_rewards, container, false);

        rewardRecyclerView = view.findViewById(R.id.my_rewards_recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rewardRecyclerView.setLayoutManager(layoutManager);

        List<RewardModel> rewardModelList = new ArrayList<>();
        rewardModelList.add(new RewardModel("Cashback", "till 2nd June, 2016","Get 20% OFF on any products above 5000 and below 20000 and stand a chance to win free trip to India"));
        rewardModelList.add(new RewardModel("Discount", "till 2nd June, 2016","Get 20% OFF on any products above 5000 and below 20000 and stand a chance to win free trip to India"));
        rewardModelList.add(new RewardModel("Buy 1 Get 1", "till 2nd June, 2016","Get 20% OFF on any products above 5000 and below 20000 and stand a chance to win free trip to India"));
        rewardModelList.add(new RewardModel("Cashback", "till 2nd June, 2016","Get 20% OFF on any products above 5000 and below 20000 and stand a chance to win free trip to India"));
        rewardModelList.add(new RewardModel("Discount", "till 2nd June, 2016","Get 20% OFF on any products above 5000 and below 20000 and stand a chance to win free trip to India"));
        rewardModelList.add(new RewardModel("Black Friday", "till 2nd June, 2016","Get 20% OFF on any products above 5000 and below 20000 and stand a chance to win free trip to India"));
        rewardModelList.add(new RewardModel("Cashback", "till 2nd June, 2016","Get 20% OFF on any products above 5000 and below 20000 and stand a chance to win free trip to India"));
        rewardModelList.add(new RewardModel("Cashback", "till 2nd June, 2016","Get 20% OFF on any products above 5000 and below 20000 and stand a chance to win free trip to India"));

        MyRewardAdapter myRewardAdapter = new MyRewardAdapter(rewardModelList);
        rewardRecyclerView.setAdapter(myRewardAdapter);
        myRewardAdapter.notifyDataSetChanged();

        return view;
    }

}
