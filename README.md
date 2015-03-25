BitBoolean
==========

BitBoolean is a data type for representing booleans in byte format.

The boolean primitive type in Java uses one byte of memory, BitBoolean allows you to to use just one bit of memory for each boolean represented.
	
However it only does this in multiples of eight. So if you wanted to represent just one boolean, it would still use one byte of memory. But if you wanted to represent four booleans, it would still just use one byte of memory. Eight booleans would take two bytes, and so on.
