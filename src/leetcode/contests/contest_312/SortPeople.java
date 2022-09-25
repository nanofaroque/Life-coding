package leetcode.contests.contest_312;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortPeople {
    class Person{
        String name;
        int height;

        Person(String name, int height){
            this.name=name;
            this.height=height;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        List<Person> people=new ArrayList<>();
        for(int i=0;i<names.length;i++){
            people.add(new Person(names[i], heights[i]));
        }

        Collections.sort(people,(a, b)->b.height-a.height);

        String[] res=new String[names.length];
        int idx=0;
        for(Person data: people){
            res[idx++]=data.name;
        }
        return res;

    }
}
