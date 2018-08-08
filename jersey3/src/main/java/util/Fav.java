package util;

// 自定义类型也可以用于集合类型的查询参数（@QueryParam）的元素
// 但是自定义类型，也需要满足一定规则，可参考Sex类注释，或官方文档
public class Fav {

    private String fav;

    public Fav(String fav) {
        this.fav = fav;
    }

    public static Fav valueOf(String fav) {
        return new Fav(fav);
    }

    public String getDesc() {
        return this.fav;
    }
}
