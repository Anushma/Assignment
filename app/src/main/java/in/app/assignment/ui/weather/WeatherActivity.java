package in.app.assignment.ui.weather;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.LocationRequest;
import com.patloew.rxlocation.RxLocation;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import im.delight.android.location.SimpleLocation;
import in.app.assignment.R;
import in.app.assignment.apimodels.Currently;
import in.app.assignment.apimodels.Weather;
import in.app.assignment.apimodels.WeatherList;
import in.app.assignment.models.base.BaseActivity;
import in.app.assignment.models.base.BasePresenter;
import in.app.assignment.ui.DeviceInfoAdapter;
import io.reactivex.disposables.Disposable;

/**
 * Created by Papercrane on 20-02-2018.
 */

public class WeatherActivity extends BaseActivity<WaeatherPresenter> implements WeatherContract.View {

    private static final long UPDATE_INTERVAL = 10_000L;
    private static final long FASTEST_UPDATE_INTERVAL = UPDATE_INTERVAL / 2;
    private static final long MAX_WAIT_TIME = UPDATE_INTERVAL * 3;
    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 646;
    private LocationRequest mLocationRequest;
    private static final String TAG = "LocationUpdatesService";
    private RxLocation mRxLocation;
    private Disposable mDisposable;

    private Location previousLocation;
    private static final int PERMISSION_LOCATION = 123;
    private static final int MY_PERMISSIONS_FINE_LOCATION = 52;
    SimpleLocation location;

    double latitude = 0.0;
    double longitude = 0.0;

    @BindView(R.id.weather_recycler_list)
    RecyclerView mWeatherList;

    LinearLayoutManager mLayoutManager;

    WeatherReportAdapter weatherReportAdapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, WeatherActivity.class);
        starter.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle b = intent.getBundleExtra("Weather");
            String distance = b.getString("Weather");
            if (distance != null) {
                getPresenter().getWeather(String.valueOf(latitude), String.valueOf(longitude));
            }

        }
    };


    private boolean checkPermission() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void show(Currently currently) {


    }

    @Override
    public void onError() {

    }

    @Override
    protected void injectDependencies() {
        DaggerWeatherComponent.builder()
                .weatherModule(new WeatherModule(this))
                .appComponent(getAppComponent())
                .build()
                .inject(this);


    }

    private void handleLocation(Location location) {

        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        getPresenter().getWeather(String.valueOf(latitude), String.valueOf(longitude));
        if (previousLocation == null) {
            previousLocation = location;
        }

    }


    private void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(UPDATE_INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setMaxWaitTime(MAX_WAIT_TIME);
    }

    @Override
    protected void init() {

        if (checkPermission()) {
            mRxLocation = new RxLocation(this);
            createLocationRequest();
            LocationRequest locationRequest = LocationRequest.create()
                    .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

            mRxLocation.location().updates(locationRequest)
                    .flatMap(aBoolean -> mRxLocation.location().updates(mLocationRequest))
                    .subscribe(this::handleLocation,
                            throwable -> Log.e(TAG, "onStartCommand: ", throwable));



        } else {
            Toast.makeText(this, "Please enable your location", Toast.LENGTH_LONG).show();
        }

        mLayoutManager = new LinearLayoutManager(this);
        mWeatherList.setLayoutManager(mLayoutManager);

        weatherReportAdapter = new WeatherReportAdapter(this, getAllEnries());

        mWeatherList.setAdapter(weatherReportAdapter);

    }



    private ArrayList<Currently> getAllEnries() {
        ArrayList<Currently> weather = new ArrayList<>();
        List<Currently> weatherList = SQLite.select().
                from(Currently.class).
                queryList();
        weather.addAll(weatherList);
        return weather;


    }

    @Override
    public int setLayout() {
        return R.layout.activity_weather_repo_list;
    }
}
