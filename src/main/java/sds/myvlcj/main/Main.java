package sds.myvlcj.main;

import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.binding.RuntimeUtil;

import javax.swing.*;

public class Main {

    private static final String TITLE = "My First VLCJ App";
    private static final String VIDEO_PATH = "D:\\workspace_sds\\test\\my_vlcj\\src\\main\\resources\\video\\test.mp4";
    private static final String VIDEO_URL = "https://media.webtvlive.eu/redirect/chd-edge/_definst_/smil:chamber_tv_hd.smil?type=m3u8";

    public static final void main(String... args){
        chargerLibrairie();
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );
        } catch(Exception ex){
            ex.printStackTrace();
        }
        App app = new App(TITLE);
        app.initialize();
        //app.loadVideo(VIDEO_PATH);
        app.loadVideoFromURL(VIDEO_URL);
        System.out.println("coucou");
    }
    public static void chargerLibrairie(){
        NativeLibrary.addSearchPath(
                RuntimeUtil.getLibVlcLibraryName(), "C:\\DEV\\tools\\vlc-3.0.11-win32\\vlc-3.0.11");
    }
    // get a file from the resources folder
    // works everywhere, IDEA, unit test and JAR file.
    /*private static InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }*/
}
