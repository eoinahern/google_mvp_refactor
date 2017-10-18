package com.example.android.architecture.blueprints.todoapp.DI.components;


import com.example.android.architecture.blueprints.todoapp.DI.modules.ApplicationModule;
import com.example.android.architecture.blueprints.todoapp.addedittask.AddEditTaskActivityComponent;
import com.example.android.architecture.blueprints.todoapp.tasks.TasksActivityComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

	AddEditTaskActivityComponent plus(AddEditTaskActivityComponent.AddEitTaskActivityModule module);

	TasksActivityComponent plus(TasksActivityComponent.TasksActivityModule module);
}
