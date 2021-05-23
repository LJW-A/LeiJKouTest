package lei.lei.entity;

import java.io.Serializable;

public class ApponitExam implements Serializable {

    private String  name;
    private String  AllowSex;
    private String  examSuiteName;
    private String  examSuiteId;
    private String  idCard;
    private String  tel;
    private String  birthday;
    private String  married;
    private String  AppSource;
    private String  AppSourceId;
    private String  AppDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAllowSex() {
        return AllowSex;
    }

    public void setAllowSex(String allowSex) {
        AllowSex = allowSex;
    }

    public String getExamSuiteName() {
        return examSuiteName;
    }

    public void setExamSuiteName(String examSuiteName) {
        this.examSuiteName = examSuiteName;
    }

    public String getExamSuiteId() {
        return examSuiteId;
    }

    public void setExamSuiteId(String examSuiteId) {
        this.examSuiteId = examSuiteId;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public String getAppSource() {
        return AppSource;
    }

    public void setAppSource(String appSource) {
        AppSource = appSource;
    }

    public String getAppSourceId() {
        return AppSourceId;
    }

    public void setAppSourceId(String appSourceId) {
        AppSourceId = appSourceId;
    }

    public String getAppDate() {
        return AppDate;
    }

    public void setAppDate(String appDate) {
        AppDate = appDate;
    }


    public ApponitExam() {

    }

    public ApponitExam(String name, String allowSex, String examSuiteName, String examSuiteId, String idCard, String tel, String birthday, String married, String appSource, String appSourceId, String appDate) {
        this.name = name;
        AllowSex = allowSex;
        this.examSuiteName = examSuiteName;
        this.examSuiteId = examSuiteId;
        this.idCard = idCard;
        this.tel = tel;
        this.birthday = birthday;
        this.married = married;
        AppSource = appSource;
        AppSourceId = appSourceId;
        AppDate = appDate;
    }
}
