//bus route time calculation:-
import java.util.Scanner;
class my_java_rough_note{
    static Scanner scan= new Scanner(System.in);
    static int no_of_bus_stops=0,no_of_bus_routes=0,k=0;
    public static void navigator(int arr[][],int index,int timing_arr[]){
        if(timing_arr[k]>no_of_bus_routes){
            timing_arr[k]=99999;
            return;
        }
        int initial_location=arr[index][1];
        if(initial_location==(no_of_bus_stops-1)){
            timing_arr[k]++;
            k++;
        }
        int current_bus=arr[index][2];
        for(int i=0;i<no_of_bus_routes;i++){
            if(initial_location==arr[i][0]){
                if(current_bus==arr[i][2]){
                    timing_arr[k]++;
                    navigator(arr, i, timing_arr);
                }
                else{
                    timing_arr[k]+=2;
                    navigator(arr, i, timing_arr);
                }
            }
        }
        
    }       
    public static void main(String args[]){
        int i,j;
        System.out.print("enter no of bus stops: ");
        no_of_bus_stops=scan.nextInt();
        System.out.print("enter no of bus routes: ");
        no_of_bus_routes=scan.nextInt();
        int timing_arr[]=new int[no_of_bus_routes];
        int bus_route_details[][]= new int[no_of_bus_routes][3];
        System.out.println("enter the bus route details:-");
        for(i=0;i<no_of_bus_routes;i++){
            for(j=0;j<3;j++){
                bus_route_details[i][j]=scan.nextInt();
            }
        }
        for(i=0;i<no_of_bus_routes;i++){
            if(bus_route_details[i][0]==0)
                navigator(bus_route_details, i, timing_arr);
        }
        int min=99999;
        for(i=0;i<k;i++)
            if(min>timing_arr[i])
                min=timing_arr[i];
        System.out.println("min_time: "+min);    
    }
}
