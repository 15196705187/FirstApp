package trypost.dafeng.com.trypost.entity;

import java.io.Serializable;

/**
 * Created by asus on 2017/3/26.
 */
public class Mine implements Serializable{
    private String name;
    private String time;
    private String thing;
    private String leader;
    private double price;
    private String nextStep;
    private String type;

    public Mine(String name, String time, String thing, String leader, double price, String nextStep, String type) {
        this.name = name;
        this.time = time;
        this.thing = thing;
        this.leader = leader;
        this.price = price;
        this.nextStep = nextStep;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getNextStep() {
        return nextStep;
    }

    public void setNextStep(String nextStep) {
        this.nextStep = nextStep;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
