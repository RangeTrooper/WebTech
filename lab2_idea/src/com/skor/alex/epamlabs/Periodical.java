package com.skor.alex.epamlabs;

import java.util.Comparator;
import com.skor.alex.epamlabs.Categories;

public class Periodical {
    private String name;
    private int issue;
    private String tags;
    private float price;
    private String type;
    private String category;
    private int ID;


    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

    public int getIssue() {
        return this.issue;
    }

    public String getTags() {
        return this.tags;
    }

    public float getPrice() {
        return this.price;
    }

    public void setName(String name) {
        this.name=name;
    }

    public int getID(){
        return this.ID;
    }

    public void setID(int ID){
        this.ID=ID;
    }

    public void setCategory(String category) {
        this.category=category;
    }

    public void setTags(String tags) {
        this.tags=tags;
    }

    public void setIssue(int issue) {
        this.issue=issue;
    }

    public void setPrice(float price) {
        this.price=price;
    }

    public void setType(String type){
        this.type=type;
    }

    public String getType(){
        return this.type;
    }


    public static Comparator<Periodical> PriceComparator = new Comparator<Periodical>() {

        @Override
        public int compare(Periodical e1, Periodical e2) {
            return (int) (e1.getPrice() - e2.getPrice());
        }
    };

    public static Comparator<Periodical> IssueComparator = new Comparator<Periodical>() {

        @Override
        public int compare(Periodical e1, Periodical e2) {
            return e1.getIssue() - e2.getIssue();
        }
    };
    public static Comparator<Periodical> NameComparator = new Comparator<Periodical>() {

        @Override
        public int compare(Periodical e1, Periodical e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };
}
