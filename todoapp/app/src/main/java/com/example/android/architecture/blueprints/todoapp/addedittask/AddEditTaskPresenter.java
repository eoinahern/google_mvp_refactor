/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.architecture.blueprints.todoapp.addedittask;

import static com.google.common.base.Preconditions.checkNotNull;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.android.architecture.blueprints.todoapp.BasePresenter;
import com.example.android.architecture.blueprints.todoapp.BaseView;
import com.example.android.architecture.blueprints.todoapp.DI.annotation.scope.PerScreen;
import com.example.android.architecture.blueprints.todoapp.UseCase;
import com.example.android.architecture.blueprints.todoapp.UseCaseHandler;
import com.example.android.architecture.blueprints.todoapp.addedittask.domain.usecase.GetTask;
import com.example.android.architecture.blueprints.todoapp.addedittask.domain.usecase.SaveTask;
import com.example.android.architecture.blueprints.todoapp.tasks.domain.model.Task;

import javax.inject.Inject;

/**
 * Listens to user actions from the UI ({@link AddEditTaskFragment}), retrieves the data and
 * updates
 * the UI as required.
 */

@PerScreen
public class AddEditTaskPresenter extends BasePresenter<AddEditTaskView> {

    private final GetTask mGetTask;

    private final SaveTask mSaveTask;

    private final UseCaseHandler mUseCaseHandler;

    @Nullable
    private String mTaskId;

    /**
     * Creates a presenter for the add/edit view.
     * task id will be passed in a different manner!!
     */

    @Inject
    public AddEditTaskPresenter(@NonNull UseCaseHandler useCaseHandler,
								@NonNull GetTask getTask,
								@NonNull SaveTask saveTask) {
        mUseCaseHandler = checkNotNull(useCaseHandler, "useCaseHandler cannot be null!");

        //set task id different way!!!
        //mTaskId = taskId;
        mGetTask = checkNotNull(getTask, "getTask cannot be null!");
        mSaveTask = checkNotNull(saveTask, "saveTask cannot be null!");

    }

    @Override
    public void start() {
        if (mTaskId != null) {
            populateTask();
        }
    }

    //@Override
    public void saveTask(String title, String description) {
        if (isNewTask()) {
            createTask(title, description);
        } else {
            updateTask(title, description);
        }
    }

   // @Override
    public void populateTask() {
        if (mTaskId == null) {
            throw new RuntimeException("populateTask() was called but task is new.");
        }

        mUseCaseHandler.execute(mGetTask, new GetTask.RequestValues(mTaskId),
                new UseCase.UseCaseCallback<GetTask.ResponseValue>() {
                    @Override
                    public void onSuccess(GetTask.ResponseValue response) {
                        showTask(response.getTask());
                    }

                    @Override
                    public void onError() {
                        showEmptyTaskError();
                    }
                });
    }

    private void showTask(Task task) {
        // The view may not be able to handle UI updates anymore
           getView().setTitle(task.getTitle());
            getView().setDescription(task.getDescription());
    }

    private void showSaveError() {
        // Show error, log, etc.
    }

    private void showEmptyTaskError() {
			getView().showEmptyTaskError();
    }

    private boolean isNewTask() {
        return mTaskId == null;
    }

    private void createTask(String title, String description) {
        Task newTask = new Task(title, description);
        if (newTask.isEmpty()) {
            getView().showEmptyTaskError();
        } else {
            mUseCaseHandler.execute(mSaveTask, new SaveTask.RequestValues(newTask),
                    new UseCase.UseCaseCallback<SaveTask.ResponseValue>() {
                        @Override
                        public void onSuccess(SaveTask.ResponseValue response) {
                            getView().showTasksList();
                        }

                        @Override
                        public void onError() {
                            showSaveError();
                        }
                    });
        }
    }

    private void updateTask(String title, String description) {
        if (mTaskId == null) {
            throw new RuntimeException("updateTask() was called but task is new.");
        }
        Task newTask = new Task(title, description, mTaskId);
        mUseCaseHandler.execute(mSaveTask, new SaveTask.RequestValues(newTask),
                new UseCase.UseCaseCallback<SaveTask.ResponseValue>() {
                    @Override
                    public void onSuccess(SaveTask.ResponseValue response) {
                        // After an edit, go back to the list.
                        getView().showTasksList();
                    }

                    @Override
                    public void onError() {
                        showSaveError();
                    }
                });
    }

}
