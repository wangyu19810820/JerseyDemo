package util;

// 自定义类型也可以用于查询参数（@QueryParam）
// 但是自定义类型，也需要满足一定规则，下面是简要规则，具体参考官方文档
// 有一个接收一个字符串参数的构造函数
// 或者有一个命名为 fromstring 或 valueOf 的静态方法，接收一个字符串参数
public class Sex {

    private String sex;

//    public Sex(String sex) {
//        if ("male".equals(sex) || "0".equals(sex)) {
//            this.sex = "male";
//            return;
//        }
//        if ("female".equals(sex) || "1".equals(sex)) {
//            this.sex = "female";
//            return;
//        }
//        this.sex = "";
//    }

//    public static Sex valueOf(String sex) {
//        Sex obj = new Sex();
//        if ("male".equals(sex) || "0".equals(sex)) {
//            obj.sex = "male";
//            return obj;
//        }
//        if ("female".equals(sex) || "1".equals(sex)) {
//            obj.sex = "female";
//            return obj;
//        }
//        obj.sex = "";
//        return obj;
//    }

    public static Sex fromString(String sex) {
        Sex obj = new Sex();
        if ("male".equals(sex) || "0".equals(sex)) {
            obj.sex = "male";
            return obj;
        }
        if ("female".equals(sex) || "1".equals(sex)) {
            obj.sex = "female";
            return obj;
        }
        obj.sex = "";
        return obj;
    }

    public String getDesc() {
        return this.sex;
    }
}
