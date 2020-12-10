public class double_exception {

    private String myDouble;

    public double_exception() {
        myDouble = "";
    }

    public double_exception(String myDouble) {
        this.myDouble = myDouble;
    }

    public String getMyDouble() { return myDouble; }

    public boolean setBoolean(String myDouble) {
        try {
            Double.parseDouble(myDouble);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    public boolean getBoolean() { return setBoolean(getMyDouble()); }
}
