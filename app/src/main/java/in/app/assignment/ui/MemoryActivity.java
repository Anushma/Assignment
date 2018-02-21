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
import in.app.assignment.models.Device;
import in.app.assignment.models.Memory;

/**
 * Created by Papercrane on 19-02-2018.
 */

public class MemoryActivity extends Activity {
    @BindView(R.id.memory_recycler_list)
    RecyclerView mMemoryRecycler;

    LinearLayoutManager mLayoutManager;

    MemoryListAdapter memoryListAdapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, MemoryActivity.class);
        context.startActivity(starter);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_details);
        ButterKnife.bind(this);

        mLayoutManager = new LinearLayoutManager(this);
        mMemoryRecycler.setLayoutManager(mLayoutManager);

        memoryListAdapter = new MemoryListAdapter(this, getAllEnries());

        mMemoryRecycler.setAdapter(memoryListAdapter);
    }


    private ArrayList<Memory> getAllEnries(){
        ArrayList<Memory> memory = new ArrayList<>();
        List<Memory> memoryList = SQLite.select().
                from(Memory.class).
                queryList();
        memory.addAll(memoryList);
        return memory;


    }
}
