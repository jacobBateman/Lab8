package music;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {
    @Test
    void isPlaylistEmpyt() { //Zadanie 1b
        Playlist playlist = new Playlist();
        assertTrue(playlist.isEmpty(), "Playlista powinna być pusta");
    }

    @Test
    void sizeEqualsOne() { //Zadanie 1c
        Playlist playlist = new Playlist();
        Song song = new Song("Linkin Park", "Burn It Down", 230);
        playlist.add(song);
        assertEquals(1, playlist.size(),"Playlista ma więcej niż jeden element!");
    }

    @Test
    void sameSongIn() { //Zadanie 1d/e
        Playlist playlist = new Playlist();
        Song song = new Song("Rush", "Tom Sawyer", 276);
        playlist.add(song);
        assertEquals(song, playlist.get(0));
    }

    @Test
    void negativeTime() { //Zadanie f-h
        Playlist playlist = new Playlist();
        Song song = new Song("Arctic Monkeys", "Fluorescent Adolescent",183);
        playlist.add(song);
        playlist.atSecond(-1);
    }

    @Test
    void tooMuchTime() { //Zadanie f-h
        Playlist playlist = new Playlist();
        Song song = new Song("Arctic Monkeys", "Fluorescent Adolescent",183);
        playlist.add(song);
        playlist.atSecond(190);
    }


}
