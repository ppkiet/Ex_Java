///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package learning.java;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.media.*;

public class MediaPlayerDemo extends JFrame {
  public static void main(String args[]) throws IOException, NoPlayerException {
    Player player;

    File file = new File("E:\\Project Video\\hoan thanh\\Happy new year 2016.mp4");

    player = Manager.createPlayer(file.toURI().toURL());
//    player.addControllerListener(new EventHandler());
    player.start(); // start player
    
    player.close();

    Component visual = player.getVisualComponent();
    Component control = player.getControlPanelComponent();

  }
}
