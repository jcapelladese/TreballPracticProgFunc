/**
 * 
 */
package org.escoladeltreball.treballpracticprogfunc;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * @author jordi
 *
 */
public class stationsDAO {
	
	/**
	 * 
	 * @param stations
	 * @param lalitude
	 * @return j Total number of stations with higher latitude 
	 */
	public static int countStationsHigherLatitude(List<Station> stations, double latitude) {
		
		int j = 0;
		
		for (Station station : stations) {
			double latitudeStation = station.getLatitude();
			if ( latitudeStation > 41.38) {
				j++;
			}
		}
		return j;
	}
	
	public static int countStationsHigherAltitude(List<Station> stations, int altitude) {
		
		int j= 0;
		
		for (Station station : stations) {
			double altitudeStation = station.getAltitude();
			if ( altitudeStation > 50) {
				j++;
			}
		}
		return j;
	}
	
	public static double getDistance(double lat1, double long1, double lat2, double long2) {
//		int R = 6371;
//		double latDistance = toRad(lat2 - lat1);
//		double longDistance = toRad(long2 - long1);
//		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + 
//				 Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) * 
//				 Math.sin(longDistance / 2) * Math.sin(longDistance / 2);
//		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
//		double distance = R * c;
//		
//		return distance;
		double radioTierra = 6371;//en kilómetros  
        double dLat = Math.toRadians(lat2 - lat1);  
        double dLng = Math.toRadians(long2 - long1);  
        double sindLat = Math.sin(dLat / 2);  
        double sindLng = Math.sin(dLng / 2);  
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));  
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
        double distancia = radioTierra * va2;  
   
        return distancia; 
	}
	

	
	
	

}
