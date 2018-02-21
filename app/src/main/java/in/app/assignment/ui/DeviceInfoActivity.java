package in.app.assignment.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.app.assignment.R;
import in.app.assignment.models.Battery;
import in.app.assignment.models.Device;

/**
 * Created by Papercrane on 19-02-2018.
 */

public class DeviceInfoActivity extends Activity {

    @BindView(R.id.device_recycler_list)
    RecyclerView mDeviceList;

    LinearLayoutManager mLayoutManager;

    DeviceInfoAdapter deviceInfoAdapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, DeviceInfoActivity.class);
        context.startActivity(starter);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_info);
        ButterKnife.bind(this);
        mLayoutManager = new LinearLayoutManager(this);
        mDeviceList.setLayoutManager(mLayoutManager);

        deviceInfoAdapter = new DeviceInfoAdapter(this, getAllEnries());

        mDeviceList.setAdapter(deviceInfoAdapter);
    }


    private ArrayList<Device> getAllEnries(){
        ArrayList<Device> devices = new ArrayList<>();
        List<Device> deviceList = SQLite.select().
                from(Device.class).
                queryList();
        devices.addAll(deviceList);
        return devices;

    }
}
