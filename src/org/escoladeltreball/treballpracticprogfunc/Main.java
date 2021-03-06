/**
 * 
 */
package org.escoladeltreball.treballpracticprogfunc;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * Per facilitar l'execució del codi he fet servir un switch que trian una opció que
 * executa el codi referent al exercici. Opcio 1 = exercici 1, opcio 2 = exercici 2 ....
 * Només cal executar el codi i a la consola et surt el codi del programa, escrius la opció indicada  
 * i executará el codi. Exemple d'execució:
 * 
 * PRACTICA PROGRAMACIÓ FUNCIONAL
 * *******************************
 * Opció 1: Les estacions que estan per damunt de la latitud 41.38º.
 * Opció 2: Les estacions que tinguin un altitud major de 50m.
 * Opció 3: Les estacions que tinguin més d’una bici, amb la quantitat de bicis que tenen en aquest moment.
 * Opció 4: Les estacions que estiguin tancades, amb l’estat corresponent.
 * Opció 5: Mostra totes les estacions obertes, ordenades pel nom del carrer i el número.
 * Opció 6: Mostra les 3 estacions més properes a la teva casa que estiguin obertes i indica de què tipus són.
 * Opció 7: Mostra l’estació elèctrica més propera a la direcció que hagis indicat al punt anterior i el número de bicis disponibles.
 * Opció 8: Sortir.
 * Escriu una opció (1-8): 1
 * 
 * Exercici 1
 * Number of Stations with latitude higher than 41.38º: 381
 * 
 */

