package com.java;

import java.util.*;

public class ExampleComparator {
    public static class Employee {
        String name;
        int age;
        Employee(String name, int age){
            this.name=name;
            this.age=age;
        }

    }

    public static class Player implements Comparable<Player>{
        private int ranking;
        private String name;
        private int age;


        // constructor, getters, setters
        Player(int age,String name,int rank){
            this.age=age;
            this.name=name;
            this.ranking=rank;

        }

        @Override
        public int compareTo(Player o) {
            return o.ranking-this.age;
        }
    }

    public class EmployeRankComparator implements Comparator<Player>{



        @Override
        public int compare(Player o1, Player o2) {
            return o1.ranking-o2.ranking;
        }
    }


    public static void main(String[] args) {
        List<Player> footballTeam = new ArrayList<>();
        Player player1 = new Player(59, "John", 20);
        Player player2 = new Player(67, "Roger", 22);
        Player player3 = new Player(45, "Steven", 24);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);

        System.out.println("Before Sorting : " + footballTeam);
        Collections.sort(footballTeam);
        Collections.sort(footballTeam,Collections.reverseOrder());

        System.out.println("After Sorting : " + footballTeam);

        List<Employee> emps = new ArrayList<Employee>();
        Employee emp=new Employee("2",2);
        Employee emp1=new Employee("1",5);
        emps.add(emp);
        emps.add(emp1);

        Collections.sort(emps, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.age- o2.age;
            }
        }

        );
    }


}
