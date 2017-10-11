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

import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.design.widget.Snackbar;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.android.architecture.blueprints.todoapp.BaseActivity;
import com.example.android.architecture.blueprints.todoapp.Injection;
import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.util.ActivityUtils;
import com.example.android.architecture.blueprints.todoapp.util.EspressoIdlingResource;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Displays an add or edit task screen.
 */
public class AddEditTaskActivity extends BaseActivity implements AddEditTaskContract.View {

    public static final int REQUEST_ADD_TASK = 1;
	@BindView(R.id.add_task_title) TextView mTitle;
	@BindView(R.id.add_task_description) TextView mDescription;

	@Inject AddEditTaskPresenter presenter;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpToolbar();
		ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        setTitleText();


        //fragments have to go

        /*AddEditTaskFragment addEditTaskFragment =
                (AddEditTaskFragment) getSupportFragmentManager().findFragmentById(
                        R.id.contentFrame);*/

        /*String taskId = getIntent().getStringExtra(AddEditTaskFragment.ARGUMENT_EDIT_TASK_ID);

        if (addEditTaskFragment == null) {
            addEditTaskFragment = AddEditTaskFragment.newInstance();

            if (getIntent().hasExtra(AddEditTaskFragment.ARGUMENT_EDIT_TASK_ID)) {
                ab.setTitle(R.string.edit_task);
                Bundle bundle = new Bundle();
                bundle.putString(AddEditTaskFragment.ARGUMENT_EDIT_TASK_ID, taskId);
                addEditTaskFragment.setArguments(bundle);
            } else {
                ab.setTitle(R.string.add_task);
            }*/

           /* ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    addEditTaskFragment, R.id.contentFrame);
        }*/

        // todo: instance of presenter required in class now. injected!!!
        /*new AddEditTaskPresenter(Injection.provideUseCaseHandler(),
                taskId,
                addEditTaskFragment,
                Injection.provideGetTask(getApplicationContext()),
                Injection.provideSaveTask(getApplicationContext())
        );*/
    }

	@Override
	public int getChildLayout() {
		return R.layout.addtask_act;
	}

	@Override public void inject() {

	}

	private void setTitleText() {

    	if (getIntent().hasExtra(AddEditTaskFragment.ARGUMENT_EDIT_TASK_ID)) {
				ab.setTitle(R.string.edit_task);
			} else {
				ab.setTitle(R.string.add_task);
			}
    }

	@Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @VisibleForTesting
    public IdlingResource getCountingIdlingResource() {
        return EspressoIdlingResource.getIdlingResource();
    }

	@Override
	public void setPresenter(AddEditTaskContract.Presenter presenter) {
		//not required!!! presenter will be injected!!
	}

	@Override
	public void showEmptyTaskError() {
		Snackbar.make(mTitle, getString(R.string.empty_task_message), Snackbar.LENGTH_LONG).show();
	}

	@Override
	public void showTasksList() {

	}

	@Override
	public void setTitle(String title) {
		mTitle.setText(title);
	}

	@Override
	public void setDescription(String description) {
		mDescription.setText(description);
	}

	@Override public boolean isActive() {
		return false;
	}
}
