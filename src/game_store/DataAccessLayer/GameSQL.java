package game_store.DataAccessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import game_store.ApplicationLayer.dataTypes.Game;

public class GameSQL {
    private static ArrayList<Game> games = new ArrayList<Game>();

    public static List<Game> loadAllGames() throws Exception{   ///////handle exceptions with try - catch statements
        Connection con = MySqlConnection.getConnection();
        Statement st = con.createStatement();
        String sql = ("SELECT game_id, game_title, game_genre, game_platform, game_price, game_release_date, game_age_from, game_sys_req  FROM games");
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()) {
            int game_id = rs.getInt("game_id");
            String game_title = rs.getString("game_title");
            String game_genre = rs.getString("game_genre");
            String game_platform = rs.getString("game_platform");
            int game_price = rs.getInt("game_price");
            String game_release_date = rs.getDate("game_release_date").toString();
            int game_age = rs.getInt("game_age_from");
            String game_sys_req = rs.getString("game_sys_req");
            games.add(new Game(game_id, game_title, game_genre, game_platform, game_price, game_release_date, game_age, game_sys_req));
        }

        con.close();
        rs.close();
        st.close();

        return games;
    }

    public static void createGame(Game game) throws Exception {  // create game, not used because we can't display the picture of that game
        Connection con = MySqlConnection.getConnection();
        Statement st = con.createStatement();
        String sql = ("SELECT game_id, game_title, game_genre, game_platform, game_price, game_release_date, game_age_from  FROM games");
        ResultSet rs = st.executeQuery(sql);

        con.close();
        rs.close();
        st.close();
    }
}

