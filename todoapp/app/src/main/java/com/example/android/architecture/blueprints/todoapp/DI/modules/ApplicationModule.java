package com.example.android.architecture.blueprints.todoapp.DI.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Singleton
@Module
public class ApplicationModule {

	private Application application;

	public ApplicationModule(Application application) {
		this.application = application;
	}

	@Provides
	public Context cont() {
		return application;
	}


}
