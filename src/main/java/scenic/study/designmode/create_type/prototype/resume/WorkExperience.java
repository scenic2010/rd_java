package scenic.study.designmode.create_type.prototype.resume;

/**
 * Created by scenic on 16/8/9.
 */
public class WorkExperience implements Cloneable{
    String workData;
    String company;

    public WorkExperience() {

    }

    public String getWorkData() {
        return workData;
    }

    public void setWorkData(String workData) {
        this.workData = workData;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public WorkExperience(String workData, String company) {
        this.workData = workData;
        this.company = company;
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "workData='" + workData + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
