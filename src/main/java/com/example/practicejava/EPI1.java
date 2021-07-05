package com.example.practicejava;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// For int
public class EPI1 {
  // minimum change that cannot be returned from a set of numbers;
  // time complexity of iteration is o(n) and sorting is o(nlogn) which equals o(nlogn)
  static int smallestNonConstructible(int[] arr) {
    Arrays.sort(arr);
    int currentSum = 0;
    for (int a : arr) {
      if (a > currentSum + 1) break;
      currentSum += a;
    }

    return currentSum + 1;
  }

  // time complexity is o(n)
  static int reverseInteger(int A) {
      int result = 0;
      int remainder = Math.abs(A);
      while(remainder != 0) {
          result = result * 10 + remainder%10;
          remainder/= 10;
      }
      return A> 0? result : -result;

  }

  // time complexity is o(n)
  static boolean isPalindromeNumber(int A) {
      String string = String.valueOf(A);
      int j = string.length()-1;
      for(int i =0; i<string.length(); i++) {
          if(string.charAt(i) != string.charAt(j)){
              return false;
          }
          j--;
      }
      return true;
  }

  // time complexity is o(n)
  static int [] evenOdd(int [] A) {
      int nextEven = 0; int nextOdd = A.length -1;

      while(nextEven<nextOdd) {
          if(A[nextEven] % 2 == 0)
              nextEven++;
          else {
              int temp = A[nextEven];
              A[nextEven] = A[nextOdd];

              A[nextOdd] = temp;
              nextOdd--;

          }
      }
      return A;
  }

  static enum Color {RED, WHITE, BLUE}
  static  List<Color> doFlagPartitions(int pivotIndex, List<Color> A) {
      //Collections.nc
      Color pivot= A.get(pivotIndex);
      int smaller = 0; int equal = 0; int larger = A.size() -1 ;
      while(equal < larger) {
          if(A.get(equal).ordinal() < pivot.ordinal()) {
        Collections.swap(A, smaller++, equal++);
          }
          else if(A.get(equal).ordinal() == pivot.ordinal()) {
               ++equal;
          }
          else {
              Collections.swap(A, equal, larger--);
          }
      }
      return A;
  }

  // time complexity is O(n)
  static List<Integer> plusOne(List<Integer> A) {
      A = new ArrayList<>(A);
      int n = A.size() -1;
      A.set(n, A.get(n) + 1);

      for(int i =n; i> 0 && A.get(i) == 10; i--) {
          A.set(i, 0);
          A.set(i-1, A.get(i-1)+1);
      }
      if(A.get(0) == 10) {
          A.set(0, 0);
          A.add(0, 1);
      }
     return A;
  }

  static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
       num1 = new ArrayList<>(num1);
       num2 = new ArrayList<>(num2);
       final int sign = num1.get(0) < 0 || num2.get(0) < 0 ? -1 : 1;
       num1.set(0, Math.abs(num1.get(0)));
       num2.set(0, Math.abs(num2.get(0)));
      List<Integer> result = Collections.nCopies(num1.size()+num2.size()+1, 0);
      result = new ArrayList<>(result);
       for(int i = num1.size() -1; num1.size()> 0; --i) {
           for(int j = num2.size()-1; num2.size()> 0; --j) {
             result.set(i + j + 1, result.get(i + j + 1) + num1.get(i) * num2.get(j));
              result.set(i + j, result.get(i + j) + result.get(i + j + 1)/10);
              result.set(i + j + 1, result.get(i + j + 1)%10);
           }
       }
       return result;
  }


    static int migratoryBirds(List<Integer> arr) {

      Set<Integer>a = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0; i<arr.size(); i++) {
            int current = arr.get(i);
            if(map.containsKey(current)) {
                map.put(current, map.get(current) + 1);
      } else {
        map.put(current, 1);
            }
        }
        int max = map.values().stream().max(Comparator.naturalOrder()).get();
        Set<Integer> maximums = map.keySet().stream().filter(i -> map.get(i) == max).collect(Collectors.toSet());
        return maximums.stream().min(Comparator.naturalOrder()).get();
    }

    // time complexity is o(n) and space complexity is o(1)
  static int deleteDuplicates(List<Integer> A) {
    if (A.isEmpty()) return 0;

    int readIndex = 1;
    for (int i = 1; i < A.size(); ++i) {
      if (!A.get(readIndex - 1).equals(A.get(i))) {
          System.out.println("read index: " +readIndex+ " current i: "+i+ " current val: "+A.get(i));
          //A.set(readIndex++, A.get(i));
          readIndex++;
      }
    }
    return readIndex;
      }

    // canReachEnd

    static  int deleteOccurrences(List<Integer>A, int key) {
      if(A.isEmpty())
          return 0;

      int other = 0;
      for(int i =0; i<A.size(); i++) {
          if(!A.get(i).equals(key))
              other++;
      }
      return other;
    }

  public static double computeMaxProfit(List<Double> prices) {
    double minPrice = Double.MAX_VALUE, maxProfit = 0.0;
    for (Double price : prices) {
        System.out.println(maxProfit);
      maxProfit = Math.max(maxProfit, price - minPrice);
      minPrice = Math.min(minPrice, price);
      }
    return maxProfit;
        }



    public static String encode(String s) {

      //  String s = "if man was meant to stay on the ground god would have given us roots";
        String y = s.replaceAll("\\s+", "");
        int L = y.length();
        int columns = (int) Math.sqrt(L);
        int rows = columns + 1;

        System.out.println(columns);
        System.out.println(rows);
        if (columns * rows < L) columns+=1;



        List<String> str = new ArrayList<>();
        int index = 0;
        System.out.println(rows);

        while (index < L) {
            str.add(y.substring(index, Math.min(index + rows, L)));
            index += rows;
        }

        List<String> encoded = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            int n = i;
            encoded.add(
                    str.stream()
                            .filter(j -> j.length()>=n+1)
                            .map(j -> j.charAt(n))
                            .collect(
                                    Collector.of(
                                            StringBuilder::new,
                                            StringBuilder::append,
                                            StringBuilder::append,
                                            StringBuilder::toString)));
        }

        return String.join(" ", encoded);
    }
}
