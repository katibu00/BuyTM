package com.katibu.buytm;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ProductDetailsAdapter extends FragmentPagerAdapter {

    private int totalTabs;

    public ProductDetailsAdapter(FragmentManager fm, int totalTabs) {
        super(fm);
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int i) {
       switch (i){
           case 0:
                ProductDescriptionFragment productDescriptionFragment = new ProductDescriptionFragment();
                return productDescriptionFragment;
           case 1:
                ProductSpecificationsFragment productSpecificationsFragment = new ProductSpecificationsFragment();
                return productSpecificationsFragment;
           case 2:
               ProductDescriptionFragment productDescriptionFragment2 = new ProductDescriptionFragment();
               return productDescriptionFragment2;
           default:
               return null;
       }

    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
