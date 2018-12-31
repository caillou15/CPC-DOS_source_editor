package editor;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;

public class Fenetre {

    private JFrame fenetre;

    public Fenetre() {
        initGUI();
    }

    private JMenuBar initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        //menu fichier
        JMenu menu_fichier = new JMenu("Fichier");

        JMenuItem quitterMenuItem = new JMenuItem("Quitter");
        quitterMenuItem.addActionListener(e -> System.exit(0));

        menu_fichier.add(quitterMenuItem);
        menuBar.add(menu_fichier);

        return menuBar;
    }

    private JPanel initEditorPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
        //textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CPCDOSC+);
        RTextScrollPane sp = new RTextScrollPane(textArea);

        sp.setFoldIndicatorEnabled(true);



        panel.add(sp);
        panel.setLocation(0, 40);
        return panel;
    }

    private void initGUI() {
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException | IllegalAccessException | ClassNotFoundException | InstantiationException e) {
            // handle exception
        }

        fenetre = new JFrame();

        fenetre.setTitle("Editeur de code source pour CPCDOS");
        fenetre.setSize(800, 600);
        fenetre.setResizable(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //init fenetre
        /*
         * voir schema
         */

        //init bar d'outils
        fenetre.setJMenuBar(initMenuBar());

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel toolBar = new BarreOutils();
        mainPanel.add(toolBar, BorderLayout.PAGE_START);

        //init contenu fenetre

        //editor panel
        JTabbedPane tabbedEditor = new JTabbedPane();
        tabbedEditor.addTab("Document", initEditorPanel());
        mainPanel.add(tabbedEditor, BorderLayout.CENTER);
        //console panel
        JPanel consolePanel = new JPanel();
        JTextArea consoleText = new JTextArea(5,20);
        consoleText.setPreferredSize(new Dimension(1000, 100));
        consoleText.setEditable(false);
        consoleText.setBackground(Color.BLACK);
        consolePanel.add(consoleText);
        mainPanel.add(consolePanel, BorderLayout.SOUTH);
        //panneau gauche

        //explo panel
        JScrollPane exploScrollPane = new JScrollPane();
        JTree exploTree = new JTree();
        exploTree.setEditable(false);
        exploScrollPane.getViewport().add(exploTree);

        //liste fonctions panel
        JScrollPane fonctionScrollPane = new JScrollPane();
        JTree fonctionJTree = new JTree();
        fonctionJTree.setEditable(false);
        fonctionScrollPane.getViewport().add(fonctionJTree);

        JSplitPane gauchePanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, exploScrollPane, fonctionScrollPane);
        /*gauchePanel.add(exploScrollPane);

        gauchePanel.add(fonctionScrollPane);*/
        gauchePanel.setBackground(Color.GREEN);
        mainPanel.add(gauchePanel, BorderLayout.WEST);

        fenetre.add(mainPanel);
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
    }
}
