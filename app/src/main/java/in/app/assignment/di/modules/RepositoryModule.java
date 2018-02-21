package in.app.assignment.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import in.app.assignment.api.IRepository;
import in.app.assignment.api.Api;
import in.app.assignment.api.Repository;

/**
 * Created by Papercrane on 20-02-2018.
 */

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    Repository provideRepository(Api api) {
        return new IRepository(api);
    }

}
