package kr.co.kokono.jdp._5.mediator;

import java.awt.*;

public class SaveAsMenuItem extends MenuItem implements Command {
    private Mediator mediator;

    public SaveAsMenuItem(String s, Mediator mediator) {
        super(s);
        this.mediator = mediator;
        mediator.regist(this);
    }

    @Override
    public void execute() {
        mediator.saveAs();
    }
}
