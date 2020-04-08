package com.jpvr.demodesignpatterns.katas.codewars;

public class People {

    private String name;
    private String lastName;
    private int age;
    private String city;
    private String job;
    private String GREET;

    public String greet(){
        return "hello my name is "+name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGreet() {
        return GREET;
    }

    public String getCity() {
        return city;
    }

    public String getJob() {
        return job;
    }

    public static PeopleBuilder builder() {
        return new PeopleBuilder();
    }

    public static class PeopleBuilder {
        private String name;
        private String lastName;
        private int age;
        private String city;
        private String job;
        private String GREET;

        public PeopleBuilder() {
        }

        public PeopleBuilder name(String val) {
            name = val;
            return this;
        }

        public PeopleBuilder lastName(String val) {
            lastName = val;
            return this;
        }

        public PeopleBuilder age(int val) {
            age = val;
            return this;
        }

        public PeopleBuilder city(String val) {
            city = val;
            return this;
        }

        public PeopleBuilder job(String val) {
            job = val;
            return this;
        }

//        public PeopleBuilder greet(String val) {
//            //greet = val;
//            greet = "hello my name is " + name;
//            return this;
//        }

        public People build() {
            return new People(this);
        }
    } // end static class builder

    private People(PeopleBuilder builder) {

        name = builder.name;
        lastName = builder.lastName;
        age = builder.age;
        city = builder.city;
        job = builder.job;
        GREET = "hello my name is " + builder.name;
    } // end People(builder builder)
} // end class People
