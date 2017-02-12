package game_store.ApplicationLayer.dataTypes;

public class Game {
    private int game_ID;
    private String game_title;
    private int game_price;
    private String game_platform;
    private String game_genre;
    private String game_release_date;
    private int game_age;
    private String game_sys_req;

    public Game(int game_ID, String game_title, String game_genre, String game_platform, int game_price, String game_release_date, int game_age, String game_sys_req) {
        this.game_ID = game_ID;
        this.game_title = game_title;
        this.game_price = game_price;
        this.game_platform = game_platform;
        this.game_genre = game_genre;
        this.game_release_date = game_release_date;
        this.game_age = game_age;
        this.game_sys_req = game_sys_req;
    }

    public Game(){}

    public int getGame_ID() {
        return game_ID;
    }

    public void setGame_ID(int game_ID) {
        this.game_ID = game_ID;
    }

    public String getGame_title() {
        return game_title;
    }

    public void setGame_title(String game_title) {
        this.game_title = game_title;
    }

    public int getGame_price() {
        return game_price;
    }

    public void setGame_price(int game_price) {
        this.game_price = game_price;
    }

    public String getGame_platform() {
        return game_platform;
    }

    public void setGame_platform(String game_platform) {
        this.game_platform = game_platform;
    }

    public String getGame_genre() {
        return game_genre;
    }

    public void setGame_genre(String game_genre) {
        this.game_genre = game_genre;
    }

    public String getGame_release_date() {
        return game_release_date;
    }

    public void setGame_release_date(String game_release_date) {
        this.game_release_date = game_release_date;
    }

    public int getGame_age() {
        return game_age;
    }

    public void setGame_age(int game_age) {
        this.game_age = game_age;
    }

    public String getGame_sys_req() {
        return game_sys_req;
    }

    public void setGame_sys_req(String game_sys_req) {
        this.game_sys_req = game_sys_req;
    }

    @Override
    public String toString() {
        return "Game{" +
                "game_ID=" + game_ID +
                ", game_title='" + game_title + '\'' +
                ", game_price=" + game_price +
                ", game_platform='" + game_platform + '\'' +
                ", game_genre='" + game_genre + '\'' +
                ", game_release_date='" + game_release_date + '\'' +
                ", game_age=" + game_age +
                '}';
    }
}
