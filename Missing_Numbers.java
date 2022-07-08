/*Given two arrays of integers, find which elements in the second array are missing from the first array.

Example
-------
arr=[7,2,5,3,5,3]
brr=[7,2,5,4,6,3,5,3]

The brr array is the orginal list.The numbers missing are [4,6].

---------------------------------------------------------------
Notes

If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same. If that is not the case, then it is also a missing number.
Return the missing numbers sorted ascending.
Only include a missing number once, even if it is missing multiple times.
The difference between the maximum and minimum numbers in the original list is less than or equal to 100.*/

CODE:

public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        for(int i=0;i<arr.size();i++){
            if(map1.get(arr.get(i)) != null){
                map1.put(arr.get(i), map1.get(arr.get(i)) + 1);
            }
            else{
                map1.put(arr.get(i),1);
            }
        }
         for(int i=0;i<brr.size();i++){
            if(map2.get(brr.get(i)) != null){
                map2.put(brr.get(i), map2.get(brr.get(i)) + 1);
            }
            else{
                map2.put(brr.get(i),1);
            }
        }
        List<Integer> list = new ArrayList<>();
        
        for(Map.Entry<Integer,Integer> m:map2.entrySet()){
          if(map1.containsKey(m.getKey())){
            if(map1.get(m.getKey()) != m.getValue()){
                list.add(m.getKey());
            }  
          } 
          else{
              list.add(m.getKey());
          }
        }
        
        Collections.sort(list);
        return list;
   
    }

}

/*

TestCases:

10
11 4 11 7 13 4 12 11 10 14
15
11 4 11 7 3 7 10 13 4 8 12 11 10 14 12

O/P: 3 7 8 10 12



*/