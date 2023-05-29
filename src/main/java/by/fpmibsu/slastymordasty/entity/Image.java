package by.fpmibsu.slastymordasty.entity;

public class Image extends Entity{

    String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Image(String path) {
        this.path = path;
    }

    public Image(){

    }
}
