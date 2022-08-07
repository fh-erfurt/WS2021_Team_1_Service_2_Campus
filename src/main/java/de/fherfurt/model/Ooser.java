package de.fherfurt.model;


import de.fherfurt.core.entity.AbstractDatabaseEntity;

import javax.persistence.Entity;
import java.util.Date;


@Entity
public class Ooser extends AbstractDatabaseEntity
{
    private String fullName;
    private String ooserName;
    private boolean active;


    public Ooser(String fullName, String ooserName){
        this.fullName = fullName;
        this.ooserName = ooserName;
        active = true;
        //this.posts = posts;
        //this.comments = comments;
    };

    public Ooser(){
        active = true;
    };

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getOoserName() {
        return ooserName;
    }

    public void setOoserName(String ooserName) {
        this.ooserName = ooserName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode()
    {
        int result = ooserName.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

}