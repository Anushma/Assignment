package in.app.assignment.models;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import in.app.assignment.database.AssignmentDB;

/**
 * Created by Papercrane on 16-02-2018.
 */
@Table(database = AssignmentDB.class)
public class Battery extends BaseModel {

    @PrimaryKey(autoincrement = true)
    public int id;

    @Column
    public int batteryLevel;

    @Column
    public String date;


    public Battery() {
    }
}
