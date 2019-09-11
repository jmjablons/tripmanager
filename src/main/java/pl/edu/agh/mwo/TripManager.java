package pl.edu.agh.mwo;
import java.util.*;
import java.util.Map.Entry;

public class TripManager {
	private HashMap<String,Trip> tripList;
	
	public TripManager() {
		tripList = new HashMap<String,Trip>();
	}
	
	public void add(Trip trip) throws TripAlreadyExistsException {
		if (tripList.get(trip.getName()) != null) {
			throw new TripAlreadyExistsException();
		}
		else {
			tripList.put(trip.getName(),trip);
		}
	}
	
	public HashMap<String,Trip> getTrips() {
		return tripList;
	}

	public void remove(String name) {
		tripList.remove(name);
	}
	
	public String findTrip(String keyword) {
		String tripName = new String();
		for(Map.Entry<String, Trip> tri : tripList.entrySet()) {
			if(tri.getValue().getDescription().contains(keyword)){
				tripName = tri.getValue().getName();
				}
			}
		return tripName;
	}
	
}
