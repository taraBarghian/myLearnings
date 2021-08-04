#include <bits/stdc++.h>

using namespace std;

const int maxn = 1e5 + 5;
const int r = 1e9 + 7;
long long dp[maxn];

void calc() {
    dp[0] = dp[1] = dp[2] = 1;
    dp[3] = 2;
    for (int i = 4; i < maxn; ++i) {
        dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3] - dp[i - 4]) % r;
        dp[i] += r;
        dp[i] %= r;

    }
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n, x;
    calc();

    cin >> n;

    for (int i = 0; i < n; ++i) {
        cin >> x;
        cout << dp[x] << endl;
    }

    return 0;
}
