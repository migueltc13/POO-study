// Exercise 4
import java.time.LocalDate;

public class Video {

    private String name;
    private byte[] content;
    private LocalDate date;
    private int resolution;
    private int duration; // seconds
    private String[] comments;
    private int countComments;
    private int capacityComments;
    private int likes;
    private int dislikes;

    private static final int DEFAULT_CAPACITY_COMMENTS = 100;

    /* Constructures */
    public Video() {
        this.name = "Video";
        this.content = new byte[0];
        this.date = LocalDate.now();
        this.resolution = 720;
        this.duration = 0;
        this.comments = new String[DEFAULT_CAPACITY_COMMENTS];
        this.countComments = 0;
        this.capacityComments = DEFAULT_CAPACITY_COMMENTS;
        this.likes = 0;
        this.dislikes = 0;
    }

    public Video(
        String name,
        byte[] content,
        LocalDate date,
        int resolution,
        int duration,
        int capacityComments)
    {
        this.name = name;
        this.content = content;
        this.date = date;
        this.resolution = resolution;
        this.duration = duration;
        this.comments = new String[capacityComments];
        this.countComments = 0;
        this.capacityComments = capacityComments;
        this.likes = 0;
        this.dislikes = 0;
    }

    public Video(Video video) {
        this.name = video.getName();
        this.content = video.getContent();
        this.date = video.getDate();
        this.resolution = video.getResolution();
        this.duration = video.getDuration();
        this.comments = video.getComments();
        this.countComments = video.getCountComments();
        this.capacityComments = video.getCapacityComments();
        this.likes = video.getLikes();
        this.dislikes = video.getDislikes();
    }

    /* instance methods */
    public String getName() {
        return this.name;
    }
    public byte[] getContent() {
        return this.content;
    }
    public LocalDate getDate() {
        return this.date;
    }
    public int getResolution() {
        return this.resolution;
    }
    public int getDuration() {
        return this.duration;
    }
    public String[] getComments() {
        return this.comments;
    }
    public int getCountComments() {
        return this.countComments;
    }
    public int getCapacityComments() {
        return this.capacityComments;
    }
    public int getLikes() {
        return this.likes;
    }
    public int getDislikes() {
        return this.dislikes;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setContent(byte[] content) {
        this.content = content;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setResolution(int resolution) {
        this.resolution = resolution;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setComments(String[] comments) {
        this.comments = comments;
    }
    public void setCountComments(int countComments) {
        this.countComments = countComments;
    }
    public void setCapacityComments(int capacityComments) {
        this.capacityComments = capacityComments;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    // (b)
    public void addComment(String comment) {
        int count = this.getCountComments();
        int cap = this.getCapacityComments();

        if (count + 1 > cap)
            return;

        String[] comments = this.getComments();
        comments[count++] = comment;
        this.setComments(comments);
        this.setCountComments(count);
    }

    // (c)
    public long qtsDiasDepois() {
        LocalDate date = this.getDate();
        LocalDate now = LocalDate.now();
        return date.until(now).getDays();
    }

    // (d)
    public void like() {
        this.setLikes(this.getLikes() + 1);
    }

    // (e)
    public String processa() {
        // returns the string with the bytes of the video content (in binary format)
        byte[] content = this.getContent();
        StringBuilder sb = new StringBuilder();
        for (byte b : content) {
            sb.append(String.format("%8s\n", Integer.toBinaryString(b & 0xFF)).replace(' ', '0'));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Video video = new Video();
        System.out.println(video.qtsDiasDepois());

        video.addComment("First comment");
        video.addComment("Second comment");
        System.out.println("Comments: " + video.getCountComments());

        System.out.println("Likes: " + video.getLikes());
        video.like();
        System.out.println("Likes: " + video.getLikes());

        video.setContent(new byte[] { 0, 1, 2, 3, 4, 4, 3, 2, 1, 0 });
        System.out.println(video.processa());
    }
}
