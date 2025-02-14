package TUF;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class NSECorporateDisclosureFetcher {
    public static void main(String[] args) {
        try {
            // Define the URL
            String urlString = "https://www.google.com";
            URL url = new URL(urlString);

            // Create HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("Accept", "application/json");

            // Get the response
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parse the JSON response manually
                String jsonResponse = response.toString();

                // Remove the square brackets from the JSON array
                jsonResponse = jsonResponse.substring(1, jsonResponse.length() - 1);

                // Split individual JSON objects
                String[] disclosures = jsonResponse.split("},");

                for (String disclosure : disclosures) {
                    // Ensure the last object is properly closed
                    if (!disclosure.endsWith("}")) {
                        disclosure += "}";
                    }

                    // Extract fields using string manipulation
                    String symbol = extractValue(disclosure, "symbol");
                    String description = extractValue(disclosure, "desc");
                    String date = extractValue(disclosure, "an_dt");
                    String attachmentFile = extractValue(disclosure, "attchmntFile");
                    String attachmentText = extractValue(disclosure, "attchmntText");

                    // Print the parsed response
                    System.out.println("Symbol: " + symbol);
                    System.out.println("Description: " + description);
                    System.out.println("Date: " + date);
                    System.out.println("Attachment File: " + attachmentFile);
                    System.out.println("Attachment Text: " + attachmentText);
                    System.out.println("-------------------------------------");
                }
            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to extract values from JSON-like string
    private static String extractValue(String json, String key) {
        try {
            String searchKey = "\"" + key + "\":";
            int startIndex = json.indexOf(searchKey);
            if (startIndex == -1) return "";

            startIndex += searchKey.length();

            char startChar = json.charAt(startIndex);
            if (startChar == '"') {
                // Extract string value
                int endIndex = json.indexOf('"', startIndex + 1);
                return json.substring(startIndex + 1, endIndex);
            } else {
                // Extract non-string value (e.g., numbers or null)
                int endIndex = json.indexOf(',', startIndex);
                if (endIndex == -1) {
                    endIndex = json.indexOf('}', startIndex);
                }
                return json.substring(startIndex, endIndex).trim();
            }
        } catch (Exception e) {
            return "";
        }
    }
}
