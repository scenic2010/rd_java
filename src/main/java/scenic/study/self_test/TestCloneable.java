package scenic.study.self_test;

/**
 * Created by scenic on 16/7/12.
 */
public class TestCloneable {


    public static void main(String args[]) {

        Plane plane = new Plane();

        plane.setA(1);
        plane.setB("plane----");
        plane.setWing1(new Wing(2, "wing1"));
        plane.setWing2(new Wing(3, "wing2"));


        System.out.println(plane);
        System.out.println(plane.clone());

    }

    private static class Plane implements Cloneable {
        int a = 0;
        String b;
        Wing wing1;
        Wing wing2;

        public void setWing1(Wing wing1) {
            this.wing1 = wing1;
        }

        public void setWing2(Wing wing2) {
            this.wing2 = wing2;
        }

        @Override
        public Object clone() {
            Plane o = null;
            try {
                o = (Plane) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            o.wing1 = (Wing) o.wing1.clone();
            o.wing2 = (Wing) o.wing2.clone();
            return o;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        @Override
        public String toString() {
            return "Plane{" +
                    "a=" + a +
                    ", b='" + b + '\'' +
                    ", wing1=" + wing1 +
                    ", wing2=" + wing2 +
                    '}' + this.hashCode();
        }
    }

    private static class Wing implements Cloneable {
        int a;
        String b;

        public Wing(int a, String b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        @Override
        protected Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public String toString() {
            return "Wing{" +
                    "a=" + a +
                    ", b='" + b + '\'' +
                    '}' + this.hashCode();
        }
    }


}
