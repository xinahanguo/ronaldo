package com.ronaldo.demo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wcx on 2015/11/2.
 */
public abstract class BaseFragment extends Fragment{

    protected Context mContext = null;
    protected static String TAG_LOG = null;

    private boolean isPrepared;
    private boolean isFirstResume = true;
    private boolean isFirstVisible = true;
    private boolean isFirstInvisible = true;

    /***
     *
     *      fragement第一次显示时
         *
     *
     */



    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (isFirstVisible) {
                isFirstVisible = false;
                initPrepare();
            } else {
                onUserVisible();
            }
        } else {
            if (isFirstInvisible) {
                isFirstInvisible = false;
                onFirstUserInvisible();
            } else {
                onUserInvisible();
            }
        }
    }


    @Override
    public void onAttach(Context context) {//fragment与该activity绑定，fragment第一次与activity产生关联时调用，以后将不再调用
        super.onAttach(context);
        mContext = context;
        TAG_LOG = this.getClass().getSimpleName();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {//窗口显示后就会调用此方法
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {//返回fragment挂载的view
        if (getContentViewLayoutID() != 0) {
            return inflater.inflate(getContentViewLayoutID(), null);
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {//窗口初始化完毕，可以调用控件
        super.onActivityCreated(savedInstanceState);
        initView();
        initPrepare();
    }

    private synchronized void initPrepare() {
        if (isPrepared) {
            onFirstUserVisible();
        } else {
            isPrepared = true;
        }
    }

    protected FragmentManager getSupportFragmentManager() {
        return getActivity().getSupportFragmentManager();
    }


    protected abstract void onFirstUserVisible();//fragment首次显示时，这里可以做一些初始化的工作，仅仅只执行一次

    protected abstract void onUserVisible();

    protected abstract void onUserInvisible();

    private void onFirstUserInvisible() {//fragment首次invisible时执行

    }


    @Override
    public void onStart() {
        super.onStart();
    }


    @Override
    public void onResume() {
        super.onResume();
        if (isFirstResume) {
            isFirstResume = false;
            return;
        }
        if (getUserVisibleHint()) {
            onUserVisible();
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        if (getUserVisibleHint()) {
            onUserInvisible();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {            //与该activity解绑
        super.onDetach();
    }

    protected abstract int getContentViewLayoutID();
    protected abstract void initView();
}
