package kr.co.kokono.jdp._5.mediator;

import java.awt.*;

public class OpenMenuItem extends MenuItem implements Command {

    Mediator mediator;

    public OpenMenuItem(String s, Mediator mediator) {
        super(s);
        this.mediator = mediator;
        mediator.regist(this);
    }

    @Override
    public void execute() {
        mediator.open();
    }
}
