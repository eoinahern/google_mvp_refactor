package com.example.eoin_a.testitemdecortation;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {


	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return null;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {

	}

	@Override
	public int getItemCount() {
		return 0;
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		public ViewHolder(View itemView) {
			super(itemView);
		}
	}
}
