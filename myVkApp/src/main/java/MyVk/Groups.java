package MyVk;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Groups {
    @SerializedName("count")
    Integer count;
    @SerializedName("items")
    List<Group> items=new ArrayList<>();
    public Groups(){

    }

}
