package scenic.study.designmode.create_type.prototype;


import org.junit.Test;

import java.util.Random;
import java.util.Vector;

import scenic.study.designmode.create_type.prototype.resume.Resume;
import scenic.study.designmode.create_type.prototype.resume.WorkExperience;

/**
 * Created by scenic on 16/7/22.
 * 原型设计模式,
 * 用原型实例指定创建对象的种类,并且通过拷贝这些原型创建新的对象[DP]
 * <p/>
 * <p/>
 * 使用java变成思想中垃圾回收作为示例
 */
public class Main {
    static Random random = new Random();

    public static void main(String args[]) {


    }



    /**
     *
     */
    @Test
    public void solution1() {
        Vector<Trash> vector = new Vector();
        fillAllTrash_for_solution1(vector);

        System.out.println("all the trash weight sum value" + scenic.study.designmode.create_type.prototype.Trash.sumValue(vector));

        Vector<Trash> vGlass = new Vector<>();
        Vector<Trash> vPaper = new Vector<>();
        Vector<Trash> vAluminum = new Vector<>();

        for (Trash t : vector) {

            if (Glass.class.isInstance(t)) {
                vGlass.add(t);
            } else if (Paper.class.isInstance(t)) {
                vPaper.add(t);
            } else if (Aluminum.class.isInstance(t)) {
                vAluminum.add(t);
            }
        }

        System.out.println(Trash.sumValue(vGlass));
        System.out.println(Trash.sumValue(vPaper));
        System.out.println(Trash.sumValue(vAluminum));
    }

    /**
     * 方案一,如果需要增加一个垃圾类型果皮(peel),需要进行如下步骤:
     * 1. 重新创建一个新类型的 Peel
     * 2. 修改switch case ,增加peel
     * 3. 把类型个数改成3
     * 4. 创建一个 放置Peel的vector类型
     * 5. 增加一个 if 判断,是否是 peel
     * 6. 然后把Peel放到 vPeel里面
     * 7. 然后统计vPeel
     */
    @Test
    public void solution1_addNewType() {
        Vector<scenic.study.designmode.create_type.prototype.Trash> vector = new Vector();
        scenic.study.designmode.create_type.prototype.Trash trash = null;
        int typeCount = 3;
        for (int i = 0; i < 100; i++) {
            double weight = Math.random() * 1000;
            switch ((int) (Math.random() * typeCount)) {
                case 0:
                    trash = new Glass(weight);
                    break;
                case 1:
                    trash = new Paper(weight);
                    break;
                case 2:
                    trash = new Aluminum(weight);
                    break;
                case 3:
                    trash = new Peel(weight);
                    break;
            }
            vector.add(trash);
        }

        System.out.println("all the trash weight sum value" + Trash.sumValue(vector));

        Vector<Trash> vGlass = new Vector<>();
        Vector<Trash> vPaper = new Vector<>();
        Vector<Trash> vAluminum = new Vector<>();
        Vector<Trash> vPeel = new Vector<>();

        for (Trash t : vector) {

            if (Glass.class.isInstance(t)) {
                vGlass.add(t);
            } else if (Paper.class.isInstance(t)) {
                vPaper.add(t);
            } else if (Aluminum.class.isInstance(t)) {
                vAluminum.add(t);
            } else if (Peel.class.isInstance(t)) {
                vPeel.add(t);
            }
        }

        System.out.println(Trash.sumValue(vGlass));
        System.out.println(Trash.sumValue(vPaper));
        System.out.println(Trash.sumValue(vAluminum));
    }

    @Test
    public void solution2() throws ClassNotFoundException {
        String[] types = readTypesFromSource();

        TrashVector allTrashes = new TrashVector(Trash.class);
        fillAllTrash_for_solution2(types, allTrashes);

        System.out.println(allTrashes);

        /**
         * 使用TrashVectorList 来保存 "不同类型Trash的集合"
         */
        TrashVectorList trashVectorList = new TrashVectorList();


        trashVectorList.add(new TrashVector(Glass.class));
        trashVectorList.add(new TrashVector(Paper.class));
        trashVectorList.add(new TrashVector(Aluminum.class));
        trashVectorList.add(new TrashVector(Peel.class));

        trashVectorList.sortBin(allTrashes);

        trashVectorList.forEach(v -> System.out.println(v.getType().getSimpleName() + " " + Trash.sumValue(v)));
    }

