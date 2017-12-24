package jianzhi;

/**
 * Created by xyan on 12/18/17.
 */
public class GetNumberOfK {

    //先找到第一个k的位置，在找到最后一个K的位置
    public static int solution2(int[] array,int k){
        int start = getFirstK(array,k,0,array.length-1);
        int end = getLastK(array,k,0,array.length-1);
        if(start == -1|| end ==-1)
            return 0;
        return end-start+1;
    }

    public static int getFirstK(int[] array,int k,int start,int end){
        int middle = (start+end)/2;
        while (start <= end){
            if(array[middle]==k){
                //判断k是不是第一个
                if (middle==0 || (middle>0 && array[middle-1]!=k))
                    return middle;
                else
                    end = middle-1;
            }
            else if (array[middle]<k)
                start = middle+1;
            else
                end = middle-1;
            middle = (start+end)/2;
        }
        return -1;
    }

    public static int getLastK(int[] array,int k,int start,int end){
        int middle = (start+end)/2;
        while(start <= end){
            if(array[middle]==k){
                //判断k是不是最后一个
                if (middle==array.length-1 || (middle<array.length-1 && array[middle+1]!=k))
                    return middle;
                else
                    start = middle+1;
            }
            else if (array[middle]<k)
                start = middle+1;
            else
                end = middle-1;
            middle = (start+end)/2;
        }
        return -1;
    }


    //超时
    public static int solution(int[] array,int k){
        int position = -1;
        position = BR(array,k);
        int i =position-1,j =position+1;
        int length = 1;
        if(position == -1)
            return 0;
        //从position往前搜索
        while (i>=0 && array[i]==k){
            length ++;
            i--;
        }
        //从positino往后搜索
        while(j<=array.length-1 && array[j]==k){
            length++;
            j++;
        }
        return length;
    }
    //二分查找k的位置
    public static int BR(int[] array,int k){
        int low = 0,high = array.length-1;
        int middle = (low+high)/2;
        while (low<=high){
            if(array[middle]==k)
                return middle;
            else if (array[middle]<k){
                low = middle+1;
            }
            else
                high = middle-1;
            middle = (low+high)/2;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] array = {1,1,1,2,3,4,5,6,6,7,7,7,7,8};
        int k = 7;
        System.out.println(solution2(array,k));
    }
}
