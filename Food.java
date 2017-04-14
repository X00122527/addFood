package models;


import java.util.*;
import play.data.validation.*;
import javax.persistence.*;
import models.*;
import com.avaje.ebean.Model;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "main")
public class Food extends Model{
    
    @Id
    private Long foodId;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Meal> meals;


    @Constraints.Required
    private String foodName;

    @Constraints.Required
    private String suitable;

    @Constraints.Required
    private double kcal;
    
    @Constraints.Required
    private double protein;

    @Constraints.Required
    private double carbs;

    @Constraints.Required
    private double fat;

    @Constraints.Required
    private String main;



    public Food() {


    }


    public Food(long foodId, String foodName, String suitable, double kcal, double protein, double carbs, double fat) {
        this.foodId = foodId;
        this.suitable = suitable;
        this.foodName = foodName;
        this.kcal = kcal;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }







    //Generic query helper for entity Computer with id Long
    public static Model.Finder<Long,Food> find = new Model.Finder<Long,Food>(Food.class);

    // Find all Posts in the database
    public static List<Food> findAll() {
        return Food.find.all();
    }

    public int rowCount(){
        return (find.where().findRowCount());
    }


    public Food generateProtein(String suitable){
        Random r = new Random();
        System.out.println("suitable in generate protein: "+suitable);
       Food f = null;
       while(f == null){
           int random = r.nextInt(rowCount())+1;
         //  System.out.println("random w protein dla "+suitable +" " +random);
        f = find.where().eq("food_id", random).and().eq("main", "protein").and().eq("suitable", suitable).findUnique();
    }
          return f;     
    }

     public Food generateCarbs(String suitable){

         Random r = new Random();
         System.out.println("suitable in generate carbs: "+suitable);
         Food f = null;
         while(f == null){
             int random = r.nextInt(rowCount())+1;
            // System.out.println("random w carbs dla "+suitable + " " +random);
             f = find.where().eq("food_id", random).and().eq("main", "carbs").and().eq("suitable", suitable).findUnique();
         }
         return f;
     }



    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }


    public double getCarbs() {
        return carbs;
    }

    public double getFat() {
        return fat;
    }

    public double getProtein() {
        return protein;
    }

    public double getKcal() {
        return kcal;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public Long getFoodId() {
        return foodId;
    }

    public String getSuitable() {
        return suitable;
    }

    public void setSuitable(String suitable) {
        this.suitable = suitable;
    }
}