    /**
     * 这个方案的目的是在方案二的基础上,可以灵活的改变Vector,用其他的集合代替
     */
    @Test
    public void solution3() {
        String[] types = readTypesFromSource();

        TrashVector allTrashes = new TrashVector(Trash.class);
//        VectorFillable 在这里是一个Adapter 设计
        fillAllTrash_for_solution3(types, new scenic.study.designmode.create_type.prototype.solution3.VectorFillable(allTrashes));

        System.out.println(allTrashes);

        /**
         * 使用TrashVectorList 来保存 "不同类型Trash的集合"
         */
        TrashVectorList trashVectorList = new TrashVectorList();


        trashVectorList.add(new TrashVector(Glass.class));
        trashVectorList.add(new TrashVector(Paper.class));
        trashVectorList.add(new TrashVector(Aluminum.class));
        trashVectorList.add(new TrashVector(Peel.class));

        trashVectorList.sortBin(allTrashes);

        trashVectorList.forEach(v -> System.out.println(v.getType().getSimpleName() + " " + Trash.sumValue(v)));
    }


    /**
     * 原型设计模式的最高境界
     */
    @Test
    public void solution5() {
        String[] types = readTypesFromSource();
        scenic.study.designmode.create_type.prototype.solution5.DynamicTrash allTrashes = new scenic.study.designmode.create_type.prototype.solution5.DynamicTrash();
//        VectorFillable 在这里是一个Adapter 设计
        fillAllTrash_for_solution3(types, allTrashes.fillable());
        allTrashes.keys().forEach(t -> System.out.println(t.getSimpleName() + "  " + Trash.sumValue(allTrashes.get(t))));
    }


    @Test
    public void testResume(){

        Resume resume1 = new Resume();
        resume1.setAge("19");
        resume1.setName("scenic");
        resume1.setSex("男");
        WorkExperience workExperience = new WorkExperience();
        workExperience.setCompany("lenovo");
        workExperience.setWorkData("2010-2015");
        resume1.setWorkExperience(workExperience);
        System.out.println(resume1);

        Resume resume2 = resume1.clone();
        resume2.setWorkExperience(new WorkExperience("2016-2017","google"));

        System.out.println(resume2);
    }


    /**
     * 目前我认为,这是使用原型设计模式所需要的,这些数据也是可以在配置文件中读取的.
     *
     * @return
     */
    private static String[] readTypesFromSource() {
        return new String[]{
                Glass.class.getName(),
                Paper.class.getName(),
                Aluminum.class.getName(),
                Peel.class.getName(),
                scenic.study.designmode.create_type.prototype.addNewTrash2.Cardboard.class.getName(),
        };
    }

    private void fillAllTrash_for_solution1(Vector<Trash> vector) {
        Trash trash = null;
        int typeCount = 2;
        for (int i = 0; i < 100; i++) {
            switch ((int) (Math.random() * typeCount)) {
                case 0:
                    trash = new Glass(Math.random() * 1000);
                    break;
                case 1:
                    trash = new Paper(Math.random() * 1000);
                    break;
                case 2:
                    trash = new Aluminum(Math.random() * 1000);
                    break;
                case 3:
                    break;
            }
            vector.add(trash);
        }
    }

    private void fillAllTrash_for_solution2(String[] types, TrashVector allTrashes) {
        for (int i = 0; i < 100; i++) {
            int typeIndex = random.nextInt(types.length);

            String typeStr = types[typeIndex];
            double weight = Math.random() * 1000;
            allTrashes.add(Trash.factory(new Trash.Info().setName(typeStr).setWeight(weight)));
        }
    }

    /**
     * 这种方案适用于任何频繁用到的集合类
     *
     * @param types
     * @param fillable
     */
    public static void fillAllTrash_for_solution3(String[] types, scenic.study.designmode.create_type.prototype.solution3.Fillable fillable) {
        for (int i = 0; i < 100; i++) {
            int typeIndex = random.nextInt(types.length);

            String typeStr = types[typeIndex];
            double weight = Math.random() * 1000;
            fillable.addTrash(Trash.factory(new Trash.Info().setName(typeStr).setWeight(weight)));
        }
    }
}
