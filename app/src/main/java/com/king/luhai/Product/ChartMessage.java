package com.king.luhai.Product;

/**
 * Created by Administrator on 2016-8-29.
 */
public class ChartMessage {

    public static final int MESSAGE_FROM = 0;
    public static final int MESSAGE_TO = 1;

    private int direction;
    private String content;

    public ChartMessage(int direction, String content) {
    }

    ;
    super();
    this.direction=direction;
    this.content=content;


    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;

    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }


}