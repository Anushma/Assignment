package in.app.assignment.models.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.app.assignment.App;
import in.app.assignment.di.modules.component.AppComponent;
import io.reactivex.ObservableTransformer;

/**
 * Created by Papercrane on 20-02-2018.
 */

public abstract class BaseActivity<Presenter extends BasePresenter>
        extends AppCompatActivity implements BaseView {
    private Presenter mPresenter;
    private Unbinder mUnbinder;

    protected abstract void injectDependencies();

    protected abstract void init();

    @LayoutRes
    public abstract int setLayout();

    public Presenter getPresenter() {
        return this.mPresenter;
    }

    @Inject
    public void setPresenter(Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        injectDependencies();
        setContentView(setLayout());
        mUnbinder = ButterKnife.bind(this);
        init();
        mPresenter.onCreate();

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }



    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy(); // unsubcribes all activity and presenter bound subscriptions(disposibles)
        mUnbinder.unbind();
    }

    protected <T> ObservableTransformer<T, T> addToCompositeDisposible() {
        return mPresenter.addToCompositeDisposible();
    }

    public AppComponent getAppComponent() {
        return App.class.cast(getApplication()).getAppComponent();
    }


}
