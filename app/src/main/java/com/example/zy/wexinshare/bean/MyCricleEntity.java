package com.example.zy.wexinshare.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/11/20.
 */

public class MyCricleEntity {


    private List<SportBean> sport;

    public List<SportBean> getSport() {
        return sport;
    }

    public void setSport(List<SportBean> sport) {
        this.sport = sport;
    }

    public static class SportBean {
        /**
         * name : 左旋肉碱
         * msg : 左旋肉碱是药吗？我来给大家科普一下，首先，左旋肉碱属于一种氨基酸，它独特的作用可以作为脂肪运送的载体，帮助游离的脂肪颗粒运送到线粒体（发电站）进行供能，消化分解为二氧化碳和水，完成减脂的过程。所以，左旋肉碱不仅不是药，而且是在你减脂期必备的一种具有减脂功能的氨基酸，有效提升代谢、促进燃脂。
         */

        private String name;
        private String msg;

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
    }
}
