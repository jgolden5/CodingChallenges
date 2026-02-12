package Codewars;

public class TrafficJam {
    public static String trafficJam(final String mainRoad, final String[] sideStreets) {
        String trafficPath = "";
        String[] sideStreetCarsQueue = new String[sideStreets.length];
        int sideStreetIndex = 0;
        int sideStreetCarIndex = 0;
        String sideStreetPositionQueue = ""; //tracks positions of sideStreets
        for(int mainRoadIndex = 0; mainRoadIndex < mainRoad.length(); mainRoadIndex++) {
            //A) add mainRoad part to trafficPath
            trafficPath += mainRoad.charAt(mainRoadIndex);
            //B) end loop if added char == 'X'
            if(mainRoad.charAt(mainRoadIndex) == 'X') {
                break;
            }
            //C) add to sideStreet queues (sideStreetCars & sideStreetPositionQueue)
            if(sideStreets.length > mainRoadIndex && sideStreets[mainRoadIndex] != "") {
                sideStreetCarsQueue[sideStreetIndex] = sideStreets[mainRoadIndex];
                sideStreetPositionQueue += String.valueOf(mainRoadIndex);
            }
            //D) add next sideStreetCar to trafficPath
            if(sideStreetCarsQueue[sideStreetIndex] != null && Character.getNumericValue(sideStreetPositionQueue.charAt(sideStreetIndex)) <= mainRoadIndex) {
                if(sideStreetCarIndex < sideStreetCarsQueue[sideStreetIndex].length()) {
                    trafficPath += sideStreetCarsQueue[sideStreetIndex].charAt(sideStreetCarIndex);
                    sideStreetCarIndex++;
                } else {
                    if(sideStreetPositionQueue.charAt(sideStreetIndex) <= mainRoadIndex) {
                        trafficPath += sideStreetCarsQueue[sideStreetIndex].charAt(sideStreetCarIndex);
                    }
                }
                if(sideStreetCarIndex >= sideStreetCarsQueue[sideStreetIndex].length() - 1) {
                    sideStreetIndex++;
                    sideStreetCarIndex = 0;
                }
            }
        }
//        Util.display(mainRoad, sideStreets);
        //E) return trafficPath
        return trafficPath;
    }
}