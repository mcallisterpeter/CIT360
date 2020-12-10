public class int_exception {

    private String myInt;

    public int_exception() {
        myInt = "";
    }

    public int_exception(String myInt) {
        this.myInt = myInt;
    }

    public String getMyInt() { return myInt; }

    public boolean setBoolean(String myInt) {
        try {
            /*Integer.parseInt(myInt);*/
            Long.parseLong(myInt);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    public boolean getBoolean() { return setBoolean(getMyInt()); }
}
