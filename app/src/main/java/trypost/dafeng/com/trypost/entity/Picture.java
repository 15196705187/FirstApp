package trypost.dafeng.com.trypost.entity;

/**
 * Created by asus on 2017/3/25.
 */
public class Picture {
    private int photoId;
    private String name;
    private  int number;

    public Picture(int photoId, String name, int number) {
        this.photoId = photoId;
        this.name = name;
        this.number = number;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
