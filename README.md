### Note: There are few solutions here might be incorrect since I put my practice code here. If you find anything wrong, please create PR and help to fix it. So others will be benefited in future. 
# Life-coding
Solve one problem everyday. 

All of my daily problem solving lives in this repo. Some of the wrong 
attempt is also here. If you follow this repo, make sure you run the code and try
with test cases. 
# Amazon Leadership interview details
* https://interviewgenie.com/blog-1/category/Amazon+interviews

## Goldmine
1. https://www.geeksforgeeks.org/fundamentals-of-algorithms/?ref=shm
2. 
## GeeksForGeeks for google questions
* https://practice.geeksforgeeks.org/problems/construct-list-using-given-q-xor-queries/0/?company%5B%5D=Google#
* 
## Resources
* Cracking the coding interview book
* https://www.geeksforgeeks.org/
* https://www.interviewbit.com/practice/
* https://start.interviewing.io/dashboard/interviewee
* https://leetcode.com/
* https://www.coursera.org/
* https://code.google.com/codejam/kickstart/
* https://www.pramp.com/dashboard
* https://www.youtube.com/channel/UCWSYAntBbdd2SLYUqPIxo0w
* https://www.byte-by-byte.com/
* https://www.dailycodingproblem.com/
* https://coderbyte.com/
* https://www.interviewcake.com
* https://www.geeksforgeeks.org/must-do-coding-questions-for-companies-like-amazon-microsoft-adobe/
* https://www.programcreek.com/2012/11/top-10-algorithms-for-coding-interview/
* Online class: 
    1. https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/
    2. https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-design-and-analysis-of-algorithms-spring-2015/lecture-videos/
* Very fascinating problem sets: https://cses.fi/problemset/list **
## Helper materials: 

Tree:
    
   * Segment Tree: https://www.youtube.com/watch?v=Oq2E2yGadnU
   * AVL Tree: https://www.youtube.com/watch?v=-9sHvAnLN_w
   
## Dynamic Programming   
* Understanding Longest common subsequence: https://www.youtube.com/watch?v=43P0xZp3FU4
* https://avikdas.com/2019/04/15/a-graphical-introduction-to-dynamic-programming.html
* Great example of dynamic programming in real world: https://avikdas.com/2019/05/14/real-world-dynamic-programming-seam-carving.html

### Quick Notes   
#### Counting character frequency in a string. 

 ```
 String s="HelloWorld";
 Map<Character, Long> map = t.chars() //converting int stream
                   .mapToObj(c -> (char) c)//int stream to character stream
                   .collect(Collectors.groupingBy(Function.identity(),// collect by group
                           Collectors.counting()));
           System.out.println(map);
  ```
 
      
#### Best way to find mid point. 
 ``` 
 M=start+(end-start)/2;//overflow error free

```

#### Sort an int array in descending order
```$xslt
int[] sorted = IntStream.of(inputArray)
        .boxed()
        .sorted(Comparator.reverseOrder())
        .mapToInt(i -> i)
        .toArray();
```
  
#### Iterating over map 
  ```
 map.entrySet().stream().forEach(entry->{
            System.out.println("Key: "+entry.getKey()+"value: "+entry.getValue());
        });
```
    
#### String counting in java 8
```$xslt
        String[] strings=new String[]{"hello","world","hello"};
        List<String> list=Arrays.asList(strings);
        Map<String, Long> map1=         list.stream().collect(groupingBy(identity(), counting()));

```        
Alternatively,
```
HashMap<String,Long> map= (HashMap<String, Long>) Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
```


#### Sort list of object based on property
```$xslt
 private static class Inerval {
        int start;
        int end;

        public Inerval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
     ArrayList<Inerval> list=new ArrayList<>();
     list.add(new Inerval(1,3));
     list.add(new Inerval(5,8));
     list.add(new Inerval(4,10));
     list.add(new Inerval(20,25));
     list.sort(Comparator.comparingInt(v -> v.start));
     list.stream().forEach(interval -> {
                System.out.println(interval.start+"->"+interval.end);
      });

# How to sort from largest to smallest

      list.sort((i1, i2) -> {
                 if (i2.start > i1.start) return 1;//we want next bigger element first
                 else if (i1.start > i2.start) return -1;
                 else return 0;
     
             });
     
      list.stream().forEach(interval -> {
          System.out.println(interval.start + "->" + interval.end);
      });
```
#### PriorityQueue with custom comparator
```$xslt
 PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparing(node -> node.val));
```           

#### Custom comparator for nested scenario
```
class Pair implements Comparable<Pair> {
    int score;
    String name;

    Pair(int score, String name) {
        this.score = score;
        this.name = name;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.score == o.score)
            return o.name.compareTo(this.name);
        return this.score - o.score;
    }
```
It will sort based on score but if the scores are level, it will use name based sorting. 

#### Best Way to understand backtracking
* https://www.bilibili.com/video/av36351060?p=1

#### Best way of understanding Huffman Encoding
* https://www.youtube.com/watch?v=ikswC-irwY8&list=PLnfg8b9vdpLn9exZweTJx44CII1bYczuk&index=42

### Bit manipulation 
* ```x &= -x```  will give you the last set bit. 

* XOR of same two number is 0 

* changing a bit from 0 to 1: 
```we can do OR operation : 0 OR 1 = 1 ```.

How can we change a particular bit from 0 to 1. We will do the same OR but differently.
Let say input is: 1011
Take 1(4 bit binary form would be 0001) and make left shift 2 to change the third bit of input. 
```
1<<2=0100
0100 OR 1011 = 1111
```

* How to toggle a bit, from 0 to 1 and 1 to 0 ?
we can do that by doing XOR
```
1 0 | 1
0 1 | 1
0 0 | 0
1 1 | 0
```
Now, how to toggle a particular bit,
Take 1 and do left shift to find the position and do the XOR operation. 
Let say input is: 1011 
```
1 << 1 = 0010
0010 XOR 1011= 1001
```

* How to make a bit switched off?
                           ^
Let take the input 1 0 0 1 1 1 0 1 and wants to turned off the hat bit. 
Take 1, do left bit shift, do NOT and finally AND operation
```
0 0 0 0 0 0 0 1 << 4 = 0 0 0 0 1 0 0 0
NOT(0 0 0 0 1 0 0 0) = 1 1 1 1 0 1 1 1

    1 0 0 1 1 1 0 1
AND 1 1 1 1 0 1 1 1 
------------------
    1 0 0 1 0 1 0 1

```
* How to make a particular integer to a certain number of bit. such as 2 in binary 01 but we 
want to do some operation with bigger number such 7 in binary 111. We need to make 2 into 3 digit binary. 

**Number to represent in a specific number of bits?**
```
  Int num = 1<<L . Left shift. L is the number of bits and it generates L+1 bit with an extra 1 at the beginning
  If L=7, then num=128 meaning 10000000

  Now if you do OR operation with the number you want, let say 2
  10000000 | 10=>10000010, now skip the first bit. You will get 0000010
```
### Shortcut code snippet
* If you need to assign value to a variable based on comparison of others two: follow this
``` a = b == c ? 1 : 0```
means if b and c are equal assign a=1 or a=0

