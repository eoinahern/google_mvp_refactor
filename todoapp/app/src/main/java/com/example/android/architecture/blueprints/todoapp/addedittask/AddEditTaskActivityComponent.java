package com.example.android.architecture.blueprints.todoapp.addedittask;

import android.content.Context;

import com.example.android.architecture.blueprints.todoapp.DI.annotation.scope.PerScreen;
import com.example.android.architecture.blueprints.todoapp.DI.components.BaseActivityComponent;
import com.example.android.architecture.blueprints.todoapp.DI.modules.BaseActivityModule;
import com.example.android.architecture.blueprints.todoapp.addedittask.domain.usecase.GetTask;
import com.example.android.architecture.blueprints.todoapp.addedittask.domain.usecase.SaveTask;
import com.example.android.architecture.blueprints.todoapp.data.source.TasksRepository;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;

@PerScreen
@Subcomponent( modules = { AddEditTaskActivityComponent.AddEitTaskActivityModule.class})
public interface AddEditTaskActivityComponent extends BaseActivityComponent<AddEditTaskActivity> {

	@Module
	class AddEitTaskActivityModule extends BaseActivityModule<AddEditTaskActivity> {

		public AddEitTaskActivityModule(AddEditTaskActivity activity) {
			super(activity);
		}


		@Provides
		@PerScreen
		public GetTask getTask(TasksRepository tasksRepository) {
			return new GetTask(tasksRepository);
		}

		@Provides
		@PerScreen
		public SaveTask getSaveTask(TasksRepository tasksRepository) {
			return new SaveTask(tasksRepository);
		}
	}
}
