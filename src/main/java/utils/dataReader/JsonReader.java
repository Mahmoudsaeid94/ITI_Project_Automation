package utils.dataReader;
import org.json.simple.parser.ParseException;
import utils.logs.LogsManager;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonReader {
        private final String TEST_DATA_PATH = "src/test/resources/test-data/";
        String jsonReader;
        String jsonFileName;

        public JsonReader(String jsonFileName) {
            this.jsonFileName = jsonFileName;
            try {
                JSONObject data = (JSONObject) new JSONParser().parse(new FileReader(TEST_DATA_PATH + jsonFileName + ".json"));
                jsonReader = data.toJSONString();
            } catch (Exception e) {
                LogsManager.error("Error reading json file:", jsonFileName, e.getMessage());
                jsonReader = "{}"; // Initialize to an empty JSON object to avoid null pointer exceptions
            }
        }

        //valid.username
        public String getJsonData(String jsonPath) {
            try {
                return JsonPath.read(jsonReader, jsonPath);
            } catch (Exception e) {
                LogsManager.error("Error reading json file for path:", jsonPath, e.getMessage());
                return "";
            }
    
        }

        /*public void setJsonData(String jsonPath, String value) {
            try (FileReader fileReader = new FileReader(TEST_DATA_PATH + jsonFileName + ".json")) {
                // Parse the JSON file
                JSONObject data = (JSONObject) new JSONParser().parse(fileReader);
                data.put(jsonPath, value);
                // Set the new value at the specified path

                // Update the internal state
                jsonReader = data.toJSONString();

                // Write the modified JSON back to the file
                try (FileWriter fileWriter = new FileWriter(TEST_DATA_PATH + jsonFileName + ".json")) {
                    fileWriter.write(jsonReader);
                    fileWriter.flush();
                }

            } catch (IOException e) {
                LogsManager.error("Error accessing json file:", jsonFileName, e.getMessage());
            } catch (ParseException e) {
                LogsManager.error("Error parsing json file:", jsonFileName, e.getMessage());
            } catch (Exception e) {
                LogsManager.error("Error setting json file for path:", jsonPath, e.getMessage());
            }
        }
        */
        
    }
    
