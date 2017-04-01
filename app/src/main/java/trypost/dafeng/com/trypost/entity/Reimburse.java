package trypost.dafeng.com.trypost.entity;

/**
 * Created by asus on 2017/3/27.
 */
public class Reimburse {
    private boolean flag;
    private int budget;
    private int cost;
    private int currency;
    private  String much;
    private String rotate;
    private String tax;
    private String subTotal;

    public Reimburse(boolean flag, int budget, int cost, int currency, String much, String rotate, String tax, String subTotal) {
        this.flag = flag;
        this.budget = budget;
        this.cost = cost;
        this.currency = currency;
        this.much = much;
        this.rotate = rotate;
        this.tax = tax;
        this.subTotal = subTotal;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public String getMuch() {
        return much;
    }

    public void setMuch(String much) {
        this.much = much;
    }

    public String getRotate() {
        return rotate;
    }

    public void setRotate(String rotate) {
        this.rotate = rotate;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }
}
