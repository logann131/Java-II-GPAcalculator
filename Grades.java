/*
    Name: Logan Nguyen
    Date: 10/09/2019
    "This is the grade class would help GradesClient work"
 */

import java.util.*;
public class Grades {
    private ArrayList<Double> grades; //private instance variable

    //Default constructor
    public Grades() {

        grades = new ArrayList<>();
    }

    public double calcAverage() { //calculate the average

        //need a variable for total value
        double total = 0.0;
        for(int i=0; i<this.grades.size(); i++) {
            total += this.grades.get(i);
        }
        //calculation
        double average = total / this.grades.size();

        return average;
    } // end calcAverage here

    public double dropLowest() {

        //declare lowest variable = grades.get(0) then
        //compare lowest to the rest of the ArrayList
        double lowest = this.grades.get(0);
        for (int i=1; i<this.grades.size(); i++) {
            if (this.grades.get(i) < lowest) {
                lowest = this.grades.get(i);
            }
        }
        //remove only one lowest value
        grades.remove(lowest);
        //return the lowest value
        return lowest;
    }

    public void addGrade(double grade) {
        grades.add(grade); //.add() to add values
    }

    public boolean removeAllGrades (double grade) {

        //create one boolean to use through out this method
        boolean result = false;
        for (int i=grades.size()-1; i>=0; i--) {
            if (grades.get(i) == grade) {
                grades.remove(i);
                //return true if the grade was found
                result = true;
            }
        }
        //return false if the grade was not found
        return result;

    }

    public void printSortedGrades() {
        //create a current variable
        double current = 0.0;

        //using two for loops to sort an ArrayList
        for (int i=1; i<grades.size(); i++) {
            for (int j=i; j>0; j--) {
                if (grades.get(j) < grades.get(j - 1)) {
                    current = grades.get(j);
                    grades.set(j, grades.get(j-1));
                    grades.set(j-1, current);
                }
            }
        }

        //we can use collection here
        //Collection.sort(grades);


        //print the ArrayList
        System.out.println(grades);
    }

    //override hte Object's toString();
    @Override
    public String toString() {
        String out="Grades " +grades;
        return out;
    }




}



