/**
 * @author jordi
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		List<Station> stations = ReadJsonFile.getJsonArray();
		Scanner sc = new Scanner(System.in);
		Station[] stationsAsArray = stations.toArray(new Station[stations.size()]);
		
		int option = 0;
		// La meva posició
		double MYLATITUDE = 41.387816;
		double MYLONGITUDE = 2.125791; 
		
		while (option != 8) {
			System.out.println("PRACTICA PROGRAMACIÓ FUNCIONAL");
			System.out.println("********************************");
			System.out.println("Opció 1: Les estacions que estan per damunt de la latitud 41.38º.");
			System.out.println("Opció 2: Les estacions que tinguin un altitud major de 50m.");
			System.out.println("Opció 3: Les estacions que tinguin més d’una bici, amb la quantitat de bicis que tenen en aquest moment.");
			System.out.println("Opció 4: Les estacions que estiguin tancades, amb l’estat corresponent.");
			System.out.println("Opció 5: Mostra totes les estacions obertes, ordenades pel nom del carrer i el número.");
			System.out.println("Opció 6: Mostra les 3 estacions més properes a la teva casa que estiguin obertes i indica de què tipus són.");
			System.out.println("Opció 7: Mostra l’estació elèctrica més propera a la direcció que hagis indicat al punt anterior i el número de bicis disponibles.");
			System.out.println("Opció 8: Sortir.");
			System.out.print("Escriu una opció (1-8):");
			option = sc.nextInt();
			System.out.println();
			
			switch (option) {
			case 1: option = 1;
				// Ex 1: Les estacions que estan per damunt de la latitud 41.38º
				System.out.println("Resposta exercici 1:");
				int stationsLatitudeHigher = (int) stations.stream().filter(p -> p.getLatitude() > 41.38).count();
				
				System.out.println("Number of Stations with latitude higher than 41.38º: " + stationsLatitudeHigher);
				System.out.println("********************************");
				System.out.println();
				
				break;
			case 2: option = 2;
				// Ex 2: Les estacions que tinguin un altitud major de 50m
				System.out.println("Resposta exercici 2:");
				int stationsAltitudeHigher = (int) stations.stream().filter(p -> p.getAltitude() > 50).count();
				System.out.println("Number of Stations with altitude higher than 50m: " + stationsAltitudeHigher);
				System.out.println("********************************");
				System.out.println();
				break;
			case 3: option = 3;
				System.out.println("Resposta exercici 3:");
				// Ex 3: Les estacions que tinguin més d’una bici, amb la quantitat de bicis que tenen en aquest moment
				stations.stream()
					.filter(p -> p.getBikes() > 1)
					.forEach(station -> System.out.println( 
						"Number of Bike of Stations with more than 1 bike :" + station.getBikes()));
				
				int countStations = (int) stations.stream()
						.filter(p -> p.getBikes() > 1)
						.count();
				System.out.println("Total Number of Bike of Stations with more than 1 bike: " + countStations);
				
				System.out.println("********************************");
				System.out.println();
				break;
			case 4: option = 4;
				System.out.println("Resposta exercici 4:");
				// Ex 4: Les estacions que estiguin tancades, amb l’estat corresponent
				stations.stream()
						.filter(p -> p.getStatus().equals("CLS"))
						.forEach(p -> System.out.println("ID: " + p.getId() + " Status: " + p.getStatus()));
				int closeStations = (int) stations.stream()
						.filter(p -> p.getStatus().equals("CLS"))
						.count();
				System.out.println("Total number of close Stations: " + closeStations);
				System.out.println("********************************");
				System.out.println();				
				break;
			case 5: option = 5;
				System.out.println("Resposta exercici 5:");
				// Ex 5: Mostra totes les estacions obertes, ordenades pel nom del carrer i el número
				Arrays.sort(stationsAsArray, Station::compareByStreetNumber);
				Arrays.sort(stationsAsArray, Station::compareByStreetName);	
						
				System.out.println("Statoins sorted by name and number street: ");
				for (Station station2 : stationsAsArray) {
					System.out.println(station2.getStreetName() + " " + station2.getStreetNumber());
				}
				
				int openStations = (int) stations.stream()
						.filter(p -> p.getStatus().equals("OPN"))
						.count();
				System.out.println("Total number of open Stations: " + openStations);
				System.out.println("********************************");
				System.out.println();
				break;
			case 6: option = 6;
				// Ex 6: Mostra les 3 estacions més properes a la teva casa que estiguin obertes i indica de què tipus són
				System.out.println("Resposta exercici 6:");
				double distance;
				// He agafat com a punt inicial la parada de metro de Mª Cristina que te una latitud de 41.387816 i una longitud de 2.125791
				MYLATITUDE = 41.387816;
				MYLONGITUDE = 2.125791; 
				for (Station station : stations) {
					distance = stationsDAO.getDistance(MYLATITUDE, MYLONGITUDE, station.getLatitude(), station.getLongitude());
					station.setDistance(distance);
				}
				
				Arrays.sort(stationsAsArray, Station::compareByDistance);				
				
				for (int i = 0; i < 3; i++) {					
					String status = stationsAsArray[i].getStatus();
					if (status.equals("OPN")) {
						int nearStationId = stationsAsArray[i].getId();
						String nearNameStreet = stationsAsArray[i].getStreetName();
						String nearStationType = stationsAsArray[i].getType();
						System.out.println(nearNameStreet + " Tipus: " + nearStationType);
					}					
				}
				System.out.println("********************************");
				System.out.println();
				break;
			case 7: option = 7;
				// Ex 7: Mostra l’estació elèctrica més propera a la direcció que hagis indicat al punt anterior (1.5 punts) i el número de bicis disponibles
				System.out.println("Resposta exercici 7:");
				MYLATITUDE = 41.387816;
				MYLONGITUDE = 2.125791;
				List<Station> electricStations = new ArrayList<>();

				for (Station station : stations) {
					if (station.getType().equals("BIKE-ELECTRIC")) {
						distance = stationsDAO.getDistance(MYLATITUDE, MYLONGITUDE, station.getLatitude(), station.getLongitude());
						station.setDistance(distance);
						electricStations.add(station);
					}					
				}
				
				Station[] electricStationsAsArray = electricStations.toArray(new Station[electricStations.size()]);				
				Arrays.sort(electricStationsAsArray, Station::compareByDistance);
				
				System.out.println(electricStationsAsArray[0].getStreetName() + " Bicis disponibles: " + electricStationsAsArray[0].getBikes());
				System.out.println("********************************");
				System.out.println();
				break;
				
			default: option = 8;
			System.out.println("Adeu!");
				break; 
			}			
		}	
	}

}
