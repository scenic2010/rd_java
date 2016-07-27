package scenic.study.designmode.visitor.man_woman_example.solution3;

import java.util.ArrayList;
import java.util.List;

import scenic.study.designmode.visitor.man_woman_example.solution3.core.Person;
import scenic.study.designmode.visitor.man_woman_example.solution3.core.Visitor;

/**
 * Created by scenic on 16/7/26.
 */
public class Execute {

    List<Person> persons = new ArrayList<>();

    public Execute(){
        persons.add(new Man());
        persons.add(new Woman());
    }

    public void execute(Visitor action){
        persons.forEach(p -> p.accept(action));
    }

}
