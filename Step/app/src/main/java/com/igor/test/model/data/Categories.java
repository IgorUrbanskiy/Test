package com.igor.test.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 13.09.2016.
 */


public class Categories implements Serializable{


    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("subcategories")
    @Expose
    private List<Subcategory> subcategories = new ArrayList<Subcategory>();

    /**
     * @return The category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category The category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return The subcategories
     */
    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    /**
     * @param subcategories The subcategories
     */
    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }
    class Subcategory implements Serializable {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("ranking")
        @Expose
        private Integer ranking;
        @SerializedName("isVisible")
        @Expose
        private Boolean isVisible;

        /**
         * @return The id
         */
        public String getId() {
            return id;
        }

        /**
         * @param id The id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @return The name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name The name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return The ranking
         */
        public Integer getRanking() {
            return ranking;
        }

        /**
         * @param ranking The ranking
         */
        public void setRanking(Integer ranking) {
            this.ranking = ranking;
        }

        /**
         * @return The isVisible
         */
        public Boolean getIsVisible() {
            return isVisible;
        }

        /**
         * @param isVisible The isVisible
         */
        public void setIsVisible(Boolean isVisible) {
            this.isVisible = isVisible;
        }

    }


}


