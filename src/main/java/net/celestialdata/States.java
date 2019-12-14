package net.celestialdata;

public class States {
    private static boolean playStructureState = false;
    private static boolean lazyRiverState = false;
    private static boolean riverFountainsState = false;
    private static boolean centerJetsState = false;
    private static boolean yellowSlideState = false;
    private static boolean blueSlideState = false;
    private static boolean emergencyStopState = false;

    public static boolean isPlayStructureOn() {
        return playStructureState;
    }

    public static boolean isLazyRiverOn() {
        return lazyRiverState;
    }

    public static boolean isRiverFountainsOn() {
        return riverFountainsState;
    }

    public static boolean isCenterJetsOn() {
        return centerJetsState;
    }

    public static boolean isYellowSlideOn() {
        return yellowSlideState;
    }

    public static boolean isBlueSlideOn() {
        return blueSlideState;
    }

    public static boolean isEmergencyStopOn() {
        return emergencyStopState;
    }
    
    public static void togglePlayStructure() {
        playStructureState = !playStructureState;
        //RelayControl.setPlayStructureState(playStructureState);
    }

    public static void toggleLazyRiver() {
        lazyRiverState = !lazyRiverState;
        //RelayControl.setLazyRiverState(lazyRiverState);
    }

    public static void toggleRiverFountains() {
        riverFountainsState = !riverFountainsState;
        //RelayControl.setRiverFountainsState(riverFountainsState);
    }

    public static void toggleCenterJets() {
        centerJetsState = !centerJetsState;
        //RelayControl.setCenterJetsState(centerJetsState);
    }

    public static void toggleYellowSlide() {
        yellowSlideState = !yellowSlideState;
        //RelayControl.setYellowSlideState(yellowSlideState);
    }

    public static void toggleBlueSlide() {
        blueSlideState = !blueSlideState;
        //RelayControl.setBlueSlideState(blueSlideState);
    }

    public static void toggleEmergencyStop() {
        emergencyStopState = !emergencyStopState;

        if (States.emergencyStopState) {
            //RelayControl.setPlayStructureState(false);
            //RelayControl.setLazyRiverState(false);
            //RelayControl.setRiverFountainsState(false);
            //RelayControl.setCenterJetsState(false);
            //RelayControl.setYellowSlideState(false);
            //RelayControl.setBlueSlideState(false);
        } else {
            //RelayControl.setPlayStructureState(playStructureState);
            //RelayControl.setLazyRiverState(lazyRiverState);
            //RelayControl.setRiverFountainsState(riverFountainsState);
            //RelayControl.setCenterJetsState(centerJetsState);
            //RelayControl.setYellowSlideState(yellowSlideState);
            //RelayControl.setBlueSlideState(blueSlideState);
        }
    }
}
