package scenic.study.designmode.structure_type.decorator.abstract_core;

/**
 * Created by scenic on 16/8/10.
 */
public interface Displayable {
    void display();

     abstract class Finery implements Displayable {

        private Displayable displayable;

        public Finery(Displayable displayable) {
            this.displayable = displayable;
        }

        @Override
        public void display() {
            if(displayable != null){
                displayable.display();
            }
        }
    }
}
