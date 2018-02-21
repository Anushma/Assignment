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
public class Daily extends BaseModel {

    @PrimaryKey(autoincrement = true)
    public int pk;
    @Column
    @SerializedName("summary")
    @Expose
    public String summary;
    @Column
    @SerializedName("icon")
    @Expose
    public String icon;

    @SerializedName("data")
    @Expose
    public List<Datum> data = null;
}
