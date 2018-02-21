package in.app.assignment.models.base;

import io.reactivex.ObservableTransformer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Papercrane on 20-02-2018.
 */


abstract class BaseRxClass {
    private CompositeDisposable mDisposable;

    protected void addSubscription(Disposable disposable) {
        if (mDisposable == null) {
            mDisposable = new CompositeDisposable();
        }
        mDisposable.add(disposable);
    }

    protected void unSubscribe() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }

    protected <T> ObservableTransformer<T, T> addToCompositeDisposible() {
        return upstream -> upstream.doOnSubscribe(this::addSubscription);
    }
}
