package ru.rybinskov.gb.lesson4.fromManual;

class Link<E>{
    public String name;
    public int age;

    public E next;

    public Link(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void display(){
        System.out.println("Name: "+this.name+", age: "+this.age);
    }
}

