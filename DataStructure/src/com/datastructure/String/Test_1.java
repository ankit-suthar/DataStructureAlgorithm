package com.datastructure.String;

public class Test_1 {

    static int findMinUtil(int[] nums,int l,int h){

        int mid =  (l+h)/2;

        if(mid>l && nums[mid]<nums[mid-1]){
            return mid;
        }else if(mid<h && nums[mid]>nums[mid+1]){
            return mid+1;
        }else if(nums[mid]>nums[h]){
            return findMinUtil(nums,mid+1,h);
        }else{
            return findMinUtil(nums,l,mid-1);
        }
    }

    static int findMin(int[] nums) {
        int n = nums.length;
        return findMinUtil(nums,0,n-1);
    }

    public static void main(String[] a){
        int arr[] = {3,4,5,1,2};
        System.out.println(findMin(arr));
    }
}
