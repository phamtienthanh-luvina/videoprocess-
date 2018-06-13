package com.mycompany.videoprocess;

import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.authoring.container.mp4.MovieCreator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MuxMp4 {

    public static void merge(String audio, String video, String output) throws IOException {
        Movie countVideo = MovieCreator.build(video);
        Movie countAudioEnglish = MovieCreator.build(audio);

        Track audioTrackEnglish = countAudioEnglish.getTracks().get(0);
        audioTrackEnglish.getTrackMetaData().setLanguage("eng");

        countVideo.addTrack(audioTrackEnglish);

        Container out = new DefaultMp4Builder().build(countVideo);
        FileOutputStream fos = new FileOutputStream(new File(output));
        out.writeContainer(fos.getChannel());
        fos.close();

    }
}
