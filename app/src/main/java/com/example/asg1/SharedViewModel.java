package com.example.asg1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class SharedViewModel extends ViewModel {
    public MutableLiveData<ArrayList<Person>> item = new MutableLiveData<>();

    public ArrayList<Person> getList() {
        return item.getValue();
    }

    public void addPerson(Person p) {
        ArrayList<Person> lis=this.item.getValue();
        lis.add(p);
        this.item.setValue(lis);
    }

    public Person searchPerson(String s)
    {
        ArrayList<Person> lis=this.item.getValue();
        for (int i=0;i<lis.size();i++)
        {
            if(lis.get(i).getName().equals(s))
            {
                return lis.get(i);
            }
        }
        return null;
    }

    public void initialize(){
        ArrayList<Person> lis=new ArrayList<>();
        item = new MutableLiveData<ArrayList<Person>>();
        item.setValue(lis);
    }
}
