package clinic.model;

import java.util.ArrayList;

public class Arrangement {
    boolean SunAM;
    boolean SunPM;
    boolean MonAM;
    boolean MonPM;
    boolean TuesAM;
    boolean TuesPM;
    boolean WedAM;
    boolean WedPM;
    boolean ThurAM;
    boolean ThurPM;
    boolean FriAM;
    boolean FriPM;
    boolean SatAM;
    boolean SatPM;

    ArrayList<Arrangement> arrangements = new ArrayList<>();

    public boolean isSunAM() {
        return SunAM;
    }

    public void setSunAM(boolean sunAM) {
        SunAM = sunAM;
    }

    public boolean isSunPM() {
        return SunPM;
    }

    public void setSunPM(boolean sunPM) {
        SunPM = sunPM;
    }

    public boolean isMonAM() {
        return MonAM;
    }

    public void setMonAM(boolean monAM) {
        MonAM = monAM;
    }

    public boolean isMonPM() {
        return MonPM;
    }

    public void setMonPM(boolean monPM) {
        MonPM = monPM;
    }

    public boolean isTuesAM() {
        return TuesAM;
    }

    public void setTuesAM(boolean tuesAM) {
        TuesAM = tuesAM;
    }

    public boolean isTuesPM() {
        return TuesPM;
    }

    public void setTuesPM(boolean tuesPM) {
        TuesPM = tuesPM;
    }

    public boolean isWedAM() {
        return WedAM;
    }

    public void setWedAM(boolean wedAM) {
        WedAM = wedAM;
    }

    public boolean isWedPM() {
        return WedPM;
    }

    public void setWedPM(boolean wedPM) {
        WedPM = wedPM;
    }

    public boolean isThurAM() {
        return ThurAM;
    }

    public void setThurAM(boolean thurAM) {
        ThurAM = thurAM;
    }

    public boolean isThurPM() {
        return ThurPM;
    }

    public void setThurPM(boolean thurPM) {
        ThurPM = thurPM;
    }

    public boolean isFriAM() {
        return FriAM;
    }

    public void setFriAM(boolean friAM) {
        FriAM = friAM;
    }

    public boolean isFriPM() {
        return FriPM;
    }

    public void setFriPM(boolean friPM) {
        FriPM = friPM;
    }

    public boolean isSatAM() {
        return SatAM;
    }

    public void setSatAM(boolean satAM) {
        SatAM = satAM;
    }

    public boolean isSatPM() {
        return SatPM;
    }

    public void setSatPM(boolean satPM) {
        SatPM = satPM;
    }

    public Arrangement(boolean sunAM, boolean sunPM, boolean monAM, boolean monPM, boolean tuesAM, boolean tuesPM, boolean wedAM, boolean wedPM, boolean thurAM, boolean thurPM, boolean friAM, boolean friPM, boolean satAM, boolean satPM) {
        SunAM = sunAM;
        SunPM = sunPM;
        MonAM = monAM;
        MonPM = monPM;
        TuesAM = tuesAM;
        TuesPM = tuesPM;
        WedAM = wedAM;
        WedPM = wedPM;
        ThurAM = thurAM;
        ThurPM = thurPM;
        FriAM = friAM;
        FriPM = friPM;
        SatAM = satAM;
        SatPM = satPM;
    }
}
