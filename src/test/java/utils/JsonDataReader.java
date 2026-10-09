package utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataReader {

    public static Object[][] getLoginData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("src/test/resources/testdata/loginData.json");

        List<Map<String, String>> data = mapper.readValue(
                file,
                new TypeReference<List<Map<String, String>>>() {}
        );

        Object[][] result = new Object[data.size()][3];

        for (int i = 0; i < data.size(); i++) {
            result[i][0] = data.get(i).get("username");
            result[i][1] = data.get(i).get("password");
            result[i][2] = data.get(i).get("expectedResult");
        }

        return result;
    }
}
