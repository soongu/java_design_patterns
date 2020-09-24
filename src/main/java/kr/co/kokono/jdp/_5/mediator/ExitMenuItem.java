package kr.co.kokono.jdp._5.mediator;

import java.awt.*;

public class ExitMenuItem extends MenuItem implements Command {

    Mediator mediator;

    public ExitMenuItem(String s, Mediator mediator) {

        super(s);
        this.mediator = mediator;
        mediator.regist(this);
    }

    @Override
    public void execute() {
        mediator.exit();
    }
}
