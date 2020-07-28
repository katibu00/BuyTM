package com.katibu.buytm;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.Viewholder> {

    private List<WishlistModel> wishlistModelList;
    private Boolean wishlist;

    public WishlistAdapter(List<WishlistModel> wishlistModelList, Boolean wishlist) {
        this.wishlistModelList = wishlistModelList;
        this.wishlist = wishlist;
    }

    @NonNull
    @Override
    public WishlistAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wishlist_item_layout, viewGroup, false);
        return new Viewholder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull WishlistAdapter.Viewholder viewHolder, int position) {

        int resource = wishlistModelList.get(position).getProductImage();
        String title = wishlistModelList.get(position).getProductTitle();
        int freecoupons = wishlistModelList.get(position).getFreeCoupons();
        String rating = wishlistModelList.get(position).getRating();
        int totalRatings = wishlistModelList.get(position).getTotalRating();
        String productPrice = wishlistModelList.get(position).getProductPrice();
        String cuttedPrice = wishlistModelList.get(position).getCuttedPrice();
        String paymentMethod = wishlistModelList.get(position).getPaymentMethod();

        viewHolder.setData(resource, title, freecoupons, rating, totalRatings, productPrice, cuttedPrice, paymentMethod);
    }

    @Override
    public int getItemCount() {
        return wishlistModelList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productTitle;
        private TextView freeCoupons;
        private ImageView couponIcon;
        private TextView rating;
        private TextView totalRating;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView paymentMethod;
        private ImageView deleteBtn;


        public Viewholder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.product_image);
            productTitle = itemView.findViewById(R.id.product_title);
            freeCoupons = itemView.findViewById(R.id.tv_free_coupon);
            couponIcon = itemView.findViewById(R.id.coupon_icon);
            rating = itemView.findViewById(R.id.tv_product_rating_miniview);
            totalRating = itemView.findViewById(R.id.total_rating);
            productPrice = itemView.findViewById(R.id.product_price);
            cuttedPrice = itemView.findViewById(R.id.cutted_price);
            paymentMethod = itemView.findViewById(R.id.payment_method);
            deleteBtn = itemView.findViewById(R.id.delete_btn);
        }


        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        private void setData(int resource, String title, int freeCouponNo, String averageRate, int totalRatingsNo, String price, String cuttedPriceValue, String payMethod) {

            productImage.setImageResource(resource);
            productTitle.setText(title);
            if (freeCouponNo != 0) {
                couponIcon.setVisibility(View.VISIBLE);
                if (freeCouponNo == 1) {
                    freeCoupons.setText("free " + freeCouponNo + " coupon");

                } else {
                    freeCoupons.setText("free " + freeCouponNo + " coupons");

                }
            } else {
                couponIcon.setVisibility(View.INVISIBLE);
                freeCoupons.setVisibility(View.INVISIBLE);
            }
            rating.setText(averageRate);
//            totalRating.setText(totalRatingsNo + "(ratings)");
            productPrice.setText(price);
            cuttedPrice.setText(cuttedPriceValue);
            paymentMethod.setText(payMethod);

            if (wishlist){
                deleteBtn.setVisibility(View.VISIBLE);
            }else{
                deleteBtn.setVisibility(View.INVISIBLE);
            }
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "delete", Toast.LENGTH_SHORT).show();
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDetailsIntent = new Intent(itemView.getContext(),ProductDetailsActivity.class);
                    itemView.getContext().startActivity(productDetailsIntent);
                }
            });
        }

    }
}
