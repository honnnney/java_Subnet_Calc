package com.ksh.exam.subnet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        System.out.printf("서브넷 마스크 입력: ");
        int subnetmask = sc.nextInt();

        System.out.printf("요구된 서브넷 개수를 입력하세요: ");
        int sn = sc.nextInt();
        System.out.printf("서브넷 개수 : %d\n", sn);

        int[] a = new int[sn];  //서브넷 개수

        int[] hostcount = new int[sn];    //필요 호스트 개수

        int[] power = new int[sn];  //호스트 개수 보다 큰 2의 제곱수 구하기

        for(int i=0;i< a.length;i++){
            System.out.printf("subnet%d : How many hosts: ", i+1);
            hostcount[i] = sc.nextInt();
        }
        System.out.printf("%d, %d, %d, %d\n", hostcount[0],hostcount[1],hostcount[2],hostcount[3]);

        int sum=0;  //각 서브넷들 전체 사용가능한 네트워크 수

        for(int i=0;i<hostcount.length;i++){
            while (Math.pow(2,power[i]) <= hostcount[i]){
                power[i]++;
            }

            sum = sum + (int)Math.pow(2,power[i]);

            System.out.printf("%d번 서브넷의 SubnetMask: %d\n", i+1, 32 - power[i]);
            System.out.printf("%d번의 사용가능 네트워크 수: %d\n",i+1, (int)Math.pow(2, power[i]));

        }
        System.out.printf("%d개 서브넷들의 사용가능한 네트워크 수: %d\n", sn, sum);

        int networkcount = (int)Math.pow(2, 32-subnetmask);
        System.out.printf("네트워크 개수: %d\n", networkcount);

        if(sum > networkcount){
            System.out.printf("host 개수를 잘못 입력하셨습니다.\n");
            System.exit(0);
        }



        sc.close();
    }
}
