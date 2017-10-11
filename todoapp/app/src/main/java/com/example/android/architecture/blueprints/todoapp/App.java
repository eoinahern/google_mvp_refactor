package com.example.android.architecture.blueprints.todoapp;

import android.app.Application;
import android.content.Context;

import com.example.android.architecture.blueprints.todoapp.DI.components.ApplicationComponent;

public class App extends Application {

	private ApplicationComponent component;

	@Override
	public void onCreate() {
		super.onCreate();
	}

	public static App get(Context context) {
		return (App) context.getApplicationContext();
	}


	public ApplicationComponent getApplicationComponent() {


		if(component == null) {
			component =

		}

		return component;
	}

}
