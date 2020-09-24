package kr.co.kokono.jdp._5.mediator;

import java.awt.*;

public class Mediator {

    MenuItem _new;
    MenuItem open;
    MenuItem save;
    MenuItem saveas;
    MenuItem exit;
    Frame frame;
    TextArea text;

    //NewMenuItem을 등록하는 메서드
    public void regist(NewMenuItem menu) {
        this._new = menu;
    }

    //OpenMenuItem을 등록하는 메서드
    public void regist(OpenMenuItem menu) {
        this.open = menu;
    }

    //SaveMenuItem을 등록하는 메서드
    public void regist(SaveMenuItem menu) {
        this.save = menu;
    }

    //SaveAsMenuItem을 등록하는 메서드
    public void regist(SaveAsMenuItem menu) {
        this.saveas = menu;
    }

    //ExitMenuItem을 등록하는 메서드
    public void regist(ExitMenuItem menu) {
        this.exit = menu;
    }

    //Frame을 등록하는 메서드
    public void regist(MyFrame menu) {
        this.frame = menu;
    }

    //TextArea을 등록하는 메서드
    public void regist(TextArea menu) {
        this.text = menu;
    }

    public void clean() {
        text.setText(null);
    }

    public void open() {
        FileDialog dialog = new FileDialog(frame, "Open", FileDialog.LOAD);
        dialog.setVisible(true);
    }

    public void save() {
        FileDialog dialog = new FileDialog(frame, "Save", FileDialog.SAVE);
        dialog.setVisible(true);
    }

    public void saveAs() {
        FileDialog dialog = new FileDialog(frame, "Save As", FileDialog.SAVE);
        dialog.setVisible(true);
    }

    public void exit() {
        System.exit(0);
    }
}
