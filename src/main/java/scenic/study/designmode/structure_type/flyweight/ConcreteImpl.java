package scenic.study.designmode.structure_type.flyweight;

import java.util.Hashtable;

import scenic.study.designmode.structure_type.flyweight.abstract_core.User;
import scenic.study.designmode.structure_type.flyweight.abstract_core.WebSite;

/**
 * Created by scenic on 16/8/10.
 */
class ConcreteImpl {
    static class ConcreteWebsite1 extends WebSite {

        public ConcreteWebsite1(String name) {
            super(name);
        }

        @Override
        public void abUse(User user) {

            System.out.println("网站分类 : " + name + " 用户名: "+ user.getName() +  "\t instance " + this);
        }
    }

    /**
     * Created by scenic on 16/8/10.
     */
    public static class WebSiteFactory {
        private Hashtable flyweights = new Hashtable();
        public WebSite getWebSiteCategory(String key){
            if(!flyweights.containsKey(key)){
                flyweights.put(key,new ConcreteWebsite1(key));
            }
            return (WebSite) flyweights.get(key);
        }
    }
}
