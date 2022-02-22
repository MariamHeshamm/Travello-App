package com.example.travelo_app;

public class city {
    private String city_name ;
    private  String image1 ;
    private String image2 ;
    private String image3 ;
    private String image4 ;

    public city( String city_name , String image1, String image2, String image3, String image4 ) {
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.city_name = city_name ;
    }

    public String getImage1() {
        return image1;
    }

    public String getImage2() {
        return image2;
    }

    public String getImage3() {
        return image3;
    }

    public String getImage4() {
        return image4;
    }

    public String getCity_name() {
        return city_name;
    }
}
