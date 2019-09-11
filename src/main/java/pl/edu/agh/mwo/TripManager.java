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
	
	public ArrayList<String> findTrip(String keyword) throws Exception {
		ArrayList<String> tripNames = new ArrayList<String>();
		if(keyword == null || keyword.isEmpty()) {
			for(Map.Entry<String, Trip> tri : tripList.entrySet()) {
				tripNames.add(tri.getValue().getName());
			}
		} else {
		for(Map.Entry<String, Trip> tri : tripList.entrySet()) {
			if(tri.getValue().getDescription().contains(keyword)){
				tripNames.add(tri.getValue().getName());
				} 
			if(tri.getValue().getName().contains(keyword)) {
				tripNames.add(tri.getValue().getName());
				}
			if(tri.getValue().getPhotos() == null) {}
			else {
			for(Photo photo: tri.getValue().getPhotos()) {
				if(photo.getComment().contains(keyword)) {
					tripNames.add(tri.getValue().getName());
					}
				}
			}
			}
		}
		return tripNames;
	}
	
}
