package models;


import java.util.*;
import play.data.validation.*;
import javax.persistence.*;
import models.*;
import com.avaje.ebean.Model;

@Entity
@DiscriminatorValue("protein")
@PrimaryKeyJoinColumn(referencedColumnName="foodId")
public class ProteinFood extends Food{
    public ProteinFood() {
    }
}
