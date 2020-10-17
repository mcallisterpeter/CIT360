import static org.junit.jupiter.api.Assertions.*;

class w05_junitTest {

    @org.junit.jupiter.api.Test
    void getModel() {
        w05_junit myTest = new w05_junit("Subaru", "Legacy", 85406);
        //See if test will fail with following:
        //assertEquals("Honda", myTest.getModel());
        assertEquals("Subaru", myTest.getModel());
    }

    @org.junit.jupiter.api.Test
    void setmodel() {
        w05_junit myTest = new w05_junit("Subaru", "Legacy", 85406);
        myTest.setModel("Toyota");
        assertEquals("Toyota", myTest.getModel());
    }

    @org.junit.jupiter.api.Test
    void getMake() {
        w05_junit myTest = new w05_junit("Subaru", "Legacy", 85406);
        assertEquals("Legacy", myTest.getMake());
    }

    @org.junit.jupiter.api.Test
    void setMake() {
        w05_junit myTest = new w05_junit("Subaru", "Legacy", 85406);
        myTest.setMake("Supra");
        assertEquals("Supra", myTest.getMake());
    }

    @org.junit.jupiter.api.Test
    void getMiles() {
        w05_junit myTest = new w05_junit("Subaru", "Legacy", 85406);
        assertEquals(85406, myTest.getMiles());
    }

    @org.junit.jupiter.api.Test
    void setMiles() {
        w05_junit myTest = new w05_junit("Subaru", "Legacy", 85406);
        myTest.setMiles(32540);
        assertEquals(32540, myTest.getMiles());
    }
}