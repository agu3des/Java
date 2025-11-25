package PP.proxy_example_acessoVideosPremium;

public class Video {
    private int id;
    private String title;
    private String duration;
    private boolean premium;

    public Video(int id, String title, String duration, boolean premium) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.premium = premium;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public boolean isPremium() {
        return premium;
    }
}

