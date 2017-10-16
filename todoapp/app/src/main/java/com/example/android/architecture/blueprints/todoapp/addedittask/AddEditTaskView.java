package com.example.android.architecture.blueprints.todoapp.addedittask;

import com.example.android.architecture.blueprints.todoapp.BaseView;

public interface AddEditTaskView extends BaseView {

	void showEmptyTaskError();

	void showTasksList();

	void setTitle(String title);

	void setDescription(String description);
}
