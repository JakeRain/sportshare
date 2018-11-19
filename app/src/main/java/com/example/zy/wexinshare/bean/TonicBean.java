package com.example.zy.wexinshare.bean;

import java.util.ArrayList;
import java.util.List;

public class TonicBean{
    public static final String FID = "fid";
    public static final String TITLE = "name";
    public static final String CONTENT = "msg";
    public static final String ID = "id";
    /**
     * title : 左旋肉碱
     * content : ["左旋肉碱是药吗？我来给大家科普一下，首先，左旋肉碱属于一种氨基酸，它独特的作用可以作为脂肪运送的载体，帮助游离的脂肪颗粒运送到线粒体（发电站）进行供能，消化分解为二氧化碳和水，完成减脂的过程。所以，左旋肉碱不仅不是药，而且是在你减脂期必备的一种具有减脂功能的氨基酸，有效提升代谢、促进燃脂。","脂肪有三种：皮下脂肪、内脏脂肪、血液脂肪！1、皮下脂肪危害最小，影响美观和身体行动；2、内脏脂肪诱发各类内脏疾病，如脂肪肝，三高等。3、血管脂肪诱发各类心血管疾病，如心肌梗塞、各类血管堵塞引起的中风等疾病。选择健康，追求永恒！加油！","北欧海盗左旋肉碱  让你甩掉游泳圈，完美蜕变好伴侣  纯度高：高含量左旋肉碱加速燃脂 液体形式：比片剂粉末更易吸收  富含维生素：效果更快，减脂不疲惫  超高性价比：用量可达100次燃脂一夏","北欧海盗左旋肉碱15万，国内最火爆的减脂单品，纯度高达100%，燃脂效率加倍！清爽饮料口感，挑战你的味蕾，每瓶可用100次，够用三月！","北欧海盗左旋15万，减脂神器。怎么减？平时有氧能减一斤，喝了它能减两斤。","还没告白成功吗？那是你们之间差了一个北欧海盗左旋的距离！兄弟，我只能帮你到这了！","夏日炎炎，北欧海盗\u2014\u2014液体左旋，身材性感，你需要十五万陪伴。","难道必须和喜欢的食物说再见，才能实现瘦身？难道爱和快乐只属于那些A4腰的小腰精？北欧海盗+动力实验室减脂套餐，圆你纤瘦梦想（左旋肉碱+脂肪终结者）","左旋肉碱是一种促使脂肪转化为能量的类氨基酸，对人体无毒副作用。左旋肉碱的主要生理功能是促进脂肪转化成能量，服用左旋肉碱能够在减少身体脂肪、降低体重的同时，不减少水分和肌肉，在2003年被国际肥胖健康组织认定为最安全无副作用的减肥营养补充品。","此时此刻，喝完了左旋15万，感觉汗像洗了个澡一样，减脂必备补剂，帮助脂肪分解，干就是了，你的坚持，终将美好。","性价比最高的北欧海盗左旋15万，七月开始了减肥要提上日程了，别做思想上的巨人，一瓶用三个月，陪伴你减脂从始至终。","眼看7月就要过去，摸摸自己肚子上的肉，是不是恨不得再快一点。脂肪搬运工\u201c左旋肉碱\u201d帮你加速燃脂，给你的计划\u201c涡轮增压\u201d，北欧海盗左旋肉碱十五万，不含咖啡因，运动前补充，提高燃脂效率，安心减脂无负担，一款性价比最高的减脂产品。","解答题：脂肪堆积=肥胖 求：怎样才能高效减脂？ 答：当然是坚持每天训练前使用北欧海盗左旋肉碱","减脂如果没有喝过北欧海盗左旋15万，那就真的落伍啦！减脂性价比之王、一瓶100次的用量，减到你瘦为止！","十年前中国1亿胖子，十年后的今天，中国5亿多的胖子，一瓶北欧海盗左旋肉碱15万，解决脂肪问题","当脂肪遇到北欧海盗液体左旋肉碱15万，减脂便不再是难事 高纯度左旋，加速脂肪燃烧，富含维生素，提升你的耐力，训练前来10ml，瘦身减脂一步到位。"]
     */
    private String fid;
    private String title;
    private List<Circle> content;
    public TonicBean(){
        content = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Circle> getContent() {
        return content;
    }

    public void addContent(String msg,int id) {
        if(content == null){
            content = new ArrayList<Circle>() ;
        }
        content.add(new Circle(id,msg));
    }
    public void addContent(Circle circle){
        if(content == null)
            content = new ArrayList<>();
        content.add(circle);
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFid() {
        return fid;
    }



    public static class Circle{
        public int id;
        public String content;
        public Circle(int id,String content){
            this.id = id;
            this.content = content;
        }
    }

//    @Override
//    public String toString() {
//        return content.size()+ "";
//    }
}
