package net.celestialdata;

import com.pi4j.io.gpio.*;

/**
 * This is responsible for toggling the relays on
 * the controller. This is only used if the system configuration
 * defines it as a controller.
 *
 * @author Brandan Schmitz
 */
class RelayControl {

    private final static GpioController gpio = GpioFactory.getInstance();
    private static GpioPinDigitalOutput bSlideRelay = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "Blue Slide", PinState.HIGH);
    private static GpioPinDigitalOutput ySlideRelay = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "Yellow Slide", PinState.HIGH);
    private static GpioPinDigitalOutput lRiverRelay = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "Lazy River", PinState.HIGH);
    private static GpioPinDigitalOutput pStructureRelay = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Play Structure", PinState.HIGH);
    private static GpioPinDigitalOutput rFountainsRelay = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "River Fountains", PinState.HIGH);
    private static GpioPinDigitalOutput cJetsRelay = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "Center Jets", PinState.HIGH);

    /**
     * Configure the relays to turn off if the program exits.
     */
    static void initRelayControl() {
        bSlideRelay.setShutdownOptions(true, PinState.HIGH);
        ySlideRelay.setShutdownOptions(true, PinState.HIGH);
        lRiverRelay.setShutdownOptions(true, PinState.HIGH);
        pStructureRelay.setShutdownOptions(true, PinState.HIGH);
        rFountainsRelay.setShutdownOptions(true, PinState.HIGH);
        cJetsRelay.setShutdownOptions(true, PinState.HIGH);
    }

    /**
     * Cleanup the GPIO pins and shut it all down.
     */
    static void cleanup() {
        gpio.shutdown();
    }

    /**
     * Toggle the relay for the Blue Slide.
     *
     * @param blueSlideState The state to set the slide to.
     */
    static void setBlueSlideState(boolean blueSlideState) {
        if (blueSlideState) {
            bSlideRelay.low();
        } else {
            bSlideRelay.high();
        }
    }

    /**
     * Toggle the relay for the Yellow Slide.
     *
     * @param yellowSlideState The state to set the slide to.
     */
    static void setYellowSlideState(boolean yellowSlideState) {
        if (yellowSlideState) {
            ySlideRelay.low();
        } else {
            ySlideRelay.high();
        }
    }

    /**
     * Toggle the relay for the Lazy River.
     *
     * @param lazyRiverState The state to set the river to.
     */
    static void setLazyRiverState(boolean lazyRiverState) {
        if (lazyRiverState) {
            lRiverRelay.low();
        } else {
            lRiverRelay.high();
        }
    }

    /**
     * Toggle the relay for the Play Structure.
     *
     * @param structureState The state to set the structure to.
     */
    static void setPlayStructureState(boolean structureState) {
        if (structureState) {
            pStructureRelay.low();
        } else {
            pStructureRelay.high();
        }
    }

    /**
     * Toggle the relay for the River Fountains.
     *
     * @param riverFountainsState The state to set the fountains to.
     */
    static void setRiverFountainsState(boolean riverFountainsState) {
        if (riverFountainsState) {
            rFountainsRelay.low();
        } else {
            rFountainsRelay.high();
        }
    }

    /**
     * Toggle the relay for the Center Jets.
     *
     * @param centerJetsState The state to set the jets to.
     */
    static void setCenterJetsState(boolean centerJetsState) {
        if (centerJetsState) {
            cJetsRelay.low();
        } else {
            cJetsRelay.high();
        }
    }
}
