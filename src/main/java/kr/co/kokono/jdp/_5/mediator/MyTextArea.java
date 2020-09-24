package kr.co.kokono.jdp._5.mediator;

import java.awt.*;

public class MyTextArea extends TextArea {

    Mediator mediator;

    public MyTextArea(String s, Mediator mediator) {
        super(s);
        this.mediator = mediator;
        mediator.regist(this);
    }
}
