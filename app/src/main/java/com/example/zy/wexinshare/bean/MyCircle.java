package com.example.zy.wexinshare.bean;

public class MyCircle {
    public String name;
    public String msg ;
    public String pic;
    public MyCircle(String name,String msg){
        this.msg = msg;
        this.name = name;
    }
    public MyCircle(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
