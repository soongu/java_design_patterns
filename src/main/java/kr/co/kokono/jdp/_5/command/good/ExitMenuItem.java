package kr.co.kokono.jdp._5.command.good;

import java.awt.*;

public class ExitMenuItem extends MenuItem implements Command {

    private Frame frame;

    public ExitMenuItem(String s) {
        super(s);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
