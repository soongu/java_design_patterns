package kr.co.kokono.jdp._5.command.good;

import java.awt.*;

public class SaveMenuItem extends MenuItem implements Command {

    private Frame frame;

    public SaveMenuItem(String s, Frame frame) {
        super(s);
        this.frame = frame;
    }

    @Override
    public void execute() {
        FileDialog dialog = new FileDialog(frame, "Save", FileDialog.SAVE);
        dialog.setVisible(true);
    }
}
