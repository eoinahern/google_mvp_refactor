package com.example.android.architecture.blueprints.todoapp.DI.modules;

import android.app.Application;
import android.content.Context;

import com.example.android.architecture.blueprints.todoapp.data.FakeTasksRemoteDataSource;
import com.example.android.architecture.blueprints.todoapp.data.source.TasksRepository;
import com.example.android.architecture.blueprints.todoapp.data.source.local.TasksLocalDataSource;

import javax.inject.Named;
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
	@Singleton
	@Named("application_context")
	public Context cont() {
		return application;
	}

	@Provides
	@Singleton
	public static FakeTasksRemoteDataSource remoteSource() {
		return FakeTasksRemoteDataSource.getInstance();
	}

	@Provides
	@Singleton
	public static TasksLocalDataSource localDataSource(@Named("application_context") Context cont) {
		return TasksLocalDataSource.getInstance(cont);
	}

	@Provides
	@Singleton
	public static TasksRepository repository(FakeTasksRemoteDataSource fakeTasksRemoteDataSource,
											 TasksLocalDataSource tasksLocalDataSource) {

		return TasksRepository.getInstance(fakeTasksRemoteDataSource, tasksLocalDataSource);
	}


}
