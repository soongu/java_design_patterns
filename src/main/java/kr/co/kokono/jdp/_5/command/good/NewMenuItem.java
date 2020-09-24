package kr.co.kokono.jdp._5.command.good;

import java.awt.*;

public class NewMenuItem extends MenuItem implements Command {

    private TextArea text;

    public NewMenuItem(String s, TextArea text) {
        super(s);
        this.text = text;
    }

    @Override
    public void execute() {
        text.setText(null);
    }
}
