#include <iostream>
using namespace std;
bool checkPresent(int arr[], int n, int i) {
    if (n==0) {
        return false;
    }
    if (arr[0]==i) {
        return true;
    }
    return checkPresent(arr+1, n-1, i);
}

int main() {
    int arr[] = {1,2,3,4,5};
    bool isPresent = checkPresent(arr, 5,41);
    cout<<isPresent;
}
