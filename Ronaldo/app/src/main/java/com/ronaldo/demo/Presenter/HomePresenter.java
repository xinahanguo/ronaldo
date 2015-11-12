package com.ronaldo.demo.presenter;

import android.content.Context;

import com.ronaldo.demo.view.HomeDataImpl;
import com.ronaldo.demo.view.HomeView;

/**
 * Created by wcx on 2015/11/12.
 */
public class HomePresenter implements Presenter{

    private Context mContext = null;
    private HomeView mHomeView = null;
    private HomeDataImpl mHomeInteractor = null;

    public HomePresenter(Context context, HomeView homeView){
        mContext = context;
        mHomeView = homeView;
        mHomeInteractor = new HomeDataImpl();
    }


    @Override
    public void init() {
        mHomeView.initializeViews(mHomeInteractor.getLeftFragment(), mHomeInteractor.getLeftListData(mContext));
    }
}
