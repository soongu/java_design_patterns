package kr.co.kokono.jdp._5.command.bad;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NotePad implements ActionListener {

    private Menu file;
    private MenuItem _new;
    private MenuItem open;
    private MenuItem save;
    private MenuItem saveas;
    private MenuItem exit;

    private MenuBar bar;
    private TextArea text;
    private Frame frame;

    public NotePad() {
        file = new Menu("File");
        _new = new MenuItem("New");
        open = new MenuItem("Open");
        save = new MenuItem("Save");
        saveas = new MenuItem("Save As");
        exit = new MenuItem("Exit");

        bar = new MenuBar();
        text = new TextArea();

        file.add(_new);
        file.add(open);
        file.add(save);
        file.add(saveas);
        file.add(exit);

        bar.add(file);

        frame = new Frame("NotePad");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setMenuBar(bar);
        frame.add(text);
        frame.setBounds((1280-800)/2, (1024-600)/2, 800, 600);
        frame.setVisible(true);

        addListener();
    }

    private void addListener() {
        _new.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        saveas.addActionListener(this);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MenuItem item = (MenuItem) e.getSource();
        String str = item.getLabel();

        if(str.equals("New")) {
            clean();
        } else if (str.equals("Open")) {
            open();
        } else if (str.equals("Save")) {
            save();
        } else if (str.equals("Save As")) {
            saveas();
        } else if (str.equals("Exit")) {
            exit();
        }
    }

    public void clean() {
        text.setText(null);
    }

    public void open() {
        FileDialog dialog = new FileDialog(frame, "Open", FileDialog.LOAD);
        dialog.setVisible(true);
    }

    public void save() {
        FileDialog dialog = new FileDialog(frame, "Save", FileDialog.SAVE);
        dialog.setVisible(true);
    }

    public void saveas() {
        FileDialog dialog = new FileDialog(frame, "Save As", FileDialog.SAVE);
        dialog.setVisible(true);
    }

    public void exit() {
        System.exit(0);
    }
}
