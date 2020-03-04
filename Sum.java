import java.util.*;
public class Sum{
  public static List<List<Integer>> solve(int[] a){
    //Arrays.sort(a);
    List<List<Integer>> master = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<>();
    int temp = 0, recip = 0;
    boolean getTemp = true;
    boolean foundDuplicate = false; 
    
    for(int i = 0; i< a.length - 2; i++){
      temp = a[i];//-1
      recip = temp * (-1); //1
      
      
      for(int j = i+2; j < a.length; j++){
        //if  0 + 1 == 1 
        //if  0 + 2 == 1
        if(a[i+1] + a[j] == recip){
          list = new ArrayList<>();
          list.add(temp); 
          list.add(a[i+1]);
          list.add(a[j]);
          Collections.sort(list);
          
          for(int x = 0; x < master.size(); x++){
            if(master.get(x).equals(list))
              foundDuplicate = true;
          }
          
          if(foundDuplicate == false){
            master.add(list);
          }
          //break;
        }
      }//end nested loop
    }//end original loop
    
    return master;
  }
  
  public static void main(String[] args){
    int[] arr = {-1,0,1,2,-1,-4};
    System.out.println(solve(arr));
  }
}