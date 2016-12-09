package com.jx3.yanqijs.jx3equipment.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import butterknife.ButterKnife;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by yanqijs on 2016/10/27.
 */

public abstract class BaseActivity extends Activity {

    public Context mContext;
    private CompositeSubscription mSubscriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(LayoutId());
        //绑定butterknife
        ButterKnife.bind(this);
        addSubscription(subscribeEvents());
    }

    public abstract int LayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mSubscriptions != null) {
            mSubscriptions.clear();
        }
    }

    protected Subscription subscribeEvents() {
        return null;
    }

    protected void addSubscription(Subscription subscription) {
        if (subscription == null) return;
        if (mSubscriptions == null) {
            mSubscriptions = new CompositeSubscription();
        }
        mSubscriptions.add(subscription);
    }
}
