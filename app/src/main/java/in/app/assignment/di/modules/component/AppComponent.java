package in.app.assignment.di.modules.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import in.app.assignment.App;
import in.app.assignment.api.Repository;
import in.app.assignment.di.modules.ApplicationModule;
import in.app.assignment.di.modules.NetworkModule;
import in.app.assignment.di.modules.RepositoryModule;

/**
 * Created by Papercrane on 20-02-2018.
 */
@Singleton
@Component(modules = {NetworkModule.class,
        ApplicationModule.class,
        RepositoryModule.class})

public interface AppComponent {
    void inject(App app);

    Context getContext();

    Repository getRepository();

}

