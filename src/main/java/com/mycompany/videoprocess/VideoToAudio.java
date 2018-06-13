package com.mycompany.videoprocess;

import java.io.File;
import java.io.IOException;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;

public class VideoToAudio {

    static String path = "C:\\Users\\MyPC\\Desktop/output.wav";
    static String pathpm3 = "C:\\Users\\MyPC\\Desktop/output.mp3";

    public static void convertToAudio(File video) throws IllegalArgumentException, InputFormatException, EncoderException, IOException {
        File target = new File(path);
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(new Integer(128000));
        audio.setChannels(new Integer(2));
        audio.setSamplingRate(new Integer(44100));
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("wav");
        attrs.setAudioAttributes(audio);
        Encoder encoder = new Encoder();
        encoder.encode(video, target, attrs);

    }

    public static void convertToMP3(File video) throws IllegalArgumentException, InputFormatException, EncoderException {
        File target = new File(pathpm3);
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(new Integer(128000));
        audio.setChannels(new Integer(2));
        audio.setSamplingRate(new Integer(44100));
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");
        attrs.setAudioAttributes(audio);
        Encoder encoder = new Encoder();
        encoder.encode(video, target, attrs);
    }

}
