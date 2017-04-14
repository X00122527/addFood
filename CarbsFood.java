package models;


import java.util.*;
import play.data.validation.*;
import javax.persistence.*;
import models.*;
import com.avaje.ebean.Model;

@Entity
@DiscriminatorValue("carbs")
@PrimaryKeyJoinColumn(referencedColumnName="foodId")
public class CarbsFood extends Food{

    public CarbsFood() {
    }
}
