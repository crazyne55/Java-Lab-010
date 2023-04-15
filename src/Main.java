import java.io.IOException;
import java.util.Scanner;

/**
 * @author Trevor Hartman
 *
 * @author crazyne55
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        WeatherStation ws = new WeatherStation();

        ws.registerDisplay(new CurrentConditions(ws));
        ws.registerDisplay(new ForecastDisplay(ws));
        ws.registerDisplay(new StatisticsDisplay(ws));

        while(true){
            ws.measure();
            //ws.notifyDisplays(); //realized this was redundant since measure calls notifyDisplays anyways. -crazyne55
            System.out.println("\nMeasure again? (y/N)");
            String res = s.nextLine();
            if (!res.toLowerCase().equals("y")){ break; }
        }
    }
}
