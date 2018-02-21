package in.app.assignment.apimodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

import in.app.assignment.database.AssignmentDB;

/**
 * Created by Papercrane on 17-02-2018.
 */
@Table(database = AssignmentDB.class)
public class Hourly extends BaseModel{
    public Hourly() {
    }

    @PrimaryKey(autoincrement = true)
    public int pk;

    @SerializedName("sources")
    @Expose
    public List<String> sources = null;

    @SerializedName("isd-stations")
    @Expose
    public List<String> isdStations = null;

    @Column
    @SerializedName("units")
    @Expose
    public String units;
}
