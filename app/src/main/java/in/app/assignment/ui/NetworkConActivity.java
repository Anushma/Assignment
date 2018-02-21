package in.app.assignment.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.app.assignment.R;
import in.app.assignment.models.Memory;
import in.app.assignment.models.NetworkType;

/**
 * Created by Papercrane on 19-02-2018.
 */

public class NetworkConActivity extends Activity {

    @BindView(R.id.network_recycler_list)
    RecyclerView mNetworkList;

    LinearLayoutManager mLayoutManager;

    NetworkConAdapter networkConAdapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, NetworkConActivity.class);
        context.startActivity(starter);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_conn);
        ButterKnife.bind(this);
        mLayoutManager = new LinearLayoutManager(this);
        mNetworkList.setLayoutManager(mLayoutManager);

        networkConAdapter = new NetworkConAdapter(this, getAllEnries());

        mNetworkList.setAdapter(networkConAdapter);
    }


    private ArrayList<NetworkType> getAllEnries(){
        ArrayList<NetworkType> memory = new ArrayList<>();
        List<NetworkType> memoryList = SQLite.select().
                from(NetworkType.class).
                queryList();
        memory.addAll(memoryList);
        return memory;


    }



}
