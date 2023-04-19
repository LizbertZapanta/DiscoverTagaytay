package com.example.tagaytay;

public class AttractionData {
    /**
     * Attraction Data is the class with all the components needed to create the objects needed for the layout.
     */
    //Variables
    private String attraction;
    private String description;
    private Integer image;


    //Constructors
    public AttractionData(Integer image, String attraction, String description) {
        this.image = image;
        this.attraction = attraction;
        this.description = description;
    }

    public AttractionData(Integer image, String attraction) {
        this.image = image;
        this.attraction = attraction;

    }



    //Getters and Setters
    public String getAttraction() {

        return attraction;
    }

    public void setAttraction(String attraction) {

        this.attraction = attraction;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Integer getImage() {

        return image;
    }

    public void setImage(Integer image) {

        this.image = image;
    }


}
