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

    public double totalGrade() {
    	double total = 0.0; 
    	for (double num:this.grades) {
    		total += num;
    	}
    	System.out.println("total is:" +total);
    	return total;
    }
    
    public double calcAverage() { //calculate the average

        //calculation
        double average = totalGrade() / this.grades.size();

        return average;
    } // end calcAverage here

    public double dropLowest() {

    	if (grades.size() == 0) {
    		System.out.println("No grades to drop! Please add more grades"); 
    		return 0;
    	} else {
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
    }

    public void addGrade(double grade) {
    	if (grade < 0 && grade > 100) {
    		System.out.println("Invalid input!");
    	} else {
    		grades.add(grade); //.add() to add values    		
    	}
    }

    public boolean removeAllGrades (double grade) {

    	if (grade <  0 && grade > 100) {
    		System.out.println("Invalid input");
    		return false;
    	} else {
    		//create one boolean to use through out this method
    		boolean res = false;
    		for (int i=grades.size()-1; i>=0; i--) {
    			if (grades.get(i) == grade) {
    				grades.remove(i);
    				//return true if the grade was found
    				res = true;
    			}
    		}
    		if (res) {
    			System.out.println("Removed grade = "+grade);
    		} else {
    			System.out.println("No grade,"+grade+", found to remove! Please try again!");
    		}
    		//return false if the grade was not found
    		return res;
    		
    	}
    	

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
    
    
    //passingGrades
    public void passingGrade(double a, double b) {
    	if (checkValid(a) || checkValid(b)) {
    		System.out.println("Invalid input");
    	} else {
	    	double avg = calcAverage();
	    	if (avg < a) {
	    		double temp = totalGrade()+b;
	    		temp = temp / (grades.size() + 1);
	    		
	    		if (temp >= a) {
	    			System.out.println("Target average reached\n");
	    		} else {
	    			System.out.println("Added grades not sufficent!");
	    		}
	    	} else {
	    		System.out.println("Target average too low");
	    	}
	    }
    }
    public Boolean checkValid(double grade) {
    	if (grade >= 0 && grade <= 100) {
    		return true;
    	} else {
    		return false;    		
    	}
    }
    

    public void estimatedGPA(double test1Sc, double test2Sc, double midtermSc, double finalSc) {
    	if (checkValid(test1Sc) && checkValid(test2Sc) && checkValid(midtermSc) && checkValid(finalSc)) {
    		double total = test1Sc + test2Sc + midtermSc + finalSc;
    		double res = total/ 4;
    		
    		if (res > 90) {
    			System.out.println("GPA: percentage - " + res + " letter - A" );
    		} else if (res > 85 && res < 90) {
    			System.out.println("GPA: percentage - " + res + " letter - B" );
    		} else if (res > 80 && res < 85) {
    			System.out.println("GPA: percentage - " + res + " letter - C" );
    		} else if (res > 75 && res < 80) {
    			System.out.println("GPA: percentage - " + res + " letter - D" );
    		} else {
    			System.out.println("GPA: percentage - " + res + "! You failed the course!" );
    		}
    		
    	} else {
    		System.out.println("Invalid input");
    	}
    }
    
    
    //override the Object's toString();
    @Override
    public String toString() {
        String out="Grades " +grades;
        return out;
    }




}




