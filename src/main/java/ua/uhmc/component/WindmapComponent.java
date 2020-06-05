package ua.uhmc.component;

import lombok.Data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class WindmapComponent {

    private List<String> areas = new ArrayList<>(Arrays.asList("Area H (NorthAtl QWA*)", "Area G (EurAs QWC*)", "Area EUR (Eur QWD*)", "Area C (EurAfr QWR*)", ""));
    private List<String> grib2_dates = new ArrayList<>(Arrays.asList("00 UTC", "06 UTC", "12 UTC", "18 UTC", ""));
    private List<String> levels = new ArrayList<>(Arrays.asList("100hPa FL530", "125hPa FL480", "150hPa FL450", "175hPa FL410", "200hPa FL390", "225hPa FL360", "250hPa FL340", "275hPa FL320", "300hPa FL300", "350hPa FL270", "400hPa FL240", "450hPa FL210", "500hPa FL180", "600hPa FL140", "700hPa FL100", "750hPa FL080", "850hPa FL050", ""));
    private List<String> validities = new ArrayList<>(Arrays.asList("C (+6H) timeUTC", "D (+9H) timeUTC", "E (+12H) timeUTC", "F (+15H) timeUTC", "G (+18H) timeUTC", "H (+21H) timeUTC", "I (+24H) timeUTC", ""));

    private String windmapImageFilename;
    private Integer validityIndex;
    private Integer levelIndex;
    private byte [] currentWindmapImage;

    public WindmapComponent(){}

    public WindmapComponent(String windmapImageFilename, Integer validityIndex, Integer levelIndex, byte[] currentWindmapImage) {
        this.windmapImageFilename = windmapImageFilename;
        this.validityIndex = validityIndex;
        this.levelIndex = levelIndex;
        this.currentWindmapImage = currentWindmapImage;
    }

    public String getWindmapImageFilename() {
        return windmapImageFilename;
    }

    public void setWindmapImageFilename(String windmapImageFilename) {
        this.windmapImageFilename = windmapImageFilename;
    }

    public Integer getValidityIndex() {
        return validityIndex;
    }

    public void setValidityIndex(Integer validityIndex) {
        this.validityIndex = validityIndex;
    }

    public Integer getLevelIndex() {
        return levelIndex;
    }

    public void setLevelIndex(Integer levelIndex) {
        this.levelIndex = levelIndex;
    }

    public byte[] getCurrentWindmapImage() {
        return currentWindmapImage;
    }

    public void setCurrentWindmapImage(byte[] currentWindmapImage) {
        this.currentWindmapImage = currentWindmapImage;
    }

    public List<String> getAreas() {
        return areas;
    }

    public void setAreas(List<String> areas) {
        this.areas = areas;
    }

    public List<String> getGrib2Dates() {
        return grib2_dates;
    }

    public void setGrib2Dates(List<String> grib2_dates) {
        this.grib2_dates = grib2_dates;
    }

    public List<String> getLevels() {
        return levels;
    }

    public void setLevels(List<String> levels) {
        this.levels = levels;
    }

    public List<String> getValidities() {
        return validities;
    }

    public void setValidities(List<String> validities) {
        this.validities = validities;
    }

    public boolean isEurAfrTerritory(){
        return this.windmapImageFilename.contains("EurAfr");
    }

    @Override
    public String toString() {
        return "WindmapComponent{" +
                "windmapImageFilename='" + windmapImageFilename + '\'' +
                ", validityIndex=" + validityIndex +
                ", levelIndex=" + levelIndex +
                ", currentWindmapImage=" + Arrays.toString(currentWindmapImage) +
                '}';
    }
}

