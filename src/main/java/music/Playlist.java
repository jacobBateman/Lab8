package music;

import java.util.ArrayList;

public class Playlist extends ArrayList<Song> {
    public Song atSecond(int seconds) throws IndexOutOfBoundsException{ //Zadanie f-h
        int totalAmountOfSeconds = 0;
        if (seconds < 0){
            throw new IndexOutOfBoundsException("Czas nie może być ujemny");
        }
        for(Song song : this){ //Przechodzi przez piosenki w ArrayList tej klasy;
            totalAmountOfSeconds += song.duration();
            if(seconds <= totalAmountOfSeconds){
                return song;
            }
        }
        throw new IndexOutOfBoundsException("Nie ma piosenki w podanym czasie"); //Rzucany wtedy gdy nie ma piosenki dla podanego czasu
    }
}
