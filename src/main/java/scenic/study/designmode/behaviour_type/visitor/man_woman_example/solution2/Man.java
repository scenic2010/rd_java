package scenic.study.designmode.behaviour_type.visitor.man_woman_example.solution2;

/**
 * Created by scenic on 16/7/26.
 */
public class Man extends Person {
    public Man(State state) {
        super(state);
    }

    @Override
    public void getConclusion() {
        {

            String name = getClass().getSimpleName();

            switch (getState()) {
                case fail:
                    System.out.println(name + "失败时,闷头喝酒,谁也不同劝");
                    break;

                case love:
                    System.out.println(name + "恋爱时,凡是不懂也要装懂");
                    break;
                case success:
                    System.out.println(name + "成功时,背后多半有一个伟大的女人");
                    break;
            }
        }
    }
}
