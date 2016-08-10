package scenic.study.designmode.structure_type.flyweight.abstract_core;

/**
 * Created by scenic on 16/8/10.
 */
public abstract class WebSite {
    protected String name;
    public WebSite(String name) {
        this.name = name;
    }

    @Deprecated
    public void use() {
        System.out.println("网站分类 : " + name + "\t instance " + this);
    }
    public abstract void abUse(User user);


    public static class OneTestClass extends WebSite {

        public OneTestClass(String name) {
            super(name);
        }

        @Override
        public void abUse(User user) {
            throw new RuntimeException("this method can support in this class " + this);
        }
    }
}
