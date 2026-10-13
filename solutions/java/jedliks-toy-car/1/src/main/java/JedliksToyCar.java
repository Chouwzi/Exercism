public class JedliksToyCar {
    private int drivenMeters = 0; // m
    private int batteryRemaining = 100; // Percent
    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return "Driven " + drivenMeters + " meters";
    }

    public String batteryDisplay() {
        if (batteryRemaining <= 0) {
             return "Battery empty";   
        }
        return "Battery at " + batteryRemaining + "%";
    }

    public void drive() {

        drivenMeters += 20;
        if (drivenMeters >= 2000) {
            drivenMeters = 2000;
        }
        batteryRemaining -= 1;
    }
}
