package com.example.android.architecture.blueprints.todoapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

	protected Toolbar toolbar;
	protected ActionBar ab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		int layout = getChildLayout();
		if (layout != 0) {
			setContentView(layout);
			ButterKnife.bind(this);
		}

		inject();
	}

	protected void setUpToolbar() {

		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		ab = getSupportActionBar();
	}

	public abstract int getChildLayout();

	public abstract void  inject();
}
