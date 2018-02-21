package in.app.assignment;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import in.app.assignment.services.BatteryReceiver;
import in.app.assignment.services.DeviceReceiver;
import in.app.assignment.services.MemoryReceiver;
import in.app.assignment.services.NetworkTypeReceiver;
import in.app.assignment.services.WeatherBroadCastReceiver;


/**
 * Created by Papercrane on 19-02-2018.
 */

public class TimeIntervalDialog extends DialogFragment {
    private final String[] interval = {"5 min","10 min" ,"15 min"};

    public static final long INTERVAl = 60_000L;

    public  long UPDATE_INTERVAL;

    String tagline;
    public static final String TAGLINE = "tagline";
    @BindView(R.id.spinner)
    Spinner spinner;

    @BindView(R.id.textView)
    TextView textView;

    Unbinder unbinder;

    public static TimeIntervalDialog newInstance(String tag) {
        TimeIntervalDialog fragment = new TimeIntervalDialog();
        Bundle args = new Bundle();
        args.putString(TAGLINE, tag);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_time_interval_dialog, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayAdapter<String> genderSpinner = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, interval);
        spinner.setAdapter(genderSpinner);
        tagline = getArguments().getString(TAGLINE);
        if (Objects.equals(tagline, "memory")) {
            textView.setText("Proceed to view memory availability");
        } else if (Objects.equals(tagline, "battery")) {
            textView.setText("Proceed to view battery status");
        } else if (Objects.equals(tagline, "weather")) {
            textView.setText("Proceed to view weather report");
        } else if (Objects.equals(tagline, "version")) {
            textView.setText("Proceed to view device information");
        } else if (Objects.equals(tagline, "network")) {
            textView.setText("Proceed to view network connection type");
        }
    }

    @OnClick(R.id.go_button)
    public void onGoClicked() {
        if (Objects.equals(tagline, "memory")) {

            if (spinner.getSelectedItem()=="5 min"){

                UPDATE_INTERVAL = INTERVAl * 5;
            }

            else if (spinner.getSelectedItem()== "10 min"){
                UPDATE_INTERVAL = INTERVAl * 10;
            }

            else
                UPDATE_INTERVAL = INTERVAl * 15;
            Intent intent = new Intent(getContext(), MemoryReceiver.class);
            final PendingIntent pIntent = PendingIntent.getBroadcast(getContext(), MemoryReceiver.REQUEST_CODE3,
                    intent, PendingIntent.FLAG_UPDATE_CURRENT);
            long firstMillis = System.currentTimeMillis();
            AlarmManager alarm = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
            assert alarm != null;
            alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis,
                    UPDATE_INTERVAL, pIntent);

            dismiss();

        } else if (Objects.equals(tagline, "battery")) {
            if (spinner.getSelectedItem()=="5 min"){

                UPDATE_INTERVAL = INTERVAl * 5;
            }

            else if (spinner.getSelectedItem()== "10 min"){
                UPDATE_INTERVAL = INTERVAl * 10;
            }

            else
                UPDATE_INTERVAL = INTERVAl * 15;

            BatteryReceiver batteryReceiver = new BatteryReceiver();
            getActivity().registerReceiver(batteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
            Intent intent = new Intent(getContext(), BatteryReceiver.class);
            final PendingIntent pIntent = PendingIntent.getBroadcast(getContext(), BatteryReceiver.REQUEST_CODE1,
                    intent, PendingIntent.FLAG_UPDATE_CURRENT);
            long firstMillis = System.currentTimeMillis();
            AlarmManager alarm = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
            assert alarm != null;
            alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis,
                 UPDATE_INTERVAL, pIntent);

            dismiss();

        } else if (Objects.equals(tagline, "network")) {
            if (spinner.getSelectedItem()=="5 min"){

                UPDATE_INTERVAL = INTERVAl * 5;
            }

            else if (spinner.getSelectedItem()== "10 min"){
                UPDATE_INTERVAL = INTERVAl * 10;
            }

            else
                UPDATE_INTERVAL = INTERVAl * 15;

            Intent intent = new Intent(getContext(), NetworkTypeReceiver.class);
            final PendingIntent pIntent = PendingIntent.getBroadcast(getContext(), NetworkTypeReceiver.REQUEST_CODE2,
                    intent, PendingIntent.FLAG_UPDATE_CURRENT);
            long firstMillis = System.currentTimeMillis();
            AlarmManager alarm = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
            assert alarm != null;
            alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis,
                    UPDATE_INTERVAL, pIntent);
            dismiss();

        } else if (Objects.equals(tagline, "version")) {
            if (spinner.getSelectedItem()=="5 min"){

                UPDATE_INTERVAL = INTERVAl * 5;
            }

            else if (spinner.getSelectedItem()== "10 min"){
                UPDATE_INTERVAL = INTERVAl * 10;
            }

            else
                UPDATE_INTERVAL = INTERVAl * 15;

            Intent intent = new Intent(getContext(), DeviceReceiver.class);
            final PendingIntent pIntent = PendingIntent.getBroadcast(getContext(), DeviceReceiver.REQUEST_CODE,
                    intent, PendingIntent.FLAG_UPDATE_CURRENT);
            long firstMillis = System.currentTimeMillis();
            AlarmManager alarm = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
            assert alarm != null;
            alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis,
                    UPDATE_INTERVAL, pIntent);

            dismiss();

        }

        else if (Objects.equals(tagline, "weather")){

            if (spinner.getSelectedItem()=="5 min"){

                UPDATE_INTERVAL = INTERVAl * 5;
            }

            else if (spinner.getSelectedItem()== "10 min"){
                UPDATE_INTERVAL = INTERVAl * 10;
            }

            else
                UPDATE_INTERVAL = INTERVAl * 15;
            Intent intent = new Intent(getContext(), WeatherBroadCastReceiver.class);
            final PendingIntent pIntent = PendingIntent.getBroadcast(getContext(), WeatherBroadCastReceiver.REQUEST_CODE5,
                    intent, PendingIntent.FLAG_UPDATE_CURRENT);
            long firstMillis = System.currentTimeMillis();
            AlarmManager alarm = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
            assert alarm != null;
            alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis,
                    UPDATE_INTERVAL, pIntent);

            dismiss();

        }


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
