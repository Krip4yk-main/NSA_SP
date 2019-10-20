package data.enities;

import java.util.List;

public class People
{
    public Integer id;
    public String job_title;
    public String first_name;
    public String middle_name;
    public String last_name;
    public String list_image;
    public String detail_image;
    public String created_at;
    public String updated_at;
    public String page_updated_at;
    public String short_description;
    public String body;
    public String caption;
    public String high_school;
    public String birth_city;
    public String birth_region;
    public String birth_country;
    public String birthplace_latitude;
    public String birthplace_longitude;
    public String list_image_src;
    public String detail_image_src;
    public String link;
    public String birthplace;
    public String name;
    public List categories;

    public People(Integer id,
          String job_title,
          String first_name,
          String middle_name,
          String last_name,
          String list_image,
          String detail_image,
          String created_at,
          String updated_at,
          String page_updated_at,
          String short_description,
          String body,
          String caption,
          String high_school,
          String birth_city,
          String birth_region,
          String birth_country,
          String birthplace_latitude,
          String birthplace_longitude,
          String list_image_src,
          String detail_image_src,
          String link,
          String birthplace,
          String name,
          List categories)
    {
        this.id = id;
        this.job_title = job_title;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.list_image = list_image;
        this.detail_image = detail_image;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.page_updated_at = page_updated_at;
        this.short_description = short_description;
        this.body = body;
        this.caption = caption;
        this.high_school = high_school;
        this.birth_city = birth_city;
        this.birth_region = birth_region;
        this.birth_country = birth_country;
        this.birthplace_latitude = birthplace_latitude;
        this.birthplace_longitude = birthplace_longitude;
        this.list_image_src = list_image_src;
        this.detail_image_src = detail_image_src;
        this.link = link;
        this.birthplace = birthplace;
        this.name = name;
        this.categories = categories;
    }
}
