/**
 * 
 */
package org.escoladeltreball.treballpracticprogfunc;

/**
 * @author iaw47941842
 *
 */
public class Station {
	
	private int id;
	private String type;
	private double latitude;
	private double longitude;
	private String streetName;
	private String streetNumber;
	private int altitude;
	private int slots;
	private int bikes;
	private String nearbyStatins;
	private String status;
	private double distance;
	
	/**
	 * @param id
	 * @param type
	 * @param latitude
	 * @param longitude
	 * @param streetName
	 * @param streetNumber
	 * @param altitude
	 * @param slots
	 * @param bikes
	 * @param nearbyStatins
	 * @param status
	 */
	public Station(int id, String type, double latitude, double longitude, String streetName, String streetNumber,
			int altitude, int slots, int bikes, String nearbyStatins, String status) {
		this.id = id;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.altitude = altitude;
		this.slots = slots;
		this.bikes = bikes;
		this.nearbyStatins = nearbyStatins;
		this.status = status;
	}
	
	// *************** Getter & Setters ***************

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the streetNumber
	 */
	public String getStreetNumber() {
		return streetNumber;
	}

	/**
	 * @param streetNumber the streetNumber to set
	 */
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	/**
	 * @return the altitude
	 */
	public int getAltitude() {
		return altitude;
	}

	/**
	 * @param altitude the altitude to set
	 */
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	/**
	 * @return the slots
	 */
	public int getSlots() {
		return slots;
	}

	/**
	 * @param slots the slots to set
	 */
	public void setSlots(int slots) {
		this.slots = slots;
	}

	/**
	 * @return the bikes
	 */
	public int getBikes() {
		return bikes;
	}

	/**
	 * @param bikes the bikes to set
	 */
	public void setBikes(int bikes) {
		this.bikes = bikes;
	}

	/**
	 * @return the nearbyStatins
	 */
	public String getNearbyStatins() {
		return nearbyStatins;
	}

	/**
	 * @param nearbyStatins the nearbyStatins to set
	 */
	public void setNearbyStatins(String nearbyStatins) {
		this.nearbyStatins = nearbyStatins;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * 
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}
	
	/**
	 * 
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	/**
	 * 
	 * @param a Station
	 * @param b Station
	 * @return
	 */
	public static int compareByStreetName(Station a, Station b) {
		return a.getStreetName().compareTo(b.getStreetName());
	}
	
	/**
	 * 
	 * @param a Station
	 * @param b Station
	 * @return 
	 */
	public static int compareByStreetNumber(Station a, Station b) {
		return isInteger(a.getStreetNumber()) - isInteger(b.getStreetNumber());
	}
	
	/**
	 * 
	 * @param s Stirgn
	 * @return num Integer
	 */
	public static int isInteger(String s) {
		int num = 0;
		try {
			num = Integer.parseInt(s);
		} catch (Exception e) {
			num = 0;
		} finally {
			return num;
		}		
	}
	
	/**
	 * 
	 * @param a Station
	 * @param b Station
	 * @return
	 */
	public static int compareByDistance(Station a, Station b) {
		return Double.compare(a.getDistance(), b.getDistance());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"Station [id=%s, type=%s, latitude=%s, longitude=%s, streetName=%s, streetNumber=%s, altitude=%s, slots=%s, bikes=%s, nearbyStatins=%s, status=%s]",
				id, type, latitude, longitude, streetName, streetNumber, altitude, slots, bikes, nearbyStatins, status);
	}
}
