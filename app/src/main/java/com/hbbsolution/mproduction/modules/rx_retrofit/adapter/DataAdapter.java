package com.hbbsolution.mproduction.modules.rx_retrofit.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hbbsolution.mproduction.R;
import com.hbbsolution.mproduction.data.models.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by buivu on 15/11/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<Product> mProducts;
    private Activity mActivity;

    public DataAdapter(List<Product> mProducts, Activity mActivity) {
        this.mProducts = mProducts;
        this.mActivity = mActivity;
    }

    public DataAdapter(ArrayList<Product> products) {
        mProducts = products;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mTvName.setText(mProducts.get(position).getTitle());
        holder.mTvVersion.setText(mProducts.get(position).getDescription());
        holder.mTvApi.setText(mProducts.get(position).getPricePerItem() + "");
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvName, mTvVersion, mTvApi;

        public ViewHolder(View view) {
            super(view);

            mTvName = (TextView) view.findViewById(R.id.tv_name);
            mTvVersion = (TextView) view.findViewById(R.id.tv_version);
            mTvApi = (TextView) view.findViewById(R.id.tv_api_level);
        }
    }
}