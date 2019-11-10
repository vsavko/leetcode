public static int lengthOfLongestSubstring(String s) {
			char c;
			int [] hashmap = new int[Character.MAX_VALUE];
			int maxLength = 0;
			int length = 0;
			Arrays.fill(hashmap, -1);
			int phraseCounter = 0;
			LinkedList<Short> queue = new LinkedList<Short>();

			
			for(int j = 0; j < s.length(); j++) {
				c = s.charAt(j);
				queue.add(length,(short)c);

				if (hashmap[(short)c] != -1 ) {
					phraseCounter = hashmap[(short)c];
					length = j - phraseCounter;
					
					while ( queue.get(0) != (short)c) {
						hashmap[queue.get(0)] = -1;
						queue.remove(0);
					}
					
					queue.remove(0);
					
				}
				else 
					++length;	
				
				hashmap[(short)c] = j;

				if (length > maxLength) maxLength = length;

			}
			
			return maxLength;
		}
		
	    public static int lengthOfLongestSubstring2(String s) {
	        int n = s.length();
	        Set<Character> set = new HashSet<>();
	        int ans = 0, i = 0, j = 0;
	        while (i < n && j < n) {
	            // try to extend the range [i, j]
	            if (!set.contains(s.charAt(j))){
	                set.add(s.charAt(j++));
	                ans = Math.max(ans, j - i);
	            }
	            else {
	            	System.out.println(i + " " + s.charAt(i));
	                set.remove(s.charAt(i++));
	            }
	        }
	        return ans;
	    }
