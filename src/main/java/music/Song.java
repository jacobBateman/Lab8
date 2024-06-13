package music;

import database.DatabaseConnection;

import java.util.Optional;
import java.sql.*;

public record Song(String artist, String title, int duration) {
    public static class Persistance{
        Optional<Song> song = Optional.empty();
        public  Optional<Song> read(int index){
            try {
                Connection con = DatabaseConnection.getConnection("jdbc:sqlite:songs.db");
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM song WHERE id = " + index + ";");
                ResultSet rs = stmt.executeQuery();
                if(rs.getString("artist")!=null){
                    song = Optional.of(new Song(rs.getString("artist"),rs.getString("title"),rs.getInt("lenght")));
                }
            }catch(java.sql.SQLException e){
                System.out.println(e.getMessage());
            }
            return song;
        }
    }
}
