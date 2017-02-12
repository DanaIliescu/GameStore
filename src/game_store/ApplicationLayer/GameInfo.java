package game_store.ApplicationLayer;

import game_store.ApplicationLayer.dataTypes.Game;
import game_store.DataAccessLayer.*;

import java.util.List;

public class GameInfo {
    private static List<Game> games;
    Game game;

    public static List<Game> selectAllGames() throws Exception
    {
        games = GameSQL.loadAllGames();
        return games;
    }
    public void createGame(Game g)  throws Exception
    {
        game = g;
        GameSQL.createGame(game);
    }
}
