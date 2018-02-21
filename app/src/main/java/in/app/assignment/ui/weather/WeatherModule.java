package in.app.assignment.ui.weather;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Papercrane on 20-02-2018.
 */

@Module
class WeatherModule {
    private WeatherContract.View mView;

    WeatherModule(WeatherContract.View view) {
        mView = view;
    }

    @WeatheScope
    @Provides
    WeatherContract.View providePresenter() {
        return mView;
    }


}

