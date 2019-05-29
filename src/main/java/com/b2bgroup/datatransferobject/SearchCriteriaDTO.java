package com.b2bgroup.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchCriteriaDTO
{

    
    private String title;
    
    
    private String description;

    
    public SearchCriteriaDTO(){
        
    }
    public SearchCriteriaDTO(String title, String description)
    {
     
        this.title = title;
        this.description = description;
    }

    public String getTitle()
    {
        return title;
    }


    public void setTitle(String title)
    {
        this.title = title;
    }


    public String getDescription()
    {
        return description;
    }


    public void setDescription(String description)
    {
        this.description = description;
    }

}
