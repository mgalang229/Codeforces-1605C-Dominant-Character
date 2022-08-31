import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

/*

whole string contains only a, b, and c

find length of the smallest substring:
- at least 2
- a > b (in terms of frequency)
- a > c (in terms of frequency)

b and c can be zero, but a must have a value

allowed:
a > 0
b == 0 and c == 0

not allowed:
a == 1
b > 0 or c > 0

if a > b and a > c:
value of a = max(b, c) + 1

possible to have an answer if either b or c is missing (but not both)

we need to find aa in order to have an answer of 2
we need to find aba or aca in order to have an answer of 3

Test cases:

sample: cbaaaaaaabbbcc
answer: aa

sample: cacabccc
answer: [aca]

sample: bbbbacacbaaa
answer: [aca, baa]

sample: ababcbbaacab
answer: [aba, aac, baa, aca]

sample: bbcbbbcbabbaccccbaba
answer: [aba]

sample: bbabbbbacbacccbccbaa
answer: [aa]

sample: accabbaccabba
answer: [accabba]

sample: cabcbbbccabbaccabccb
answer: [abbacca]

 */

public class AuthorSol {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			char[] s = fs.next().toCharArray();
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				int[] freq = new int[3];
				Arrays.fill(freq, 0);
				freq[s[i]-'a']++;
				for (int j = i + 1; j < Math.min(n, i + 7); j++) {
					freq[s[j]-'a']++;
					if (freq[0] > freq[1] && freq[0] > freq[2]) {
						ans = Math.min(ans, j - i + 1);
					}
				}
			}
			out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		}
		out.close();
	}
	
	static final Random rnd = new Random();
	
	static void shuffleSort(char[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newIndex = rnd.nextInt(n);
			char temp = a[newIndex]; //change this
			a[newIndex] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newIndex = rnd.nextInt(n);
			int temp = a[newIndex]; //change this
			a[newIndex] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
