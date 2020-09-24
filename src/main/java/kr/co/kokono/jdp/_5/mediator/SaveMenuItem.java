package kr.co.kokono.jdp._5.mediator;

import java.awt.*;

public class SaveMenuItem extends MenuItem implements Command {

    Mediator mediator;

    public SaveMenuItem(String s, Mediator mediator) {
        super(s);
        this.mediator = mediator;
        mediator.regist(this);
    }

    @Override
    public void execute() {
        mediator.save();
    }
}
