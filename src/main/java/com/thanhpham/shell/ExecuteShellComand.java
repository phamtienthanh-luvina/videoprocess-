package com.thanhpham.shell;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExecuteShellComand {

    public static void main(String[] args) {
        String ffmpegPath = "C:\\Users\\MyPC\\Desktop\\ffmpeg-4.0-win64-static\\bin\\";
        String imagePath = "C:\\Users\\MyPC\\Desktop\\ffmpeg-4.0-win64-static\\bin\\";
        String audioPath = "C:\\Users\\MyPC\\Desktop\\ffmpeg-4.0-win64-static\\bin\\";
        String outPath = "C:\\Users\\MyPC\\Desktop\\ffmpeg-4.0-win64-static\\bin\\";
        try {
//            ExecuteShellComand obj = new ExecuteShellComand();
//            String output = obj.executeCommand("C:\\Users\\MyPC\\Desktop\\ffmpeg-4.0-win64-static\\bin\\ffmpeg.exe -r 1 -loop 1 "
//                    + "-i C:\\Users\\MyPC\\Desktop\\ffmpeg-4.0-win64-static\\bin\\hiking.jpg "
//                    + "-i C:\\Users\\MyPC\\Desktop\\ffmpeg-4.0-win64-static\\bin\\output.wav "
//                    + "-acodec copy -r 1 -shortest -vf scale=1280:720 thanhpham.mp4");
//            System.out.println("xxxxxxxxx: " + output);

            Runtime rt = Runtime.getRuntime();
            String commandQuery = ffmpegPath + "ffmpeg.exe -r 1 -loop 1 -i "
                    + imagePath + "hiking.jpg -i "
                    + audioPath + "output.wav -acodec copy -r 1 -shortest -vf scale=1280:720 "
                    + outPath + "thanhpham.mp4";
            rt.exec(commandQuery);
        } catch (Exception ex) {
            Logger.getLogger(ExecuteShellComand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String executeCommand(String command) {
        StringBuffer output = new StringBuffer();
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();

    }
}
