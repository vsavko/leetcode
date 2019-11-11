	public static int myAtoi(String str) {
	      int charcount =0, sign = 1, num = 0, len = str.length();
	      int c = 0; //so it doesn't give warnings
	      if (len == 0) return 0;
	      
	      //skip spaces
	      while( charcount < len) {
	    	  c = (int)str.charAt(charcount++);  
	    	  if (c != ' ' ) {
	    		  break;
	    	  }
	      }

	      //chose what to do with first character
	      if ( (c < '0' || c > '9') && c != '+' && c != '-')
	    	  return 0;
	      else if(c == '-')
	    	  sign = -1;
	      else if(c >= '0' && c <= '9')
	    	  --charcount;
	      c = '0';
	      
	      //iterate through the rest of the number
	      while(charcount < len && c >= '0' && c <= '9') { 
	    	  c = (int)str.charAt(charcount++);
	    	  if (c >= '0' && c <= '9') {
		    	  if ( sign == 1 && (num > Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && c > '7')))
		    		  return Integer.MAX_VALUE;
		    	  if ( sign == -1 && (-num < Integer.MIN_VALUE/10 || (-num == Integer.MIN_VALUE/10 && c > '8')))
		    		  return Integer.MIN_VALUE;
		    	  num = num * 10 + (c - 48);
	    	  }
	      }
	      return num * sign;
	}
