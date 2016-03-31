package com.company.app.converter.coordinate;

public class DDCoordinateDTO {
  double latitude;

  double longitude;
  
  public DDCoordinateDTO(double latitude, double longitude) {
    super();
    this.latitude=latitude;
    this.longitude=longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

}
