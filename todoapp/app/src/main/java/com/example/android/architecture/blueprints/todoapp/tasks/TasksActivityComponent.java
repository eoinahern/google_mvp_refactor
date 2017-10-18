package com.example.android.architecture.blueprints.todoapp.tasks;

import com.example.android.architecture.blueprints.todoapp.DI.components.BaseActivityComponent;
import com.example.android.architecture.blueprints.todoapp.DI.modules.BaseActivityModule;

import dagger.Module;
import dagger.Subcomponent;


@Subcomponent(modules = TasksActivityComponent.TasksActivityModule.class)
public interface TasksActivityComponent extends BaseActivityComponent<TasksActivity>{

	@Module
	class TasksActivityModule extends BaseActivityModule<TasksActivity>{

		public TasksActivityModule(TasksActivity activity) {
			super(activity);
		}
	}
}
