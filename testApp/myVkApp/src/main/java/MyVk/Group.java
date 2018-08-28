package MyVk;

import com.google.gson.annotations.SerializedName;

public class Group {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("screen_name")
    String screenName;
    @SerializedName("is_closed")
    int isClosed;
    @SerializedName("type")
    String type;
    @SerializedName("is_admin")
    int isAdmin;
    @SerializedName("is_member")
    int isMember;
    @SerializedName("photo_50")
    String photo50;
    @SerializedName("photo_100")
    String photo100;
    @SerializedName("photo_200")
    String photo200;
    public Group(){}
    public Group(int i){
        this.id=i;
    }

    public Group(int i, String s, String kazan__rent, int i1, String group, int i2, int i3, String s1, String s2, String s3) {
        this.id=i;
        this.name=s;
        this.screenName=kazan__rent;
        this.isClosed=i1;
        this.type=group;
        this.isAdmin=i2;
        this.isMember=i3;
        this.photo50=s1;
        this.photo100=s2;
        this.photo200=s3;
    }

}
