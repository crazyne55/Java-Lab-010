/**
 * @author Trevor Hartman
 *
 * @author crazyne55
 */
public class CurrentConditions implements Display {
    WeatherStation ws;
    float temperature;
    float humidity;

    public CurrentConditions(WeatherStation ws){
        this.ws = ws;
        this.temperature = ws.getTemperature();
        this.humidity = ws.getHumidity();
    }

    @Override
    public void update() {
        temperature = ws.getTemperature();
        humidity = ws.getHumidity();
        display();
    }
    @Override
    public void display() {
        System.out.printf("It is currently %s°F with a humidity of %s%n", temperature, humidity);
    }
}
