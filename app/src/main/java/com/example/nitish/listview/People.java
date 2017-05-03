package com.example.nitish.listview;

public class People {

    private int _id;
    private String _name;

    public People(){
    }

    public People(String name) {
        this._name = name;
    }

    public void set_id(int id) {
        this._id = id;
    }

    public void set_name(String name) {
        this._name = name;
    }

    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }
}
