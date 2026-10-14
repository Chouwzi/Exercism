class NeedForSpeed {
    private int speed;
    private int distanceDriven;
    private int batteryDrain;
    private int batteryRemaining;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        this.distanceDriven = 0;
        this.batteryRemaining = 100; // percent
    }

    public boolean batteryDrained() {
        if (batteryRemaining <= 0 || batteryRemaining < batteryDrain) {
            return true;
        }
        return false;
    }

    public int distanceDriven() {
        return this.distanceDriven;
    }

    public void drive() {
        if (batteryDrained()) {
            return;
        }
        distanceDriven += speed;
        batteryRemaining -= batteryDrain;
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }

    public int getSpeed() {
        return speed;
    }

    public int getBatteryDrain() {
        return batteryDrain;
    }
}

class RaceTrack {
    private int distance;
    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        int driveCount = (int) Math.ceil( (double) distance / car.getSpeed());
        for (int i = 0; i < driveCount; i++) {
            if (car.batteryDrained() == true) { return false; }
            car.drive();
        }
        return true;
    }
}
