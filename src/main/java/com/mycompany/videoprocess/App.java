package com.mycompany.videoprocess;

import java.io.File;

public class App {

    public static void main(String[] args) {
        String path = "C:\\Users\\MyPC\\Desktop\\a.mp4";
        try {
            File video = new File(path);
            VideoToAudio.convertToAudio(video);
            //VideoToAudio.convertToMP3(video);
            
//            MuxMp4.merge("C:\\Users\\MyPC\\Desktop/output.mp3", path, "C:\\Users\\MyPC\\Desktop\\x.mp4");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
