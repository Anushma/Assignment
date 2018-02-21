package in.app.assignment.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;
import android.os.StatFs;
import android.support.annotation.Nullable;
import android.text.format.Formatter;
import android.util.Log;

import java.io.File;

import in.app.assignment.models.Memory;

/**
 * Created by Papercrane on 15-02-2018.
 */

public class MemoryService extends IntentService {


    public MemoryService() {
        super("Memory");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        getMemory();


    }

//    public static long remainingLocalStorage() {
//        StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
//        stat.restat(Environment.getDataDirectory().getPath());
//        long bytesAvailable = (long) stat.getBlockSize() * (long) stat.getAvailableBlocks();
//        return bytesAvailable;
//    }

    public void getMemory() {

        Memory memory = new Memory();
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        String form = Formatter.formatFileSize(this, availableBlocks * blockSize);
        memory.internalMemory = form;
        Log.d("form", form);

        StatFs statf = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long bytesAvailable;
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            bytesAvailable = statf.getBlockSizeLong() * statf.getAvailableBlocksLong();
        } else {
            bytesAvailable = (long) statf.getBlockSize() * (long) statf.getAvailableBlocks();
        }
        long megAvailable = bytesAvailable / (1024 * 1024);
        memory.externalMemory = megAvailable;
        memory.save();
        Log.d("available", "Available MB : " + megAvailable);

    }

//    private void add() {
//        Memory memory = new Memory();
//        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
//        long bytesAvailable;
//        if (android.os.Build.VERSION.SDK_INT >=
//                android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
//            bytesAvailable = stat.getBlockSizeLong() * stat.getAvailableBlocksLong();
//        } else {
//            bytesAvailable = (long) stat.getBlockSize() * (long) stat.getAvailableBlocks();
//        }
//        long megAvailable = bytesAvailable / (1024 * 1024);
//        memory.externalMemory = megAvailable;
//        Log.d("available", "Available MB : " + megAvailable);
//    }

}
