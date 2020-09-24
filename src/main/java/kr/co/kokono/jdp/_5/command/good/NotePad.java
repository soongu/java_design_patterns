package kr.co.kokono.jdp._5.command.good;

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
        frame = new Frame("NotePad");
        text = new TextArea();

        //개선된 코드
        _new = new NewMenuItem("New", text);
        open = new OpenMenuItem("Open", frame);
        save = new SaveMenuItem("Save", frame);
        saveas = new SaveAsMenuItem("Save As", frame);
        exit = new ExitMenuItem("Exit");

        bar = new MenuBar();

        file.add(_new);
        file.add(open);
        file.add(save);
        file.add(saveas);
        file.add(exit);

        bar.add(file);

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

    /**
     * 개선된 코드
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        Command com = (Command) e.getSource();
        com.execute();
    }


}
