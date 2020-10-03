#include<iostream>
using namespace std;

void printAllPos(int a[],int n,int x,int i){
   if(i==n){
    return;
   }
   if(a[i]==x){
    cout<<i<<" ";
   }
   printAllPos(a,n,x,i+1);
}
void count(int a[],int n,int x,int i, int &ans){
    if(i==n){
      return;
   }
   if(a[i]==x){
    ans++;
   }
   count(a,n,x,i+1,ans);
}
int main(){
  int a[] = {5,5,6,5,6,7};
  /// printAllPos(a,6,10,0);

  int ans = 0;
  count(a,6,10,0,ans);
  cout<<ans<<endl;
  return 0;
}
