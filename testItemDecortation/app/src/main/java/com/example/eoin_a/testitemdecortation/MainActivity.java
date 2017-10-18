package com.example.eoin_a.testitemdecortation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

	private RecyclerView recyclerview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		recyclerview = (RecyclerView) findViewById(R.id.recycler);
		setupRecycler();
	}

	private void setupRecycler() {

	}

}
