package com.in28minutes.microservices.testes;

public class BankNotification {

//    // Complete the activityNotifications function below.
//    public static int activityNotifications(int[] expenditure, int d) {
////        int notification = 0;
////        int medianPos = d / 2;
////        return isEven(d)
////                ? evenApproach(expenditure, d, medianPos, notification)
////                : oddApproach(expenditure, d, medianPos, notification);
//        int notice=0;
//        for(int i=0;i<=expenditure.length-d;i++) {
//            int arr[]=new int[d],median=0;
//            arr=countSort(expenditure,i,i+d);
//            if(d%2==0) {
//                int mid1=(d)/2;
//                int mid2=(d)/2 +1;
//                median=(arr[mid1]+arr[mid2])/2;
//            }else {
//                int mid=(d)/2;
//                median=arr[mid];
//            }
//            if(i+d<expenditure.length&&expenditure[i+d]>=2*median) {
//                notice++;
//            }
//        }
//        return notice;
//    }
//
//    private static int oddApproach(int[] expenditure, int d, int medianPos, int notification) {
//        for (int i = d; i < expenditure.length; i++) {
//            int[] intreval = countSort(expenditure, i - d, i);
////            int[] copy = new int[d];
////            System.arraycopy(expenditure, i-d, copy, 0, copy.length); Arrays.copyOfRange(expenditure, i-d, i);
////            Arrays.parallelSort(copy);
//            if (expenditure[i] >= (2 * intreval[medianPos])) {
//                notification++;
//            }
//        }
//        return notification;
//    }
//
//    static int[] countSort(int[] arr, int init, int end)
//    {
//        int max = Arrays.stream(arr).max().getAsInt();
//        int min = Arrays.stream(arr).min().getAsInt();
//        int range = 200;
//        int count[] = new int[range];
//        int output[] = new int[arr.length];
//        for (int i = 0; i < arr.length; i++)
//        {
//            count[arr[i] - min]++;
//        }
//
//        for (int i = 1; i < count.length; i++)
//        {
//            count[i] += count[i - 1];
//        }
//
//        for (int i = arr.length - 1; i >= 0; i--)
//        {
//            output[count[arr[i] - min] - 1] = arr[i];
//            count[arr[i] - min]--;
//        }
//
//        for (int i = 0; i < arr.length; i++)
//        {
//            arr[i] = output[i];
//        }
//        return output;
//    }
//
//    private static int evenApproach(int[] expenditure, int d, int medianPos, int notification) {
//        int secondMedian = medianPos + 1;
//        for (int i = d; i < expenditure.length; i++) {
//            int[] intreval = countSort(expenditure, i - d, i);
////            int[] copy = Arrays.copyOfRange(expenditure, i-d, i);
////            Arrays.parallelSort(copy);
//            if (expenditure[i] >= (2 * ((float)intreval[medianPos] + (float)intreval[secondMedian]) / 2)) {
//                notification++;
//            }
//        }
//        return notification;
//    }
//
    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int activityNotifications(int[] expenditure, int d) {;

        boolean isEven = isEven(d);
        int dHalf = d / 2;
        int notificationCount = 0;

        int[] data = new int[6];
        for (int i = 0; i < d; i++) {
            data[expenditure[i]]++;
        }

        for (int i = d; i < expenditure.length; i++) {

            double median = getMedian(d/2, data, isEven);

            if (expenditure[i] >= 2 * median) {
                notificationCount++;

            }

            data[expenditure[i]]++;
            data[expenditure[i - d]]--;

        }

        return notificationCount;

    }

    private static double getMedian(int dHalf, int[] data, boolean isEven) {
        double median = 0;
        if (isEven) {
            Integer m1 = null;
            Integer m2 = null;
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                count += data[j];
                if (m1 == null && count >= dHalf) {
                    m1 = j;
                }
                if (m2 == null && count >= dHalf + 1) {
                    m2 = j;
                    break;
                }
            }
            median = (m1 + m2) / 2.0;
        } else {

//            int[] array = new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5};//read(200000l); // 2, 2, 3, 3, 4
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                count += data[j];
                if (count > dHalf) {
                    return j;
                }
            }
        }
        return median;
    }

//    [5, 1, 3, 4, 2, 1]
    public static int[] countingSort(int[] array, int range) {
        int[] sortedArray = new int[array.length];
        int[] numbersByIndice = new int[range+1];

        for (int i = 0; i <= range; i++) {
            numbersByIndice[array[i]]++;
        }

        for (int i = 0; i < numbersByIndice.length; i++) {
            for (int j = i; numbersByIndice[i] > 0; j++) {
                sortedArray[j] = i;
                numbersByIndice[i]--;
            }
        }

        return sortedArray;
    }


//    public static int hourglassSum(int[][] arr) {
//
//        int lines = arr.length-1,
//                colluns = arr[0].length-1;
////                count, sum=0, maximum = -;
//
//        for(int i=2; i <= lines; i++) {
//
//            for(int j=2; j <= colluns; j++) {
//                count = 0;
//                sum =0;
//                for(int m = i-2; m <= i; m++) {
//
//                    for(int n = j-2; n <= j; n++) {
//                        count++;
//
//                        if(count != 4 && count != 6) {
//                            sum += arr[m][n];
//                        }
//                    }
//
//                }
//
//                if(sum > maximum)
//                    maximum = sum;
//            }
//
//        }
//        return maximum;
//    }


    public static int divisor_sum(int n) {

        int[][] arr = new int[3][4];

        int sum = n > 1 ? 1 + n : 1;

        for(int i = 2; i < n-1; i++) {
            if(n % i == 0)
                sum += i;
        }
        return sum;
    }

}
