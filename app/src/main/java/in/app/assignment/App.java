package in.app.assignment;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;

import in.app.assignment.di.modules.component.AppComponent;
import in.app.assignment.di.modules.ApplicationModule;

import in.app.assignment.di.modules.NetworkModule;
import in.app.assignment.di.modules.component.DaggerAppComponent;

/**
 * Created by Papercrane on 16-02-2018.
 */

public class App extends Application {
    public static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(new FlowConfig.Builder(this).openDatabasesOnInit(true).build());
        debugSetup();
        mAppComponent = buildAppComponent();
        mAppComponent.inject(this);

    }

    private void debugSetup() {
        if (BuildConfig.DEBUG) {
            FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);
            Stetho.initializeWithDefaults(this);
        }
    }

    private AppComponent buildAppComponent() {
        String BASE_URL = "https://api.darksky.net/";
        return DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule(BASE_URL))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
