package sds.myvlcj.main;

import uk.co.caprica.vlcj.media.MediaRef;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * First App from the tutorial of VLCJ
 */
public class App extends JFrame {
    private static final long serialVersionUID = -1L;

    private final EmbeddedMediaPlayerComponent embeddedMediaPlayerComponent;

    private JButton playButton;

    public App(String title) {
        super(title);
        this.embeddedMediaPlayerComponent = new EmbeddedMediaPlayerComponent();
    }
    public void initialize() {
        this.setBounds(100, 100, 600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                embeddedMediaPlayerComponent.release();
                System.exit(0);
            }
        });
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(embeddedMediaPlayerComponent, BorderLayout.CENTER);

        JPanel controlsPane = new JPanel();
        playButton = new JButton("Play");
        controlsPane.add(playButton);
        contentPane.add(controlsPane, BorderLayout.SOUTH);
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                embeddedMediaPlayerComponent.mediaPlayer().controls().play();
            }
        });
        this.setContentPane(contentPane);
        this.setVisible(true);
    }
    public void loadVideo(String path) {
        embeddedMediaPlayerComponent.mediaPlayer().media().startPaused(path);
    }
    public void loadVideoFromURL(String url){
        embeddedMediaPlayerComponent.mediaPlayer().media().startPaused(url);
    }
}
