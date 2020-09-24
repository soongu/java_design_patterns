package kr.co.kokono.jdp._5.command.good;

import java.awt.*;

public class OpenMenuItem extends MenuItem implements Command {

    private Frame frame;

    public OpenMenuItem(String s, Frame frame) {
        super(s);
        this.frame = frame;
    }

    @Override
    public void execute() {
        FileDialog dialog = new FileDialog(frame, "Open", FileDialog.LOAD);
        dialog.setVisible(true);
    }
}
