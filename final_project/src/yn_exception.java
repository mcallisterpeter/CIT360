public class yn_exception {

    private String myYn;

    public yn_exception() {
        myYn = "";
    }

    public yn_exception(String myYn) {
        this.myYn = myYn;
    }

    public String getMyYn() { return myYn; }

    public boolean setBoolean(String myYn) {
        if (myYn.equals("y") || myYn.equals("Y") || myYn.equals("n") || myYn.equals("N")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getBoolean() { return setBoolean(getMyYn()); }
}
