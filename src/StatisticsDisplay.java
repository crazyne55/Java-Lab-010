/**
 * @author Trevor Hartman
 *
 * @author crazyne55
 */
public class StatisticsDisplay implements Display {
    WeatherStation ws;
    float temperatureMin;
    float temperatureMax;
    float temperatureTotal;
    int numReadings;

    public StatisticsDisplay(WeatherStation ws){
        this.ws = ws;
        this.temperatureMin = Float.MAX_VALUE;
        this.temperatureMax = Float.MIN_VALUE;
        this.temperatureTotal = ws.getTemperature();
        this.numReadings = 0;
    }

    @Override
    public void update() {
        numReadings++;
        float tmp = ws.getTemperature();
        if(temperatureMax < tmp) {temperatureMax = tmp;}
        if(temperatureMin > tmp) {temperatureMin = tmp;}
        temperatureTotal += tmp; // I am confused why this exists, from what it looks like everyone else has been adding the current temp to the total so whatever ㄟ( ▔, ▔ )ㄏ -crazyne55
        display();
    }
    @Override
    public void display() {
        // nevermind I found out why, it is to calculate the average over the samples. -crazyne55
        System.out.printf("Out of %s sample(s), here are some statistics of the temperature.%nMax: %s°F%nMin: %s°F%nAve: %s°F%n",numReadings,temperatureMax,temperatureMin,Math.round(temperatureTotal/(numReadings*1.0)));
        //Out of %s samples, here are some statistics of the temperature.%n
        //Max: %s°F%n
        //Min: %s°F%n
        //Ave: %s°F%n


        // I only did the Math.round(temperatureTotal/(numReadings*1.0)) because I wanted to avoid integer division while still being accurate even though it probably would've been the same output anyways. -crazyne55
    }
}
