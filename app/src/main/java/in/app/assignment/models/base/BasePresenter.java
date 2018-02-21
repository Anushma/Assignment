package in.app.assignment.models.base;

import javax.inject.Inject;

/**
 * Created by Papercrane on 20-02-2018.
 */

public abstract class BasePresenter<View extends BaseView> extends BaseRxClass {

    private View mBaseView;

    public void onCreate() {
    }

    ;

    public void onResume() {
    }

    ;

    void onDestroy() {
        unSubscribe();
    }

    protected View getView() {
        return this.mBaseView;
    }

    @Inject
    public void setBaseView(View baseView) {
        mBaseView = baseView;
    }
}
