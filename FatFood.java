package models;


import java.util.*;
import play.data.validation.*;
import javax.persistence.*;
import models.*;
import com.avaje.ebean.Model;

@Entity
@DiscriminatorValue("fat")
@PrimaryKeyJoinColumn(referencedColumnName="foodId")
public class FatFood extends Food{
    public FatFood() {
    }
}
