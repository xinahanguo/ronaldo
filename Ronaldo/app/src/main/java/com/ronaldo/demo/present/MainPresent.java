package com.ronaldo.demo.present;

import android.content.Context;

import com.ronaldo.demo.interactor.MainInteractor;
import com.ronaldo.demo.interactor.impl.MainInteractorImpl;
import com.ronaldo.demo.view.MainView;

/**
 * Created by wcx on 2015/11/2.
 */
public class MainPresent implements Present{

    private Context mContext = null;
    private MainView mHomeView = null;
    private MainInteractor mHomeInteractor = null;

    public MainPresent(Context context, MainView homeView) {
        if (null == homeView) {
            throw new IllegalArgumentException("Constructor's parameters must not be Null");
        }
        mContext = context;
        mHomeView = homeView;
        mHomeInteractor = new MainInteractorImpl();
    }

    @Override
    public void initialized() {
        mHomeView.initializeViews(mHomeInteractor.getPagerFragments(), mHomeInteractor.getNavigationListData(mContext));
    }
}
