package com.example.android.architecture.blueprints.todoapp.DI.components;

import com.example.android.architecture.blueprints.todoapp.BaseActivity;

public interface BaseActivityComponent<T extends BaseActivity> {

	void inject(T activity);
}
