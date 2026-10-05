package com.sebas.interview.dto;

import java.util.List;

public class PetDto{

    private Integer id;
    private CategoryDto category;
    private String status;
    private String name;
    private List<String> photoUrls;
    private List<TagDto> tags;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public CategoryDto getCategory() {
        return category;
    }
    public void setCategory(CategoryDto category) {
        this.category = category;
    }
    public List<String> getPhotoUrls() {
        return photoUrls;
    }
    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }
    public List<TagDto> getTags() {
        return tags;
    }
    public void setTags(List<TagDto> tags) {
        this.tags = tags;
    }
    public PetDto(Integer id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
    public PetDto() {
    }

    

    

    

    
    

    



    
    
}
