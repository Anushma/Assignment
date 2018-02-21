package in.app.assignment;


import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.app.assignment.ui.HistoryListActivity;

public class MainActivity extends AppCompatActivity {
    private static final int REPEAT_TIME_IN_SECONDS = 900;

    private static final int REPEAT = 1800;

    private static final int REPEAT1 = 3600;

    public static final String MEMORY = "memory";

    public static final String HISTORY = "history";

    public static final String BATTERY = "battery";

    public static final String NETWORK = "network";

    public static final String WEATHER = "weather";

    public static final String VERSION = "version";

    TimeIntervalDialog timeIntervalDialog;


    private static final String REPORT_FILTER = "reportFilter";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


    }


    @OnClick(R.id.card_memory)
    public void onMemoryOptionClicked() {

        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        Fragment frag = this.getSupportFragmentManager().findFragmentByTag(REPORT_FILTER);
        if (frag != null) {

            ft.remove(frag);
        }

        ft.addToBackStack(null);

        DialogFragment f = TimeIntervalDialog.newInstance(MEMORY);
        f.show(ft, REPORT_FILTER);


    }

    @OnClick(R.id.card_battery)
    public void onBateryClicked() {
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        Fragment frag = this.getSupportFragmentManager().findFragmentByTag(REPORT_FILTER);
        if (frag != null) {

            ft.remove(frag);
        }

        ft.addToBackStack(null);

        DialogFragment f = TimeIntervalDialog.newInstance(BATTERY);
        f.show(ft, REPORT_FILTER);


    }

    @OnClick(R.id.card_versionInfo)
    public void onVersionInfoClicked() {
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        Fragment frag = this.getSupportFragmentManager().findFragmentByTag(REPORT_FILTER);
        if (frag != null) {

            ft.remove(frag);
        }

        ft.addToBackStack(null);

        DialogFragment f = TimeIntervalDialog.newInstance(VERSION);
        f.show(ft, REPORT_FILTER);

    }


    @OnClick(R.id.card_network)
    public void onNetworkClicked() {
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        Fragment frag = this.getSupportFragmentManager().findFragmentByTag(REPORT_FILTER);
        if (frag != null) {

            ft.remove(frag);
        }

        ft.addToBackStack(null);

        DialogFragment f = TimeIntervalDialog.newInstance(NETWORK);
        f.show(ft, REPORT_FILTER);

    }

    @OnClick(R.id.card_weather)
    public void onWeatherClicked() {
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        Fragment frag = this.getSupportFragmentManager().findFragmentByTag(REPORT_FILTER);
        if (frag != null) {

            ft.remove(frag);
        }

        ft.addToBackStack(null);

        DialogFragment f = TimeIntervalDialog.newInstance(WEATHER);
        f.show(ft, REPORT_FILTER);

    }

    @OnClick(R.id.card_history)
    public void onHistoryClicked() {
        HistoryListActivity.start(this);
    }


}
