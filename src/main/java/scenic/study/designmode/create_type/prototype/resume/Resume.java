package scenic.study.designmode.create_type.prototype.resume;

/**
 * Created by scenic on 16/8/9.
 */
public class Resume implements Cloneable{
    private String name;
    private String age;
    private String sex;
    private WorkExperience workExperience;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public WorkExperience getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(WorkExperience workExperience) {
        this.workExperience = workExperience;
    }

    @Override
    public Resume clone()  {
        Resume newResume = null;
        try {
            newResume = (Resume) super.clone();
            newResume.workExperience = (WorkExperience) workExperience.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return newResume;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", workExperience=" + workExperience +
                '}';
    }
}
