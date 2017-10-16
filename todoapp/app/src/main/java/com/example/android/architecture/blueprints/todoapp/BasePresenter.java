package com.example.android.architecture.blueprints.todoapp;

public class BasePresenter<T extends BaseView> implements Presenter<T> {

	private T view;

	@Override
	public void start() {

	}

	@Override
	public void attachView(T mvpView) {
		this.view = view;
	}

	@Override
	public void detachView() {
		view = null;
	}

	public final boolean isViewAttached() {
		return view != null;
	}

	public final T getView() {
		return view;
	}
}
