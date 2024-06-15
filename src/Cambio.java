import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Cambio {
    public double convertir(String fromCode, String toCode, double amount) throws IOException {
        String GET_URL = "https://v6.exchangerate-api.com/v6/d5717bf4db2e54e2c94dc176/pair/" + fromCode + "/" + toCode + "/" + amount;
        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine())!= null) {
                    response.append(inputLine);
                }

                JSONObject obj = new JSONObject(response.toString());
                Double exchangeRate = obj.getDouble("conversion_rate");
                System.out.println("Exchange Rate: " + exchangeRate);
                System.out.println(amount + " " + fromCode + " = " + (amount * exchangeRate) + " " + toCode);
                return amount * exchangeRate;
            }
        } else {
            System.out.println("El cambio de divisa no existe");
            return 0;
        }
    }
}