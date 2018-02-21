package in.app.assignment.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Papercrane on 16-02-2018.
 */
@Database(name = AssignmentDB.NAME, version = AssignmentDB.VERSION)
public class AssignmentDB {
    public static final String NAME = "MyDataBase";

    public static final int VERSION = 1;
}