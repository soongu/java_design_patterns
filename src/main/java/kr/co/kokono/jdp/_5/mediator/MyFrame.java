package kr.co.kokono.jdp._5.mediator;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {

    Mediator mediator;

    public MyFrame(String s, Mediator mediator) {
        super(s);
        this.mediator = mediator;

        //자기 자신을 mediator에 등록
        mediator.regist(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
