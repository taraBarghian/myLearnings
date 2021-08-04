#include <bits/stdc++.h>

using namespace std;

const int maxn = 2005;
const int r = 1e9 + 7;
long long dp[maxn][maxn];

void calc() {

    for (int i = 0; i < maxn; ++i) {
        for (int j = 0; j <= i; ++j) {
            if (j == 0 || i == j)
                dp[i][j] = 1;
            else
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % r;

        }
    }

}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int q,r,n;
    calc();

    cin >> q;

    for (int i = 0; i < q; ++i) {
        cin >> n>>r;
        cout << dp[n][r] << endl;
    }

    return 0;
}
