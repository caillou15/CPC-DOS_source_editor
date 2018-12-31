package editor;

import javax.swing.*;
import java.awt.*;

public class BarreOutils extends JPanel {
    public BarreOutils() {
        super(new BorderLayout());

        JToolBar toolBar = new JToolBar();

        ///boutons
        JButton nouveau = new JButton("Nouveau");
        JButton ouvrir = new JButton("OUvrir...");
        JButton enregistrer = new JButton("Enregistrer");
        JButton enregistrer_sous = new JButton("Enregistrer sous...");

        toolBar.add(nouveau);
        toolBar.add(ouvrir);
        toolBar.add(enregistrer);
        toolBar.add(enregistrer_sous);

        toolBar.setFloatable(false);
        toolBar.setRollover(true);
        toolBar.setSize(1000, 20);

        add(toolBar, BorderLayout.PAGE_START);
        //setSize(2000, 20);
    }
}
