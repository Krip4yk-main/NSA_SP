package data.enities;

import java.util.List;

public class Mission {
    public Integer id;
    public String thumb;
    public String list_view_image_alt;
    public String title;
    public String description;
    public String url;
    public String launch_date;
    public String end_date;
    public String target;
    public List category_titles;

    public Mission(Integer id,
            String thumb,
            String list_view_image_alt,
            String title,
            String description,
            String url,
            String launch_date,
            String end_date,
            String target,
            List category_titles)
    {
        this.id = id;
        this.thumb = thumb;
        this.list_view_image_alt = list_view_image_alt;
        this.title = title;
        this.description = description;
        this.url = url;
        this.launch_date = launch_date;
        this.end_date = end_date;
        this.target = target;
        this.category_titles = category_titles;
    }
}
