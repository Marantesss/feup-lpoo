package com.aor.refactoring.example6;

public class Location {

    private String locationLatitude;
    private String locationLongitude;
    private String locationName;

    public Location(String locationLatitude, String locationLongitude, String locationName) {
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.locationName = locationName;
    }

    @Override
    public String toString() {
        return this.locationLatitude + "," + this.locationLongitude + " (" + this.locationName + ")";
    }

    // ---- getters
    public String getLocationLatitude() {
        return locationLatitude;
    }

    public String getLocationLongitude() {
        return locationLongitude;
    }

    public String getLocationName() {
        return locationName;
    }

    // ---- setters
    public void setLocationLatitude(String locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public void setLocationLongitude(String locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
