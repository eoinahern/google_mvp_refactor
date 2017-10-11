package com.example.android.architecture.blueprints.todoapp.DI.modules;

import com.example.android.architecture.blueprints.todoapp.BaseActivity;
import com.example.android.architecture.blueprints.todoapp.DI.annotation.scope.PerScreen;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class BaseActivityModule<T extends BaseActivity> {

	private final T activity;

	public BaseActivityModule(T activity) {
		this.activity = activity;
	}

	@Provides
	@PerScreen
	public T activity() {
		return activity;
	}
}
