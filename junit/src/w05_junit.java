public class w05_junit {
    private String model;
    private String make;
    private int miles;

    public w05_junit(String model, String make, int miles) {
        this.model = model;
        this.make = make;
        this.miles = miles;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }
}
