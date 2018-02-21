package in.app.assignment.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.app.assignment.R;
import in.app.assignment.models.Battery;

/**
 * Created by Papercrane on 19-02-2018.
 */

public class BatteryStatusActivity extends Activity {

    @BindView(R.id.battery_recycler_list)
    RecyclerView mBatteryList;

    LinearLayoutManager mLayoutManager;

    BatteryListAdapter batteryListAdapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, BatteryStatusActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_status);
        ButterKnife.bind(this);
        mLayoutManager = new LinearLayoutManager(this);
        mBatteryList.setLayoutManager(mLayoutManager);

        batteryListAdapter = new BatteryListAdapter(this, getAllEnries());

        mBatteryList.setAdapter(batteryListAdapter);
    }


    private ArrayList<Battery> getAllEnries(){
        ArrayList<Battery> batteries = new ArrayList<>();
        List<Battery> batteryList = SQLite.select().
                from(Battery.class).
                queryList();
        batteries.addAll(batteryList);
        return batteries;

    }
}
