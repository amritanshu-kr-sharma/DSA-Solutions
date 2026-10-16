class Solution {
    private static final long MOD = 1_000_000_007L;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree tree = new SegmentTree(n);
        int[] lastSeen = new int[100001];
        long answer = 0;
        for (int i = 0; i < n; i++) {
            int value = nums[i];
            // Convert the previous occurrence to a 1-based
            // starting position for the segment tree.
            int previous = lastSeen[value];
            // All subarrays starting after the previous occurrence
            // gain one additional distinct element.
            tree.increment(previous + 1, i + 1);
            // Record the current occurrence using 1-based indexing.
            lastSeen[value] = i + 1;
            // Sum of squared distinct counts of subarrays
            // ending at the current index.
            answer = (answer + tree.querySquares(1, i + 1)) % MOD;
        }
        return (int) answer;
    }

    static class SegmentTree {
        int n;
        long[] sum;
        long[] sumSquares;
        long[] lazy;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n + 5];
            sumSquares = new long[4 * n + 5];
            lazy = new long[4 * n + 5];
        }

        void apply(int node, int left, int right, long delta) {
            long length = right - left + 1L;
            sumSquares[node] = (
                sumSquares[node]
                + 2L * delta % MOD * sum[node] % MOD
                + delta * delta % MOD * length % MOD
            ) % MOD;
            sum[node] = (sum[node] + delta * length) % MOD;
            lazy[node] = (lazy[node] + delta) % MOD;
        }

        void push(int node, int left, int right) {
            if (lazy[node] == 0 || left == right) {
                return;
            }
            int mid = left + (right - left) / 2;
            apply(node * 2, left, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, right, lazy[node]);
            lazy[node] = 0;
        }

        void increment(int queryLeft, int queryRight) {
            if (queryLeft > queryRight) {
                return;
            }
            increment(1, 1, n, queryLeft, queryRight);
        }

        void increment(
            int node,
            int left,
            int right,
            int queryLeft,
            int queryRight
        ) {
            if (queryLeft <= left && right <= queryRight) {
                apply(node, left, right, 1);
                return;
            }
            push(node, left, right);
            int mid = left + (right - left) / 2;
            if (queryLeft <= mid) {
                increment(
                    node * 2, left, mid, queryLeft, queryRight
                );
            }
            if (queryRight > mid) {
                increment(
                    node * 2 + 1, mid + 1, right,
                    queryLeft, queryRight
                );
            }
            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
            sumSquares[node] = (
                sumSquares[node * 2] + sumSquares[node * 2 + 1]
            ) % MOD;
        }

        long querySquares(int queryLeft, int queryRight) {
            return querySquares(
                1, 1, n, queryLeft, queryRight
            );
        }

        long querySquares(
            int node,
            int left,
            int right,
            int queryLeft,
            int queryRight
        ) {
            if (queryLeft <= left && right <= queryRight) {
                return sumSquares[node];
            }
            push(node, left, right);
            int mid = left + (right - left) / 2;
            long result = 0;
            if (queryLeft <= mid) {
                result = (
                    result + querySquares(
                        node * 2, left, mid, queryLeft, queryRight
                    )
                ) % MOD;
            }
            if (queryRight > mid) {
                result = (
                    result + querySquares(
                        node * 2 + 1, mid + 1, right,
                        queryLeft, queryRight
                    )
                ) % MOD;
            }
            return result;
        }
    }
}