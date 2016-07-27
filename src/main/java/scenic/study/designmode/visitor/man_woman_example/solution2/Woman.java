package scenic.study.designmode.visitor.man_woman_example.solution2;

/**
 * Created by scenic on 16/7/26.
 */
public class Woman extends Person {
    public Woman(State state) {
        super(state);
    }

    @Override
    public void getConclusion() {
        {
            String name = getClass().getSimpleName();

            switch (getState()) {
                case fail:
                    System.out.println(name + "失败时,眼泪汪汪,谁也劝不了");
                    break;

                case love:
                    System.out.println(name + "恋爱时,遇事懂也装作不懂");
                    break;
                case success:
                    System.out.println(name + "成功时,背后多半有一个不成功的男人");
                    break;
            }
        }
    }
}
