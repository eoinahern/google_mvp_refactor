package com.example.android.architecture.blueprints.todoapp.taskdetail;

import com.example.android.architecture.blueprints.todoapp.BaseView;

/**
 * Created by eoin_a on 16/10/2017.
 */

public interface TaskDetailView extends BaseView {

	void setLoadingIndicator(boolean active);

	void showMissingTask();

	void hideTitle();

	void showTitle(String title);

	void hideDescription();

	void showDescription(String description);

	void showCompletionStatus(boolean complete);

	void showEditTask(String taskId);

	void showTaskDeleted();

	void showTaskMarkedComplete();

	void showTaskMarkedActive();

	boolean isActive();


}
