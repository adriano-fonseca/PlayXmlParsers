package com.company.app.converter.coordinate;

import java.util.logging.Logger;

public class CordinateConverter {/*
link converter - http://www.gps-coordinates.net/gps-coordinates-converter
Earth is divided by the equator     (0° latitude)
And for Prime meridian (Greenwich). (0° longitude

(Lat, Lon) = (40.4461111 , -40.44611083333333)   =>  (40° 26' 46" N  , 40° 26' 45.998 W)

DD (decimal degrees)  -> 40.4461111
DMS (Degree, minutes, seconds, direction)  -> 40° 26' 46" N 

========================
= To convert DMS to DD =
========================

DD = degrees + (minutes/60) + (seconds/3600)

========================
= To convert DD to DMS =
========================
61.44, -61,44 

lat dd=61
lat mm.gg=60*0.44=26.4
lat ss=60*gg=60*0,4=24

lat = 61° 26,4' 24"

Remember, locations in the Southern Hemisphere (S) are at negative latitudes,
and locations in the Western Hemisphere (W) are at negative longitudes. 
Therefore, locations in the Northern Hemisphere (N) are at positive latitudes,
and locations in the Eastern Hemisphere (E) are at positive longitudes. 


->   40°26.767′ N (Positive)
-> - 40°26.767′ S (Negative)
->   40°26.767′ E (Positive)  
->   40°26.767′ W (Negative)  


*/

  private static final Logger LOGGER = Logger.getLogger("CoordinateConverterLog");

  public static void main(String[] args) {
    //    convertDDtoDMS();

  }

  public static DDCoordinateDTO parseDDCoordinateToDDCoordinateDTO(String coordinate) {
    coordinate = "-45.4566 65.4566";
    String[] ddCoordinateArray = coordinate.split(" ");
    double latitude = Double.parseDouble(ddCoordinateArray[0]);
    double longitude = Double.parseDouble(ddCoordinateArray[1]);
    return new DDCoordinateDTO(latitude, longitude);

  }

  public static DMSCoordinateDTO parseDMSCoordinateToDMSCoordinateDTO(String coordinate) {
    coordinate = "40° 26\' 46\" W";
    int length = coordinate.length();
    String[] ddCoordinateArray = coordinate.split(" ");
    int indiceDegree = ddCoordinateArray[0].indexOf("°");
    char direction = coordinate.charAt(length - 1);

    int degrees = Integer.parseInt(ddCoordinateArray[0].substring(0, indiceDegree));
    int minutes = Integer.parseInt(ddCoordinateArray[1].substring(0, 2));
    int seconds = Integer.parseInt(ddCoordinateArray[2].substring(0, 2));
    return new DMSCoordinateDTO(degrees, minutes, seconds, direction);
  }

  public static double convertDMStoDD(DMSCoordinateDTO dmsCoordinateDTO) {
    double dd = 0;
    boolean negativeCoordinate = isNegative(dmsCoordinateDTO.getDirection());
    dd = dmsCoordinateDTO.getDegrees() + (dmsCoordinateDTO.getMinutes() / 60) + (dmsCoordinateDTO.getSeconds() / 3600);
    dd = negativeCoordinate ? (dd * -1D) : dd;
    System.out.println("Coordinate: " + dd);
    return dd;
  }

  public static String convertDDtoDMS(String lat, String lon) {
    //  DMS of 61.44 
    //  
    //  lat dd=61
    //  lat mm.gg=60*0.44=26.4
    //  lat ss=60*gg=60*0,4=24
    String ddCoordinate = "61.44";
    String[] ddCoordinateArray = ddCoordinate.split(".");

    double coordinate = Double.parseDouble(ddCoordinate);
    double dd = Double.parseDouble(ddCoordinateArray[0]);
    double mmgg = 60 * (coordinate - dd);

    //double n = 40.4461111;
    //double x = n - (int) n;
    //System.out.println(x);
    return "";
  }

  private static boolean isNegative(char orientation) {
    if (orientation == 'N' || orientation == 'E') {
      return false;
    } else if (orientation == 'S' || orientation == 'W') {
      return true;
    } else {
      throw new BadCoordinateException("Format of Coordinate not recognized or not supported.");
    }
  }

}
