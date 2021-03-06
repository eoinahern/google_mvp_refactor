package com.example.eoin_a.testitemdecortation;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MyItenDecoration extends RecyclerView.ItemDecoration {

	private Drawable dividerleft;
	private Drawable dividerright;

	public MyItenDecoration(Drawable dividerleft, Drawable dividerright, int orientation) {
		this.dividerleft = dividerleft;
		this.dividerright = dividerright;
	}

	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
		super.getItemOffsets(outRect, view, parent, state);

		if (parent.getChildAdapterPosition(view) == 0) {
			outRect.left = dividerleft.getIntrinsicWidth();
			return;
		}

		if(parent.getChildAdapterPosition(view) == parent.getAdapter().getItemCount() -1) {
			outRect.right  = dividerright.getIntrinsicWidth();
			return;
		}

		outRect.left = dividerleft.getIntrinsicWidth();
		outRect.right = dividerright.getIntrinsicWidth();
	}

}
