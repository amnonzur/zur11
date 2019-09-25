package com.example.zur11;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;

public class EpicNasa {
    private String identifier; //20190627021926
    private String caption; //this imag eas ....
    private String image;
    private String date; //yyyy-mm-dd



    public EpicNasa(String identifier, String caption, String image, String date) {
        this.identifier = identifier;
        this.caption = caption;
        this.image = image;
        this.date = date;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getImageUrl(){
    /*    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy/mm/dd");
        String localDateString =formatter.format(getLocalDate());
        return "http://epic.gsfc.nasa.gov/archive/natural/"+localDateString +"/png/" +image +".png";
  */
    String  d = date.split(" ")[0];
    String localDateString =d.replace("-","/");
    return "http://epic.gsfc.nasa.gov/archive/natural/"+localDateString +"/png/" +image +".png";
    }

    public LocalDate getLocalDate(){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");//HH-=24     hh=12

         LocalDateTime ldt =LocalDateTime.parse(date,formatter);
         return ldt.toLocalDate();
    }


    @Override
    public String toString() {
        return "EpicNasa{" +
                "identifier='" + identifier + '\'' +
                ", caption='" + caption + '\'' +
                ", image='" + image + '\'' +
                ", date='" + date + '\'' +
                ",imageUrl='"+ getImageUrl()+
                '}';
    }


}