package scenic.study.designmode.visitor.trash_in_prototype_example;


import java.util.ArrayList;
import java.util.List;

import scenic.study.designmode.visitor.trash_in_prototype_example.core.Visitable;
import scenic.study.designmode.visitor.trash_in_prototype_example.core.Visitor;

/**
 * Created by scenic on 16/7/26.
 */
public class Execute {


    private static class PriceVisitor implements Visitor {
        double sumAl;
        double sumPa;
        @Override
        public void visit(VAluminum vAluminum) {
            sumAl+=(vAluminum.getWeight() * vAluminum.value());
        }

        @Override
        public void visit(VPage vPage) {
            sumPa+=(vPage.getWeight() * vPage.value());
        }
    }


    private static class WeightVisitor implements Visitor{

        double sumAl;
        double sumPa;
        @Override
        public void visit(VAluminum vAluminum) {
            sumAl+=(vAluminum.getWeight() * vAluminum.value());
        }

        @Override
        public void visit(VPage vPage) {
            sumPa+=(vPage.getWeight() * vPage.value());
        }

        public void total(){
            System.out.println("VAluminum sum " + sumAl);
            System.out.println("VPage sum " + sumPa);
        }

    }

    public void execute(){
        final List list = new ArrayList<>();
        scenic.study.designmode.prototype.Main.fillAllTrash_for_solution3(
                new String[]{
                        VAluminum.class.getName(),
                        VPage.class.getName()
                },
                t -> list.add(t));

        WeightVisitor weightVisitor = new WeightVisitor();
        PriceVisitor priceVisitor = new PriceVisitor();

        list.forEach(t -> {
            ((Visitable) t).accept(weightVisitor);
            ((Visitable) t).accept(priceVisitor);

        });

        weightVisitor.total();
    }

}
