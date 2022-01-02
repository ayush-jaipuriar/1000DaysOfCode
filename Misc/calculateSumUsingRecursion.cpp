#include <iostream>
using namespace std;
int calculateSum(int arr[], int n) {
    if (n==0) {
        return 0;
    }
    return arr[0]+calculateSum(arr+1, n-1);
}
int main() {
    int arr[] = {1,2,3,4,5};
    int sum = calculateSum(arr, 5);
    cout<<sum;
}
