package music;

import database.DatabaseConnection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.SQLException;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {


    @Test
    void rightIndex() throws SQLException {
        Optional<Song> songDB = Song.Persistance.read(3);
        Song expectedSong = new Song("Led Zeppelin", "Stairway to Heaven", 482);

        assertTrue(songDB.isPresent(), "Song should be present in the database");
        assertEquals(expectedSong, songDB.get(), "The song from the database should match the expected song");
    }

    @Test
    void tooHighIndex() throws SQLException {
        Optional<Song> songDB = Song.Persistance.read(50);
        assertFalse(songDB.isPresent());
    }

    @ParameterizedTest
    @MethodSource("songProvider")
    void testRead(int index, Song oczekiwanaPiosenka) throws SQLException {
        Optional<Song> songDB = Song.Persistance.read(index);

        assertTrue(songDB.isPresent());
        assertEquals(oczekiwanaPiosenka,songDB.get());
    }

    //Metoda podająca dane do testu powyżej
    static Stream<Arguments> songProvider(){
        return Stream.of(
                Arguments.of(3, new Song("The Beatles","Stairway to Heaven", 482)),
                Arguments.of(4,new Song("Bob Dylan","Like a Rolling Stone",373))
        );
    }
}

