package music;

import database.DatabaseConnection;

import java.util.Optional;
import java.sql.*;

public record Song(String artist, String title, int duration) {
    public static class Persistance{

        public static Optional<Song> read(int index) {
            Optional<Song> song = Optional.empty();
            try {
                Connection con = DatabaseConnection.getConnection("jdbc:sqlite:songs.db");
                System.out.println("Database connection established.");
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM song WHERE id = ?;");
                stmt.setInt(1, index);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    System.out.println("ResultSet contains data.");
                    if (rs.getString("artist") != null) {
                        System.out.println("Artist found: " + rs.getString("artist"));
                        song = Optional.of(new Song(rs.getString("artist"), rs.getString("title"), rs.getInt("length")));
                    } else {
                        System.out.println("Artist is null.");
                    }
                } else {
                    System.out.println("No data found for the given index.");
                }

                rs.close();
                stmt.close();
                con.close();
            } catch (java.sql.SQLException e) {
                System.out.println("SQL Exception: " + e.getMessage());
            }
            return song;
        }
    }
}
