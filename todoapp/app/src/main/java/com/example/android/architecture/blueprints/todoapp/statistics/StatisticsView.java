package com.example.android.architecture.blueprints.todoapp.statistics;

import com.example.android.architecture.blueprints.todoapp.BaseView;

/**
 * Created by eoin_a on 16/10/2017.
 */

public interface StatisticsView extends BaseView {

	void setProgressIndicator(boolean active);

	void showStatistics(int numberOfIncompleteTasks, int numberOfCompletedTasks);

	void showLoadingStatisticsError();

	boolean isActive();

}
