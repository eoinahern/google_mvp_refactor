package com.example.android.architecture.blueprints.todoapp.tasks;

import com.example.android.architecture.blueprints.todoapp.BaseView;
import com.example.android.architecture.blueprints.todoapp.tasks.domain.model.Task;

import java.util.List;


public interface TasksView extends BaseView {

	void setLoadingIndicator(boolean active);

	void showTasks(List<Task> tasks);

	void showAddTask();

	void showTaskDetailsUi(String taskId);

	void showTaskMarkedComplete();

	void showTaskMarkedActive();

	void showCompletedTasksCleared();

	void showLoadingTasksError();

	void showNoTasks();

	void showActiveFilterLabel();

	void showCompletedFilterLabel();

	void showAllFilterLabel();

	void showNoActiveTasks();

	void showNoCompletedTasks();

	void showSuccessfullySavedMessage();

	boolean isActive();

}
