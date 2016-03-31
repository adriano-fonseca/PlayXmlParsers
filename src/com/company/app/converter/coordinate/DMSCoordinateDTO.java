package com.company.app.converter.coordinate;

public class DMSCoordinateDTO {
  
  int degrees;
  int minutes;
  int seconds;
  char direction;
  
  public DMSCoordinateDTO(int degree, int minutes, int seconds, char direction){
    super();
    this.degrees=degree;
    this.minutes=minutes;
    this.seconds=seconds;
    this.direction=direction;
  }

  public int getMinutes() {
    return minutes;
  }

  public void setMinutes(int minutes) {
    this.minutes = minutes;
  }

  public int getSeconds() {
    return seconds;
  }

  public void setSeconds(int seconds) {
    this.seconds = seconds;
  }

  public char getDirection() {
    return direction;
  }

  public void setDirection(char direction) {
    this.direction = direction;
  }

  public int getDegrees() {
    return degrees;
  }

  public void setDegrees(int degrees) {
    this.degrees = degrees;
  }
}
