#include<iostream>
using namespace std;

long long maxSubArraySum(long long a[], int size)
{
    long long max_so_far = a[0];
    long long curr_max = a[0];

    for (int i = 1; i < size; i++)
    {
        curr_max = max(a[i], curr_max+a[i]);
        max_so_far = max(max_so_far, curr_max);
    }
    return max_so_far;
}

int main()
{
    int n ;
    cin>>n;
    long long a[n];

    for (int i = 0; i < n; ++i) {
        cin>> a[i];
    }


    long long max_sum = maxSubArraySum(a, n);
    cout << max_sum;
    return 0;
}
