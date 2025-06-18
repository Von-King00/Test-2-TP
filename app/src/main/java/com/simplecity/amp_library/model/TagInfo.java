package com.simplecity.amp_library.model;

import android.text.TextUtils;
import com.simplecity.amp_library.utils.StringUtils;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

/**
 * A holder for various id3 tag information associated with a file.
 */
public class TagInfo implements Serializable {

    private String artistName;
    private String albumArtistName;
    private String albumName;
    private String trackName;
    private int trackNumber;
    private int trackTotal;
    private int discNumber;
    private int discTotal;
    private String bitrate;
    private String format;
    private int sampleRate;
    private String genre;

    public static final String UNKNOWN = "Unknown";

    public TagInfo(String filePath) {
        if (filePath != null) {
            File file = new File(filePath);
            if (file.exists()) {
                try {
                    AudioFile audioFile = AudioFileIO.read(file);
                    this.artistName = getTag(audioFile, FieldKey.ARTIST);
                    this.albumArtistName = getTag(audioFile, FieldKey.ALBUM_ARTIST);
                    this.albumName = getTag(audioFile, FieldKey.ALBUM);
                    this.trackName = getTag(audioFile, FieldKey.TITLE);
                    this.trackNumber = StringUtils.parseInt(getTag(audioFile, FieldKey.TRACK));
                    this.trackTotal = StringUtils.parseInt(getTag(audioFile, FieldKey.TRACK_TOTAL));
                    this.discNumber = StringUtils.parseInt(getTag(audioFile, FieldKey.DISC_NO));
                    this.discTotal = StringUtils.parseInt(getTag(audioFile, FieldKey.DISC_TOTAL));
                    this.bitrate = getBitrate(audioFile);
                    this.format = getFormat(audioFile);
                    this.sampleRate = getSampleRate(audioFile);
                    this.genre = getTag(audioFile, FieldKey.GENRE);
                } catch (CannotReadException | IOException | TagException | ReadOnlyFileException | InvalidAudioFrameException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getTag(AudioFile audioFile, FieldKey key) {
        try {
            if (audioFile != null) {
                Tag tag = audioFile.getTag();
                if (tag != null) {
                    String result = tag.getFirst(key);
                    if (!TextUtils.isEmpty(result)) {
                        return result;
                    }
                }
            }
        } catch (UnsupportedOperationException ignored) {
            // Bloc vide intentionnel : certains fichiers peuvent ne pas supporter cette opération.
        }
        return UNKNOWN;
    }

    public static String getBitrate(AudioFile audioFile) {
        try {
            if (audioFile != null) {
                AudioHeader audioHeader = audioFile.getAudioHeader();
                return audioHeader.getBitRate();
            }
        } catch (UnsupportedOperationException ignored) {
            // Bloc vide intentionnel : certains fichiers peuvent ne pas supporter cette opération.
        }
        return UNKNOWN;
    }

    public static String getFormat(AudioFile audioFile) {
        try {
            if (audioFile != null) {
                AudioHeader audioHeader = audioFile.getAudioHeader();
                return audioHeader.getFormat();
            }
        } catch (UnsupportedOperationException ignored) {
            // Bloc vide intentionnel : certains fichiers peuvent ne pas supporter cette opération.
        }
        return UNKNOWN;
    }

    public static int getSampleRate(AudioFile audioFile) {
        try {
            if (audioFile != null) {
                AudioHeader audioHeader = audioFile.getAudioHeader();
                return audioHeader.getSampleRateAsNumber();
            }
        } catch (UnsupportedOperationException ignored) {
            // Bloc vide intentionnel : certains fichiers peuvent ne pas supporter cette opération.
        }
        return -1;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbumArtistName() {
        return albumArtistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public int getTrackTotal() {
        return trackTotal;
    }

    public void setTrackTotal(int trackTotal) {
        this.trackTotal = trackTotal;
    }

    public int getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(int discNumber) {
        this.discNumber = discNumber;
    }

    public int getDiscTotal() {
        return discTotal;
    }

    public void setDiscTotal(int discTotal) {
        this.discTotal = discTotal;
    }

    public String getBitrate() {
        return bitrate;
    }

    public void setBitrate(String bitrate) {
        this.bitrate = bitrate;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(int sampleRate) {
        this.sampleRate = sampleRate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}