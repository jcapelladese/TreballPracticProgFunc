/**
 * 
 */
package org.escoladeltreball.treballpracticprogfunc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

/**
 * @author jordi
 *
 */
public class ReadJsonFile {
	
	/**
	 * Method for read the file of stations
	 * 
	 * @return jsonArray ArrayList with the stations
	 * @throws FileNotFoundException File not found
	 */
	public static List<Station> getJsonArray() throws FileNotFoundException {
		
		ArrayList<Station> stations = new ArrayList<Station>();		
		InputStreamReader in = new InputStreamReader(new FileInputStream("stations.json"));
		JsonReader jsonReader = new JsonReader(in);
		
		Gson gson = new Gson();
		
		JsonParser jsonParser = new JsonParser();
		JsonElement element = jsonParser.parse(jsonReader);
		JsonObject jsonObject = element.getAsJsonObject();
		JsonArray jsonArray = jsonObject.get("stations").getAsJsonArray();
		
		for (int i = 0; i < jsonArray.getAsJsonArray().size(); i++) {
			JsonObject aux = jsonArray.getAsJsonArray().get(i).getAsJsonObject();
			int id = aux.get("id").getAsInt();
			String type = aux.get("type").getAsString();
			double latitude = aux.get("latitude").getAsDouble();
			double longitude = aux.get("longitude").getAsDouble();
			String streetName = aux.get("streetName").getAsString();
			String streetNumber= aux.get("streetNumber").getAsString();
			int altitude = aux.get("altitude").getAsInt();
			int slots = aux.get("slots").getAsInt();
			int bikes = aux.get("bikes").getAsInt();
			String nearbyStations = aux.get("nearbyStations").getAsString();
			String status = aux.get("status").getAsString();
			
			Station station = new Station(id, type, latitude, longitude, streetName, streetNumber, altitude, slots, bikes, nearbyStations, status);
			stations.add(station);
		}
		
		return stations;
	}

}
