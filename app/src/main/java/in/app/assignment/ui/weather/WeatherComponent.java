package in.app.assignment.ui.weather;

import dagger.Component;

import in.app.assignment.di.modules.component.AppComponent;

/**
 * Created by Papercrane on 20-02-2018.
 */


@WeatheScope
@Component(modules = WeatherModule.class, dependencies = AppComponent.class)
interface WeatherComponent {

    void inject(WeatherActivity weatherActivity);
}
